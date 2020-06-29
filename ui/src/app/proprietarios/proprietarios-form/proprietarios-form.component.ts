import { Component, OnInit } from '@angular/core';
import { Proprietario } from '../proprietario'
import { ProprietariosService } from '../../proprietarios.service';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-proprietarios-form',
  templateUrl: './proprietarios-form.component.html',
  styleUrls: ['./proprietarios-form.component.css']
})
export class ProprietariosFormComponent implements OnInit {
  public myModel = '';
  public maskMobile = ['(', /[1-9]/, /\d/, ')', ' ', /\d/, /\d/, /\d/, /\d/, /\d/, '-', /\d/, /\d/, /\d/, /\d/];
  public maskPhone = ['(', /[1-9]/, /\d/, ')', ' ', /\d/, /\d/, /\d/, /\d/, /\d/, '-', /\d/, /\d/, /\d/, /\d/];
  proprietario: Proprietario;
  success: boolean = false;
  errors: String[];
  id: number;
  constructor(
      private service : ProprietariosService,
      private router : Router,
      private activatedRoute: ActivatedRoute
      ) {
    this.proprietario = new Proprietario();
   }

  ngOnInit(): void {
    let params : Observable<Params> = this.activatedRoute.params
    params.subscribe( urlParams => {
      this.id = urlParams['id']
      if(this.id){
        this.service
              .getProprietarioById(this.id)
              .subscribe(
                response => this.proprietario = response ,
                errorResponse => this.proprietario = new Proprietario()
              )
      }
    })
  }

  voltarParaListagem(){
    this.router.navigate(['/proprietarios-lista'])
  }

  onSubmit(){
    if( this.id ) {

      this.service
        .atualizar(this.proprietario)
        .subscribe(response => {
          this.success =true;
          this.errors = null;
        }, errorResponse => {
          this.errors = ['erro ao atualizar o proprietario.']
        })

    } else {
      this.service
      .salvar(this.proprietario)
      .subscribe(
        response => {
          this.success = true;
          this.errors = null;
          this.proprietario = response;
        } , errorResponse => {
            this.errors = errorResponse.error.errors;
        }
      )
    }
  }



}
