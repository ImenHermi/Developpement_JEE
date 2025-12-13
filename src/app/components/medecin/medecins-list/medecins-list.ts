import { Component, OnInit, signal, computed } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterModule } from '@angular/router';
import { MedecinService } from '../../../services/medecin';
import { Medecin } from '../../../models/medecin.model';

@Component({
  selector: 'app-medecins-list',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './medecins-list.html',
styleUrls: ['./medecins-list.scss']})
export class MedecinsListComponent implements OnInit {
  medecins = signal<Medecin[]>([]);
  count = computed(() => this.medecins().length);

  constructor(private srv: MedecinService, private router: Router) {}

  ngOnInit(): void {
    this.load();
  }

  load() {
    this.srv.getAll().subscribe(data => this.medecins.set(data));
  }

  edit(m: Medecin) {
    this.router.navigate(['/medecins', m.id, 'edit']);
  }

  remove(m: Medecin) {
    if (!m.id) return;
    if (!confirm(`Supprimer ${m.nom} ?`)) return;
    this.srv.remove(m.id).subscribe(() => this.load());
  }
}
