import { Component, OnInit } from '@angular/core';
import { Imovel } from '../imovel'
import { ImoveisService } from '../../imoveis.service';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { Observable } from 'rxjs';
import { Proprietario } from '../../proprietarios/proprietario';
import { ProprietariosService } from '../../proprietarios.service';
<<<<<<< Updated upstream
=======
import { TiposService } from '../../tipos.service';

>>>>>>> Stashed changes

@Component({
  selector: 'app-imoveis-form',
  templateUrl: './imoveis-form.component.html',
  styleUrls: ['./imoveis-form.component.css']
})
export class ImoveisFormComponent implements OnInit {

<<<<<<< Updated upstream
=======
  public myModel = '';
  public mask = [ /\d/, /\d/, /\d/, /\d/, /\d/, '-', /\d/, /\d/, /\d/];
>>>>>>> Stashed changes
  imovel: Imovel;
  proprietarios: Proprietario[] = [];
  success: boolean = false;
  errors: String[];
  id: number;
  constructor(
      private service : ImoveisService,
      private router : Router,
      private proprietariosService: ProprietariosService,
      private activatedRoute: ActivatedRoute
      ) {
          this.imovel = new Imovel();
        }

  ngOnInit(): void {
    this.proprietariosService
    .getProprietarios()
    .subscribe(
      response => this.proprietarios = response );
    let params : Observable<Params> = this.activatedRoute.params
    params.subscribe( urlParams => {
      this.id = urlParams['id']
      if(this.id){
        this.service
              .getImovelById(this.id)
              .subscribe(
                response => this.imovel = response ,
                errorResponse => this.imovel = new Imovel()
              )
      }
    })
  }

  voltarParaListagem(){
    this.router.navigate(['/imoveis-lista'])
  }

  onSubmit(){

    if( this.id ) {

      this.service
        .atualizar(this.imovel)
        .subscribe(response => {
<<<<<<< Updated upstream
          console.log("ENTREI AQUI NO UPDATE");
=======
>>>>>>> Stashed changes
          this.success =true;
          this.errors = null;
        }, errorResponse => {
          this.errors = ['erro ao atualizar o imovel.']
        })

    } else {
      this.service
      .salvar(this.imovel)
      .subscribe(
        response => {
          this.success = true;
          this.errors = null;
          this.imovel = response;

        } , errorResponse => {
            this.errors = errorResponse.error.errors;
        }
      )
    }
  }
}
