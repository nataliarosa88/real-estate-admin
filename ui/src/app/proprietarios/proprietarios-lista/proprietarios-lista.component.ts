import { Component, OnInit } from '@angular/core';
import { ProprietariosService } from 'src/app/proprietarios.service';
import { Proprietario } from '../proprietario';
import { Router } from '@angular/router'

@Component({
  selector: 'app-proprietarios-lista',
  templateUrl: './proprietarios-lista.component.html',
  styleUrls: ['./proprietarios-lista.component.css']
})
export class ProprietariosListaComponent implements OnInit {

  proprietarios: Proprietario[] = [];
  proprietarioSelecionado: Proprietario;
  mensagemSucesso: string;
  mensagemErro: string;
  filter:string;
  constructor(
    private service: ProprietariosService,
     private router: Router) { }

  ngOnInit(): void {
     this.service
     .getProprietarios()
     .subscribe( resposta =>
      this.proprietarios = resposta );
  }

  novoCadastro(){
    this.router.navigate(['/proprietarios-form'])
  }

  preparaDelecao(proprietario : Proprietario){
      this.proprietarioSelecionado = proprietario;
  }

  deletarProprietario(){
    this.service
    .deletar(this.proprietarioSelecionado)
    .subscribe(
      response => {
        this.mensagemSucesso = 'Proprietario deletado com sucesso!'
        this.ngOnInit();
      },
      erro => this.mensagemErro = 'Ocorreu um erro ao deletar o proprietario.'
    )
  }
}
