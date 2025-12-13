import { Routes } from '@angular/router';
import { MedecinsListComponent } from './components/medecin/medecins-list/medecins-list';
import { MedecinFormComponent } from './components/medecin/medecin-form/medecin-form';

export const routes: Routes = [
  { path: '', redirectTo: 'medecins', pathMatch: 'full' },
  { path: 'medecins', component: MedecinsListComponent },
  { path: 'medecins/create', component: MedecinFormComponent },
  { path: 'medecins/:id/edit', component: MedecinFormComponent },
];
