package br.com.zupacademy.gabrielgarzziani.casadocodigo.local;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Estado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(unique = true)
	private String nome;
	@NotNull
	@ManyToOne(optional = false)
	private Pais pais;
	
	@Deprecated
	public Estado() {
	}

	public Estado(@NotBlank String nome,@NotNull Pais pais) {
		this.nome = nome;
		this.pais = pais;
	}

}
