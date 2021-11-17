package br.com.generation.game.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//Modela as informações do Banco de dados

@Entity //explicando o que cada camada tá fazendo
@Table(name = "tb_categoria")
public class CategoriaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_categoria;

	@NotBlank (message = "O valor não pode ser nulo e nem pode conter espaço")
	@Size (min = 5, max = 50, message = "Nesse texto o mínimo é 5 e o máximo 50 caracteres")
	private String genero;
	
	@NotBlank (message = "O valor não pode ser nulo e nem pode conter espaço")
	@Size (min = 5, max = 20, message = "Nesse texto o mínimo é 5 e o máximo 20 caracteres")
	private String plataforma;
	
	@NotBlank (message = "O valor não pode ser nulo e nem pode conter espaço")
	@Size (min = 5, max = 50, message = "Nesse texto o mínimo é 5 e o máximo 50 caracteres")
	private String condicao;

	//mappedBy -> De onde estou mapeando
	//cascade -> o que uma tabela fizer, funcionará nas outras
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL) //Mostra apenas a categoria que foi solicitada
	@JsonIgnoreProperties ("categoria")
	private List<ProdutoModel> produto; // Traz o produto
	
	
	public List<ProdutoModel> getProduto() {
		return produto;
	}

	public void setProduto(List<ProdutoModel> produto) {
		this.produto = produto;
	}

	public long getId() {
		return id_categoria;
	}

	public void setId(long id) {
		this.id_categoria = id;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getCondicao() {
		return condicao;
	}

	public void setCondicao(String condicao) {
		this.condicao = condicao;
	}

}
