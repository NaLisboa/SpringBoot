package br.com.generation.game.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity //explicando o que cada camada tá fazendo
@Table(name = "tb_produto")

public class ProdutoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "O valor não pode ser nulo e nem pode conter espaço")
	@Size (min = 2, max = 100, message = "Nesse texto o mínimo é 2 e o máximo 100 caracteres")
	private String titulo;
	
	@NotBlank
	private double preço;
	
	@ManyToOne // N : 1
	@JsonIgnoreProperties("produto") //Não permite repetir informações[não repetir o nome do mesmo atributo (jogo) várias vzs
	private CategoriaModel categoria;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public double getPreço() {
		return preço;
	}
	public void setPreço(double preço) {
		this.preço = preço;
	}
	public CategoriaModel getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaModel categoria) {
		this.categoria = categoria;
	}
	
	
}
