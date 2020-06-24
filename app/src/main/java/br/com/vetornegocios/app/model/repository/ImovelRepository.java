package br.com.vetornegocios.app.model.repository;

import br.com.vetornegocios.app.model.entity.Imovel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImovelRepository extends JpaRepository<Imovel, Integer> {
}
