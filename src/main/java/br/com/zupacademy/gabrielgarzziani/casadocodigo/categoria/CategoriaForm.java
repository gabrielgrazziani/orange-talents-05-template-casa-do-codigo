package br.com.zupacademy.gabrielgarzziani.casadocodigo.categoria;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import br.com.zupacademy.gabrielgarzziani.casadocodigo.generic.UniqueValue;

public class CategoriaForm {

	@NotEmpty
	@UniqueValue(domainClass = Categoria.class,fieldName = "nome")
	private String nome;
	
	@JsonCreator(mode = Mode.PROPERTIES)
	public CategoriaForm(String nome) {
		this.nome = nome;
	}
	
	public Categoria map() {
		return new Categoria(this.nome);
	}
}
