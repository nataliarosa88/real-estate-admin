import { Endereco } from '../shared/endereco';

export class Imovel {
  id: number;
  titulo: string;
  descricao: string;
  preco:string;
  comissao:string;
  dormitorios:string;
  suites:string;
  quintal:string;
  frente:string;
  tamanho:string;
  extra:string;
  dataCadastro: string;
  endereco = new Endereco();
}
