import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Specialite } from '../models/specialite.model';

@Injectable({ providedIn: 'root' })
export class SpecialiteService {
  // 👉 adapte l’URL si besoin (proxy Angular ou backend JEE)
  private baseUrl = 'http://localhost:9092/api/specialites';

  constructor(private http: HttpClient) {}

  getAll(): Observable<Specialite[]> {
    return this.http.get<Specialite[]>(this.baseUrl);
  }

  getById(id: number): Observable<Specialite> {
    return this.http.get<Specialite>(`${this.baseUrl}/${id}`);
  }

  create(payload: Omit<Specialite, 'id'>): Observable<Specialite> {
    return this.http.post<Specialite>(this.baseUrl, payload);
  }

  update(id: number, payload: Partial<Specialite>): Observable<Specialite> {
    return this.http.put<Specialite>(`${this.baseUrl}/${id}`, payload);
  }

  remove(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
}
