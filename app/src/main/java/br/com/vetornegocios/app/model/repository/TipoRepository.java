package br.com.vetornegocios.app.model.repository;

import br.com.vetornegocios.app.model.entity.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoRepository extends JpaRepository<Tipo, Integer> {
}
