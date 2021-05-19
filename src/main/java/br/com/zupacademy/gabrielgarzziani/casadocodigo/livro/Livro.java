package br.com.zupacademy.gabrielgarzziani.casadocodigo.livro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.zupacademy.gabrielgarzziani.casadocodigo.autor.Autor;
import br.com.zupacademy.gabrielgarzziani.casadocodigo.categoria.Categoria;

@Entity
public class Livro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(unique = false)
	private String titulo;
	@NotBlank
	@Size(max = 500)
	private String resumo;
	@NotNull
	private String sumario;
	@NotNull
	@Min(20)
	private BigDecimal preco;
	@Min(100)
	private int numeroPaginas;
	@NotBlank
	@Column(unique = false)
	private String isbn;
	@NotNull
	@Future
	private LocalDate dataPublicacao;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "autor_id")
	private Autor autor;

	@Deprecated
	@SuppressWarnings("unused")
	private Livro() {
	}

	public Livro(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, @NotNull String sumario,
			@NotNull @Min(20) BigDecimal preco, @Min(100) int numeroPaginas, @NotBlank String isbn,
			@NotNull @Future LocalDate dataPublicacao, @NotNull Categoria categoria, @NotNull Autor autor) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.categoria = categoria;
		this.autor = autor;
	}
	
	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}
}
