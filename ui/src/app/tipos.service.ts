import { Injectable } from '@angular/core';
import { Tipo } from './tipos/tipo';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class TiposService {
  baseUrl = environment.baseUrl;

  constructor( private http: HttpClient ) {

  }

  salvar( tipo: Tipo ) : Observable<Tipo>{
    return this.http.post<Tipo>(this.baseUrl + '/tipos', tipo);
  }

  atualizar( tipo: Tipo ) : Observable<any>{
    return this.http.put<Tipo>(this.baseUrl + `/tipos/${tipo.id}`, tipo);
  }

  getTipos() : Observable<Tipo[]> {
    return this.http.get<Tipo[]>(this.baseUrl + '/tipos');
  }

  getTipoById(id: number){
    return this.http.get<any>(this.baseUrl + `/tipos/${id}`);
  }

  deletar(tipo: Tipo) : Observable<any> {
    return this.http.delete<any>(this.baseUrl + `/tipos/${tipo.id}`);
  }

}
