package br.com.zupacademy.gabrielgarzziani.casadocodigo.categoria;

import javax.validation.constraints.NotEmpty;

public class CategoriaForm {

	@NotEmpty
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
