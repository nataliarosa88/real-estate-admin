import { Injectable } from '@angular/core';
import { Imovel } from './imoveis/imovel';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ImoveisService {
  baseUrl = environment.baseUrl;

  constructor( private http: HttpClient ) {

  }

  salvar( imovel: Imovel ) : Observable<Imovel>{
    return this.http.post<Imovel>(this.baseUrl + '/imoveis', imovel);
  }

  atualizar( imovel: Imovel ) : Observable<any>{
    return this.http.put<Imovel>(this.baseUrl + `/imoveis/${imovel.id}`, imovel);
  }

  getImoveis() : Observable<Imovel[]> {
    return this.http.get<Imovel[]>(this.baseUrl + '/imoveis');
  }

  getImovelById(id: number){
    return this.http.get<any>(this.baseUrl + `/imoveis/${id}`);
  }

  deletar(imovel: Imovel) : Observable<any> {
    return this.http.delete<any>(this.baseUrl + `/imoveis/${imovel.id}`);
  }

}
