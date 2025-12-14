import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RendezvousService } from '../../../services/rendezvous';
import { RendezVous } from '../../../models/rendezvous.model';

@Component({
  selector: 'app-rendezvous-form',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './rendezvous-form.html',
  styleUrls: ['./rendezvous-form.css']
})
export class RendezvousFormComponent {

  date: string = ''; // yyyy-MM-ddTHH:mm
  statut: string = 'prévu';
  patientId!: number;
  medecinId!: number;

  constructor(private rendezvousService: RendezvousService) {}

  ajouterRendezVous() {

    if (!this.date || !this.patientId || !this.medecinId) {
      alert('Veuillez remplir tous les champs');
      return;
    }

    const rdv: RendezVous = {
      date: this.date,
      statut: this.statut,
      patient: { id: this.patientId },
      medecin: { id: this.medecinId }
    };

    this.rendezvousService.create(rdv).subscribe({
      next: () => {
        alert('✅ Rendez-vous ajouté avec succès');
        this.date = '';
        this.statut = 'prévu';
        this.patientId = undefined!;
        this.medecinId = undefined!;
      },
      error: (err) => {
        console.error(err);
        alert('❌ Erreur lors de l’ajout');
      }
    });
  }
}
