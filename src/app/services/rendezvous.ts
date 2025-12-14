import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { RendezVous } from '../models/rendezvous.model';

@Injectable({
  providedIn: 'root'
})
export class RendezvousService {

  private apiUrl = 'http://localhost:9092/api/rendezvous';

  constructor(private http: HttpClient) {}

  getAll(): Observable<RendezVous[]> {
    return this.http.get<RendezVous[]>(this.apiUrl);
  }

  create(rdv: any): Observable<RendezVous> {
    return this.http.post<RendezVous>(this.apiUrl, rdv);
  }

  // ✅ TRÈS IMPORTANT : id dans l’URL
 update(id: number, rdv: any) {
  return this.http.put(`${this.apiUrl}/${id}`, rdv);
}

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
