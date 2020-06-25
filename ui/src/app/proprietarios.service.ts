import { Injectable } from '@angular/core';
import { Proprietario } from './proprietarios/proprietario';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProprietariosService {
  baseUrl = environment.baseUrl;

  constructor( private http: HttpClient ) {

  }

  salvar( proprietario: Proprietario ) : Observable<Proprietario>{
    return this.http.post<Proprietario>(this.baseUrl + '/proprietarios', proprietario);
  }

  atualizar( proprietario: Proprietario ) : Observable<any>{
    return this.http.put<Proprietario>(this.baseUrl + `/proprietarios/${proprietario.id}`, proprietario);
  }

  getProprietarios() : Observable<Proprietario[]> {
    return this.http.get<Proprietario[]>(this.baseUrl + '/proprietarios');
  }

  getProprietarioById(id: number){
    return this.http.get<any>(this.baseUrl + `/proprietarios/${id}`);
  }

  deletar(proprietario: Proprietario) : Observable<any> {
    return this.http.delete<any>(this.baseUrl + `/proprietarios/${proprietario.id}`);
  }

}
