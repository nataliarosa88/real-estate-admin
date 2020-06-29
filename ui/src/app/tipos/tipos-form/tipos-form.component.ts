import { Component, OnInit } from '@angular/core';
import { Tipo } from '../tipo'
import { TiposService } from '../../tipos.service';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-tipos-form',
  templateUrl: './tipos-form.component.html',
  styleUrls: ['./tipos-form.component.css']
})
export class TiposFormComponent implements OnInit {
  public myModel = '';
  public maskMobile = ['(', /[1-9]/, /\d/, ')', ' ', /\d/, /\d/, /\d/, /\d/, /\d/, '-', /\d/, /\d/, /\d/, /\d/];
  public maskPhone = ['(', /[1-9]/, /\d/, ')', ' ', /\d/, /\d/, /\d/, /\d/, /\d/, '-', /\d/, /\d/, /\d/, /\d/];
  tipo: Tipo;
  success: boolean = false;
  errors: String[];
  id: number;
  constructor(
      private service : TiposService,
      private router : Router,
      private activatedRoute: ActivatedRoute
      ) {
    this.tipo = new Tipo();
   }

  ngOnInit(): void {
    let params : Observable<Params> = this.activatedRoute.params
    params.subscribe( urlParams => {
      this.id = urlParams['id']
      if(this.id){
        this.service
              .getTipoById(this.id)
              .subscribe(
                response => this.tipo = response ,
                errorResponse => this.tipo = new Tipo()
              )
      }
    })
  }

  voltarParaListagem(){
    this.router.navigate(['/tipos-lista'])
  }

  onSubmit(){
    if( this.id ) {

      this.service
        .atualizar(this.tipo)
        .subscribe(response => {
          this.success =true;
          this.errors = null;
        }, errorResponse => {
          this.errors = ['erro ao atualizar o tipo.']
        })

    } else {
      this.service
      .salvar(this.tipo)
      .subscribe(
        response => {
          this.success = true;
          this.errors = null;
          this.tipo = response;
        } , errorResponse => {
            this.errors = errorResponse.error.errors;
        }
      )
    }
  }



}
