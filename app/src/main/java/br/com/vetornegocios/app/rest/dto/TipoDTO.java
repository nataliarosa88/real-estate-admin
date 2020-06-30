package br.com.vetornegocios.app.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoDTO {

    @NotNull(message = "{campo.tipo.obrigatorio}")
    private Integer id;

    @Column(nullable = false, length = 150)
    private String nome;

}
