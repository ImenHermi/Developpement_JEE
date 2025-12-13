import { Component } from '@angular/core';
import { PatientFormComponent } from './components/patient/patient-form/patient-form.component';
import { PatientListComponent } from './components/patient/patient-list/patient-list.component';

@Component({
  selector: 'app-root',
  standalone: true,  // ✅ important
  imports: [
    PatientFormComponent,
    PatientListComponent
  ],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {}
