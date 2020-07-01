package br.com.vetornegocios.app.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProprietarioDTO {

    @NotNull(message = "{campo.proprietario.obrigatorio}")
    private Integer id;
    private String nome;
    private String email;
    private String telefone;
    private String celular;
}
