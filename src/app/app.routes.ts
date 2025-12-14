import { Routes } from '@angular/router';

import { SpecialitesListComponent } from './app/features/specialite/specialites-list/specialites-list';
import { SpecialiteFormComponent } from './app/features/specialite/specialite-form/specialite-form';
import { SpecialiteDetailsComponent } from './app/features/specialite/specialite-details/specialite-details';

export const routes: Routes = [
  { path: '', redirectTo: 'specialites', pathMatch: 'full' },
  { path: 'specialites', component: SpecialitesListComponent },
  { path: 'specialites/new', component: SpecialiteFormComponent },
  { path: 'specialites/:id/edit', component: SpecialiteFormComponent },
  { path: 'specialites/:id', component: SpecialiteDetailsComponent }
];
