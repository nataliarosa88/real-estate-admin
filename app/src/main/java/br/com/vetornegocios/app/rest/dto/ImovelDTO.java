package br.com.vetornegocios.app.rest.dto;

import br.com.vetornegocios.app.model.entity.Endereco;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
public class ImovelDTO {

    private Integer id;
    @NotEmpty(message = "{campo.titulo.obrigatorio}")
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
    @Valid
    @NotNull(message = "{campo.tipo.obrigatorio}")
    private TipoDTO tipo;
    @Valid
    @NotNull(message = "{campo.proprietario.obrigatorio}")
    private ProprietarioDTO proprietario;

}
