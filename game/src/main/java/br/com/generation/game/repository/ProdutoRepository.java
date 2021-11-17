package br.com.generation.game.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.generation.game.model.ProdutoModel;

@Repository //explicando o que cada camada tá fazendo
public interface ProdutoRepository extends  JpaRepository<ProdutoModel, Long>{

	public List<ProdutoModel> findAllByNomeContainingIgnoreCase(String nome);
}
