package br.com.zupacademy.gabrielgarzziani.casadocodigo.livro;

public class LivroDto {
	
	private Long id;
	private String titulo;
	
	public LivroDto(Long id, String titulo) {
		super();
		this.id = id;
		this.titulo = titulo;
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}
}
