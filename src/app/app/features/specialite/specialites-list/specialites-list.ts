import { Component, computed, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { SpecialiteService } from '../../../services/specialite';
import { Specialite } from '../../../models/specialite.model';

@Component({
  selector: 'app-specialites-list',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './specialites-list.html',
  styleUrls: ['./specialites-list.scss']
})
export class SpecialitesListComponent {
  loading = signal(false);
  error = signal<string | null>(null);
  specialites = signal<Specialite[]>([]);
  q = signal('');

  filtered = computed(() => {
    const s = this.q().toLowerCase().trim();
    if (!s) return this.specialites();
    return this.specialites().filter(x =>
      (x.nom ?? '').toLowerCase().includes(s) ||
      (x.code ?? '').toLowerCase().includes(s)
    );
  });

  constructor(private api: SpecialiteService) {}

  ngOnInit() { this.load(); }

  load() {
    this.loading.set(true);
    this.api.getAll().subscribe({
      next: (items) => { this.specialites.set(items); this.loading.set(false); },
      error: (e) => { this.error.set(String(e)); this.loading.set(false); }
    });
  }

  delete(id: number) {
    if (!confirm('Supprimer cette spécialité ?')) return;
    this.api.remove(id).subscribe({
      next: () => this.load(),
      error: (e) => this.error.set(String(e))
    });
  }
}
