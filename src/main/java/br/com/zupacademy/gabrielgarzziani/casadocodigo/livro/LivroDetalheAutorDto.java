package br.com.zupacademy.gabrielgarzziani.casadocodigo.livro;

import br.com.zupacademy.gabrielgarzziani.casadocodigo.autor.Autor;

public class LivroDetalheAutorDto {
	private Long id;
	private String nome;
	private String descricao;
	
	public LivroDetalheAutorDto(Autor autor) {
		this.id = autor.getId();
		this.nome = autor.getNome();
		this.descricao = autor.getDescricao();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
