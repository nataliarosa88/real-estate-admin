package br.com.vetornegocios.app.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String rua;

    @Column(length = 10)
     private String numero;

    @Column(length = 10)
    private String complemento;

    @Column(length = 200)
    private String bairro;

    @Column(length = 200)
    private String cidade;

    @Column(length = 20)
    private String cep;

    @Column(name = "data_cadastro", updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;

    @JsonIgnore
    @OneToOne(mappedBy = "endereco")
    private Imovel imovel;

    @PrePersist
    public void prePersist(){
        setDataCadastro(LocalDate.now());
    }
}
