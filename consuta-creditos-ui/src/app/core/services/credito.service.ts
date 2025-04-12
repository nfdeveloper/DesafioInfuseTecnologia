import { Injectable } from '@angular/core';
import { environment } from '../../environments/enviroment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Credito } from '../model/credito.model';

@Injectable({
  providedIn: 'root'
})
export class CreditoService {

  private readonly creditoEndPoint: String = `${environment.apiBaseUrl}/creditos`

  constructor(private http: HttpClient) { }

  listarPorCredito(numeroCredito: string): Observable<Credito> {
    return this.http.get<Credito>(`${this.creditoEndPoint}/credito/${numeroCredito}`)
  }

  listarPorNumeroNfse(numeroNfse: string): Observable<Credito[]> {
    return this.http.get<Credito[]>(`${this.creditoEndPoint}/${numeroNfse}`)
  }
}
