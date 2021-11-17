package br.com.generation.game.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.generation.game.model.ProdutoModel;
import br.com.generation.game.repository.ProdutoRepository;

@RestController //explica pro spring que essa é a camada controller
@RequestMapping("/produto")
@CrossOrigin (origins = "*", allowedHeaders = "*") //ordem da requisição, pode vim de qualquer lugar ex: Angular habilita para os Headers - 200, 400 e etc..
public class ProdutoController {

	@Autowired	
	private ProdutoRepository produtoRepository;
	
	@GetMapping
	public ResponseEntity<List<ProdutoModel>> getAll(){
		return ResponseEntity.ok(produtoRepository.findAll());
		
	}
	@GetMapping("/{id}")
		public ResponseEntity<ProdutoModel> getById(@PathVariable long id){
			return produtoRepository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
}
