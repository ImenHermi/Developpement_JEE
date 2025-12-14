import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RendezVous } from '../../../models/rendezvous.model';
import { RendezvousService } from '../../../services/rendezvous';

@Component({
  selector: 'app-rendezvous-list',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './rendezvous-list.html',
  styleUrls: ['./rendezvous-list.css']
})
export class RendezvousListComponent implements OnInit {

  rendezvous: RendezVous[] = [];
  rdvEnEdition: RendezVous | null = null;

  constructor(private rendezvousService: RendezvousService) {}

  ngOnInit(): void {
    this.charger();
  }

  // 🔄 Charger les rendez-vous
  charger() {
    this.rendezvousService.getAll().subscribe({
      next: (data) => {
        this.rendezvous = data;
        console.log('📋 Rendez-vous chargés:', data);
      },
      error: (err) => {
        console.error(err);
        alert('❌ Erreur chargement');
      }
    });
  }

  // ✏️ Modifier
  modifier(rdv: RendezVous) {
    console.log('🟢 Modifier cliqué', rdv);

    this.rdvEnEdition = {
      id: rdv.id!,
      date: rdv.date.substring(0, 16), // compatible datetime-local
      statut: rdv.statut,
      patient: rdv.patient,
      medecin: rdv.medecin
    };
  }

  // 🚫 Annuler
  annuler() {
    this.rdvEnEdition = null;
  }

  // 💾 Sauvegarder
  sauvegarder() {
    if (!this.rdvEnEdition) return;

    const dateBackend =
      this.rdvEnEdition.date.replace('T', ' ') + ':00';

    const payload = {
      date: dateBackend,
      statut: this.rdvEnEdition.statut,
      patient: { id: this.rdvEnEdition.patient.id },
      medecin: { id: this.rdvEnEdition.medecin.id }
    };

    console.log('📤 Payload UPDATE:', payload);

    this.rendezvousService
      .update(this.rdvEnEdition.id!, payload)
      .subscribe({
        next: () => {
          alert('✅ Rendez-vous modifié');
          this.rdvEnEdition = null;
          this.charger();
        },
        error: (err) => {
          console.error(err);
          alert('❌ Erreur serveur');
        }
      });
  }

  // 🗑️ Supprimer
  supprimer(id?: number) {
    if (!id) return;

    if (!confirm('Supprimer ce rendez-vous ?')) return;

    this.rendezvousService.delete(id).subscribe({
      next: () => {
        alert('✅ Supprimé');
        this.charger();
      },
      error: () => {
        alert('❌ Erreur suppression');
      }
    });
  }
}
