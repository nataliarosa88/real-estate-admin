package br.com.vetornegocios.app.model.repository;

import br.com.vetornegocios.app.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
