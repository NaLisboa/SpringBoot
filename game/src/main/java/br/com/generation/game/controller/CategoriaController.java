package br.com.generation.game.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.generation.game.model.CategoriaModel;
import br.com.generation.game.repository.CategoriaRepository;

@RestController //explicando o que cada camada tá fazendo
@RequestMapping("/categoria")
@CrossOrigin(origins = "*", allowedHeaders = "*") //ordem da requisição, pode vim de qualquer lugar ex: Angular habilita para os Headers - 200, 400 e etc..
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping 
	public ResponseEntity<List<CategoriaModel>> getAll(){ //SELECT * FROM tb_categoria
		return ResponseEntity.ok(categoriaRepository.findAll()); //OK HTTP 200 até 299
	}
	
}
