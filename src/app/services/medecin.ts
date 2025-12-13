import { Injectable, signal } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Medecin } from '../models/medecin.model';
import { environment } from '../environment';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class MedecinService {
  private base = environment.apiUrl + environment.medecinPrefix;
  loading = signal(false);
private apiUrl = "http://localhost:9092/api/medecins"; 

  constructor(private http: HttpClient) {}

  getAll(): Observable<Medecin[]> {
    return this.http.get<Medecin[]>(this.base);
  }

  getById(id: number): Observable<Medecin> {
    return this.http.get<Medecin>(`${this.base}/${id}`);
  }

  create(body: Medecin): Observable<Medecin> {
    return this.http.post<Medecin>(this.base, body);
  }

  update(id: number, body: Medecin): Observable<Medecin> {
    return this.http.put<Medecin>(`${this.base}/${id}`, body);
  }

  remove(id: number): Observable<void> {
    return this.http.delete<void>(`${this.base}/${id}`);
  }
}
