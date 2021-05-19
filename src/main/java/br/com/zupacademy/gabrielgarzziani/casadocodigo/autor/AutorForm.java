package br.com.zupacademy.gabrielgarzziani.casadocodigo.autor;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zupacademy.gabrielgarzziani.casadocodigo.generic.UniqueValue;

public class AutorForm {
	@NotBlank
	private String nome;
	@NotBlank
	@Email
	@UniqueValue(domainClass = Autor.class,fieldName = "email")
	private String email;
	@Size(max = 400)
	@NotBlank
	private String descricao;
	
	public AutorForm(@NotBlank String nome, @NotBlank @Email String email,
			@Size(max = 400) @NotBlank String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public Autor map() {
		return new Autor(this.nome,this.email,this.descricao,LocalDateTime.now());
	}
}
