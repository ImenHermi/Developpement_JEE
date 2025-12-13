import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PatientService } from '../../../services/patient';
import { Patient } from '../../../models/patient.model';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-patient-list',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './patient-list.html',
  styleUrls: ['./patient-list.css']
})
export class PatientListComponent implements OnInit {

  patients: Patient[] = [];
  patientEnEdition: Patient | null = null;

  constructor(private patientService: PatientService) {}

  ngOnInit(): void {
    this.chargerPatients();
  }

  // 🔥 Charger depuis backend
  chargerPatients() {
    this.patientService.getPatients().subscribe(data => {
      this.patients = data;
    });
  }

  supprimerPatient(id?: number) {
    if (!id) return;
    this.patientService.deletePatient(id).subscribe(() => {
      this.chargerPatients(); // rafraîchit liste
    });
  }

  modifierPatient(patient: Patient) {
    this.patientEnEdition = { ...patient };
  }

  annuler() {
    this.patientEnEdition = null;
  }

  sauvegarderModif() {
    if (!this.patientEnEdition) return;

    this.patientService.updatePatient(this.patientEnEdition).subscribe(() => {
      this.chargerPatients();   // recharge depuis backend
      this.patientEnEdition = null;
    });
  }
}
