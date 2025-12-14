import { Component } from '@angular/core';
import { RendezvousFormComponent } from './components/rendezvous/rendezvous-form/rendezvous-form.component';
import { RendezvousListComponent } from './components/rendezvous/rendezvous-list/rendezvous-list.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RendezvousFormComponent,
    RendezvousListComponent
  ],
  templateUrl: './app.html'
})
export class AppComponent {}


