package br.com.zupacademy.gabrielgarzziani.casadocodigo.local;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import br.com.zupacademy.gabrielgarzziani.casadocodigo.generic.UniqueValue;

public class PaisForm {
	
	@NotBlank
	@UniqueValue(domainClass = Pais.class,fieldName = "nome")
	private String nome;

	@JsonCreator(mode = Mode.PROPERTIES)
	public PaisForm(String nome) {
		this.nome = nome;
	}

	public Pais map() {
		return new Pais(nome);
	}

}
