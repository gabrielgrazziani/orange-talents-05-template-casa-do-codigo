package br.com.zupacademy.gabrielgarzziani.casadocodigo.autor;

import java.time.LocalDateTime;

public class AutorDto {
	private Long id;
	private String nome;
	private String email;
	private String descricao;
	private LocalDateTime instanteCriacao;
	
	public AutorDto(Autor autor) {
		this.id = autor.getId();
		this.nome = autor.getNome();
		this.email = autor.getEmail();
		this.descricao = autor.getDescricao();
		this.instanteCriacao = autor.getInstanteCriacao();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

	public LocalDateTime getInstanteCriacao() {
		return instanteCriacao;
	}

}
