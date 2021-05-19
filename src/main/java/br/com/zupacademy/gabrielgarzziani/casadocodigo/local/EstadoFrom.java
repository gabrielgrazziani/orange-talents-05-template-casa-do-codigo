package br.com.zupacademy.gabrielgarzziani.casadocodigo.local;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.gabrielgarzziani.casadocodigo.generic.ExistById;
import br.com.zupacademy.gabrielgarzziani.casadocodigo.generic.UniqueValue;

public class EstadoFrom {
	
	@NotNull
	@ExistById(domainClass = Pais.class)
	private Long paisId;
	@NotBlank
	@UniqueValue(domainClass = Estado.class,fieldName = "nome")
	private String nome;
	
	public EstadoFrom(Long paisId, String nome) {
		this.paisId = paisId;
		this.nome = nome;
	}
	
	public Estado map(EntityManager entityManager) {
		Pais pais = entityManager.find(Pais.class, paisId);
		return new Estado(nome,pais);
	}
}
