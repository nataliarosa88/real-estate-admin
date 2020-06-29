package br.com.vetornegocios.app.model.repository;

import br.com.vetornegocios.app.model.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository  extends JpaRepository<Endereco, Integer> {
}
