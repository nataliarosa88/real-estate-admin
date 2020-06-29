package br.com.vetornegocios.app.rest.dto;

import br.com.vetornegocios.app.model.entity.Endereco;
import br.com.vetornegocios.app.model.entity.Proprietario;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ImovelDTO {

    private Integer id;
    private String titulo;
    private String descricao;
    private String preco;
    private String condominio;
    private String comissao;
    private String dormitorios;
    private String banheiros;
    private String suites;
    private String quintal;
    private String frente;
    private String tamanho;
    private String extra;
    private Endereco endereco;
    private Proprietario proprietario;

}
