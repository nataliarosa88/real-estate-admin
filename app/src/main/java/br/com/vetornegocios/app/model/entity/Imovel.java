package br.com.vetornegocios.app.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Imovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    @NotEmpty(message = "{campo.titulo.obrigatorio}")
    private String titulo;

    @Column(length = 254)
    private String descricao;

    @Column(length = 254)
    private String preco;

    @Column(length = 254)
    private String condominio;

    @Column(length = 254)
    private String comissao;

    @Column(length = 254)
    private String dormitorios;

    @Column(length = 254)
    private String banheiros;

    @Column(length = 254)
    private String suites;

    @Column(length = 254)
    private String quintal;

    @Column(length = 254)
    private String frente;

    @Column(length = 254)
    private String tamanho;

    @Column(length = 254)
    private String extra;

    @Column(name = "data_cadastro", updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="endereco_id", referencedColumnName = "id")
    private Endereco endereco;

    @ManyToOne
    @JoinColumn(name = "proprietario_id")
    private Proprietario proprietario;

    @PrePersist
    public void prePersist(){
        setDataCadastro(LocalDate.now());
    }
}
