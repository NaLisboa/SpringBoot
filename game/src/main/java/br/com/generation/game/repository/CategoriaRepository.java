package br.com.generation.game.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.generation.game.model.CategoriaModel;

@Repository //explicando o que cada camada tá fazendo
public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {
	
	public List<CategoriaModel> findAllByGeneroContainingIgnoreCase(String genero);

}
