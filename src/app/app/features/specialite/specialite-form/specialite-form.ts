import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { SpecialiteService } from '../../../services/specialite';

@Component({
  selector: 'app-specialite-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, RouterModule],
  templateUrl: './specialite-form.html',
  styleUrls: ['./specialite-form.scss']
})
export class SpecialiteFormComponent implements OnInit {
  form!: FormGroup;
  id: number | null = null;

  constructor(
    private fb: FormBuilder,
    private api: SpecialiteService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.form = this.fb.group({
      code: ['', [Validators.maxLength(20)]],
      nom: ['', [Validators.required, Validators.minLength(2)]],
      description: [''],
      actif: [true]
    });

    // Vérifie si on édite une spécialité existante
    const paramId = this.route.snapshot.paramMap.get('id');
    if (paramId && paramId !== 'new') {
      this.id = Number(paramId);
      this.api.getById(this.id).subscribe(sp => this.form.patchValue(sp));
    }
  }

  submit(): void {
    if (this.form.invalid) {
      this.form.markAllAsTouched();
      return;
    }

    const data = this.form.value;

    if (this.id) {
      // 🔹 Mise à jour
      this.api.update(this.id, data).subscribe({
        next: () => this.router.navigate(['/specialites']),
        error: (err) => console.error('Erreur lors de la mise à jour :', err)
      });
    } else {
      // 🔹 Création
      this.api.create(data).subscribe({
        next: () => this.router.navigate(['/specialites']),
        error: (err) => console.error('Erreur lors de la création :', err)
      });
    }
  }
}
