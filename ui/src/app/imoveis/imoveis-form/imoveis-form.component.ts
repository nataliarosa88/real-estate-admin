import { Component, OnInit } from '@angular/core';
import { Imovel } from '../imovel'
import { ImoveisService } from '../../imoveis.service';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { Observable } from 'rxjs';
import { Proprietario } from '../../proprietarios/proprietario';
import { Tipo } from '../../tipos/tipo';
import { ProprietariosService } from '../../proprietarios.service';
import { TiposService } from '../../tipos.service';
import { Validators, FormControl, FormGroup } from '@angular/forms';


@Component({
  selector: 'app-imoveis-form',
  styleUrls: ['./imoveis-form.component.css'],
  templateUrl: './imoveis-form.component.html'
})
export class ImoveisFormComponent implements OnInit {
  public form = new Imovel();
  public myModel = '';
  public mask = [ /\d/, /\d/, /\d/, /\d/, /\d/, '-', /\d/, /\d/, /\d/];
  imovel: Imovel;
  proprietarios: Proprietario[] = [];
  tipos: Tipo[] = [];
  success: boolean = false;
  errors: String[];
  id: number;

  public tituloForm: FormGroup;

  constructor(
      private service : ImoveisService,
      private router : Router,
      private proprietariosService: ProprietariosService,
      private tiposService: TiposService,
      private activatedRoute: ActivatedRoute
      ) {
          this.imovel = new Imovel();
        }

  ngOnInit(): void {
    this.proprietariosService
    .getProprietarios()
    .subscribe(
      response => this.proprietarios = response );
      this.tiposService
      .getTipos()
      .subscribe(
        response => this.tipos = response );
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
    this.tituloForm = new FormGroup({
      'titulo': new FormControl(this.form.titulo, [Validators.required])});
      this.createForm(new Imovel());
  }

  voltarParaListagem(){
    this.router.navigate(['/imoveis-lista'])
  }

  createForm(imovel: Imovel) {
    this.tituloForm = new FormGroup({
      titulo: new FormControl(imovel.titulo)
    })
  }

  onSubmit(){

    if( this.id ) {

      this.service
        .atualizar(this.imovel)
        .subscribe(response => {
          console.log("ENTREI NO UPDATE");
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
          console.log("ENTREI NO SALVAR");
        } , errorResponse => {
            this.errors = errorResponse.error.errors;
        }
      )
    }
  }
}
