import { Component, OnInit } from '@angular/core';
import { ImoveisService } from 'src/app/imoveis.service';
import { Imovel } from '../imovel';
import { Router } from '@angular/router'

@Component({
  selector: 'app-imoveis-lista',
  templateUrl: './imoveis-lista.component.html',
  styleUrls: ['./imoveis-lista.component.css']
})
export class ImoveisListaComponent implements OnInit {

  imoveis: Imovel[] = [];
  imovelSelecionado: Imovel;
  mensagemSucesso: string;
  mensagemErro: string;
  constructor(
    private service: ImoveisService,
     private router: Router) { }

  ngOnInit(): void {
     this.service
     .getImoveis()
     .subscribe( resposta =>
      this.imoveis = resposta );
  }

  novoCadastro(){
    this.router.navigate(['/imoveis-form'])
  }

  preparaDelecao(imovel : Imovel){
      this.imovelSelecionado = imovel;
  }

  deletarImovel(){
    this.service
    .deletar(this.imovelSelecionado)
    .subscribe(
      response => {
        this.mensagemSucesso = 'Imóvel deletado com sucesso!'
        this.ngOnInit();
      },
      erro => this.mensagemErro = 'Ocorreu um erro ao deletar o imovel.'
    )
  }
}
