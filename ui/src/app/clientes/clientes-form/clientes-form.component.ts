import { Component, OnInit } from '@angular/core';
import { Cliente } from '../cliente'
import { ClientesService } from '../../clientes.service';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { Observable } from 'rxjs';



@Component({
  selector: 'app-clientes-form',
  styleUrls: ['./clientes-form.component.css'],
  templateUrl: './clientes-form.component.html'
})
export class ClientesFormComponent implements OnInit {
  public myModel = '';
  public mask = ['(', /[1-9]/, /\d/, ')', ' ', /\d/, /\d/, /\d/, /\d/, /\d/, '-', /\d/, /\d/, /\d/, /\d/];
  cliente: Cliente;
  success: boolean = false;
  errors: String[];
  id: number;
  constructor(
      private service : ClientesService,
      private router : Router,
      private activatedRoute: ActivatedRoute
      ) {
    this.cliente = new Cliente();
   }

  ngOnInit(): void {
    let params : Observable<Params> = this.activatedRoute.params
    params.subscribe( urlParams => {
      this.id = urlParams['id']
      if(this.id){
        this.service
              .getClienteById(this.id)
              .subscribe(
                response => this.cliente = response ,
                errorResponse => this.cliente = new Cliente()
              )
      }
    })
  }

  voltarParaListagem(){
    this.router.navigate(['/clientes-lista'])
  }

  onSubmit(){
    console.log()
    if( this.id ) {
      this.cliente.telefone;
      this.service
        .atualizar(this.cliente)
        .subscribe(response => {
          this.success =true;
          this.errors = null;
          console.log("ENTREI AQUI NO UPDATE");
        }, errorResponse => {
          this.errors = ['erro ao atualizar o cliente.']
        })

    } else {
      this.service
      .salvar(this.cliente)
      .subscribe(
        response => {
          this.success = true;
          this.errors = null;
          this.cliente = response;
          console.log("ENTREI NO SALVAR");
        } , errorResponse => {
            this.errors = errorResponse.error.errors;
        }
      )
    }
  }



}
