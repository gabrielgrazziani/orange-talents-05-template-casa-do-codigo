package br.com.zupacademy.gabrielgarzziani.casadocodigo.categoria;

import javax.validation.constraints.NotEmpty;

import br.com.zupacademy.gabrielgarzziani.casadocodigo.generic.UniqueValue;

public class CategoriaForm {

	@NotEmpty
	@UniqueValue(domainClass = Categoria.class,fieldName = "nome")
	private String nome;
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Categoria map() {
		return new Categoria(this.nome);
	}
}
