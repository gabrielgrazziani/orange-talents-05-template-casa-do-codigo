package br.com.zupacademy.gabrielgarzziani.casadocodigo.livro;

import java.math.BigDecimal;

public class LivroDetalheDto {
	private Long id;
	private String titulo;
	private String resumo;
	private String sumario;
	private BigDecimal preco;
	private int numeroPaginas;
	private String isbn;
	private LivroDetalheAutorDto autor;

	public LivroDetalheDto(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.numeroPaginas = livro.getNumeroPaginas();
		this.isbn = livro.getIsbn();
		this.autor = new LivroDetalheAutorDto(livro.getAutor());
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public LivroDetalheAutorDto getAutor() {
		return autor;
	}
}
