import { Component, signal, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { SpecialiteService } from '../../../services/specialite';
import { Specialite } from '../../../models/specialite.model';

@Component({
  selector: 'app-specialite-details',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './specialite-details.html',
  styleUrls: ['./specialite-details.scss']
})
export class SpecialiteDetailsComponent implements OnInit {

  // Signal qui contient la spécialité
  s = signal<Specialite | null>(null);

  constructor(
    private route: ActivatedRoute,
    private api: SpecialiteService
  ) {}

  ngOnInit(): void {
    const idParam = this.route.snapshot.paramMap.get('id');

    // Sécurité : vérifier que l'id existe
    if (!idParam) {
      return;
    }

    const id = Number(idParam);

    this.api.getById(id).subscribe({
      next: (sp) => this.s.set(sp),
      error: (err) => console.error('Erreur chargement spécialité', err)
    });
  }
}
