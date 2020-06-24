package br.com.vetornegocios.app.model.repository;

import br.com.vetornegocios.app.model.entity.Proprietario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProprietarioRepository extends JpaRepository<Proprietario, Integer> {
}
