import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { PatientService } from '../../../services/patient';
import { Patient } from '../../../models/patient.model';

@Component({
  selector: 'app-patient-form',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './patient-form.html',
  styleUrls: ['./patient-form.css']
})
export class PatientFormComponent {

  nom: string = '';
  email: string = '';

  constructor(private patientService: PatientService) {}

  ajouterPatient() {

    if (!this.nom || !this.email) return;

    const patient: Patient = {
      nom: this.nom,
      email: this.email
    };

    this.patientService.addPatient(patient).subscribe({
      next: () => {
        alert("Patient ajouté !");
        this.nom = '';
        this.email = '';
      },
      error: () => alert("Erreur lors de l'ajout")
    });
  }
}
