import { Component, OnInit } from '@angular/core';
import { TiposService } from 'src/app/tipos.service';
import { Tipo } from '../tipo';
import { Router } from '@angular/router'

@Component({
  selector: 'app-tipos-lista',
  templateUrl: './tipos-lista.component.html',
  styleUrls: ['./tipos-lista.component.css']
})
export class TiposListaComponent implements OnInit {

  tipos: Tipo[] = [];
  tipoSelecionado: Tipo;
  mensagemSucesso: string;
  mensagemErro: string;
  filter:string;
  constructor(
    private service: TiposService,
     private router: Router) { }

  ngOnInit(): void {
     this.service
     .getTipos()
     .subscribe( resposta =>
      this.tipos = resposta );
  }

  novoCadastro(){
    this.router.navigate(['/tipos-form'])
  }

  preparaDelecao(tipo : Tipo){
      this.tipoSelecionado = tipo;
  }

  deletarTipo(){
    this.service
    .deletar(this.tipoSelecionado)
    .subscribe(
      response => {
        this.mensagemSucesso = 'Tipo deletado com sucesso!'
        this.ngOnInit();
      },
      erro => this.mensagemErro = 'Ocorreu um erro ao deletar o tipo.'
    )
  }
}
