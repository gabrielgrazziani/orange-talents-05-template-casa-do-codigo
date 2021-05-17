package br.com.zupacademy.gabrielgarzziani.casadocodigo.autor;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorForm {
	@NotBlank
	private String nome;
	@NotBlank
	@Email
	private String email;
	@Size(max = 400)
	private String descricao;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Autor map() {
		return new Autor(this.nome,this.email,this.descricao,LocalDateTime.now());
	}
}
