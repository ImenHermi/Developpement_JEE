import { Component, OnInit, inject, signal } from '@angular/core';
import { ReactiveFormsModule, FormBuilder, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router, ActivatedRoute, RouterModule } from '@angular/router';
import { MedecinService } from '../../../services/medecin';
import { Medecin } from '../../../models/medecin.model';

@Component({
  selector: 'app-medecin-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, RouterModule],
  templateUrl: './medecin-form.html',
styleUrls: ['./medecin-form.scss'] 
})
export class MedecinFormComponent implements OnInit {
  private fb = inject(FormBuilder);
  private srv = inject(MedecinService);
  private route = inject(ActivatedRoute);
  private router = inject(Router);

  id = signal<number | null>(null);

  form = this.fb.group({
    nom: ['', [Validators.required, Validators.minLength(2)]],
    specialite: ['', Validators.required],
    email: ['', [Validators.required, Validators.email]]
  });

  ngOnInit(): void {
    const param = this.route.snapshot.paramMap.get('id');
    if (param) {
      const id = Number(param);
      this.id.set(id);
      this.srv.getById(id).subscribe(m => this.form.patchValue(m));
    }
  }

  submit() {
    if (this.form.invalid) {
      this.form.markAllAsTouched();
      return;
    }
    const body: Medecin = this.form.value as Medecin;

    if (this.id()) {
      this.srv.update(this.id()!, body).subscribe(() => this.router.navigate(['/medecins']));
    } else {
      this.srv.create(body).subscribe(() => this.router.navigate(['/medecins']));
    }
  }
}
