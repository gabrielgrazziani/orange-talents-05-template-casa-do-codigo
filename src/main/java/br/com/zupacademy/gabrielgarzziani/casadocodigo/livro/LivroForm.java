package br.com.zupacademy.gabrielgarzziani.casadocodigo.livro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.ISBN;
import org.hibernate.validator.constraints.ISBN.Type;

import br.com.zupacademy.gabrielgarzziani.casadocodigo.autor.Autor;
import br.com.zupacademy.gabrielgarzziani.casadocodigo.categoria.Categoria;
import br.com.zupacademy.gabrielgarzziani.casadocodigo.generic.ExistById;
import br.com.zupacademy.gabrielgarzziani.casadocodigo.generic.UniqueValue;

public class LivroForm {
	
	@NotBlank
	@UniqueValue(domainClass = Livro.class,fieldName = "titulo")
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
	@UniqueValue(domainClass = Livro.class,fieldName = "isbn")
	@ISBN(type = Type.ANY)
	private String isbn;
	@NotNull
	@Future
	private LocalDate dataPublicacao;
	@NotNull
	@ExistById(domainClass = Categoria.class)
	private Long categoriaId;
	@NotNull
	@ExistById(domainClass = Autor.class)
	private Long autorId;
	
	public LivroForm(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, @NotNull String sumario,
			@NotNull @Min(20) BigDecimal preco, @Min(100) int numeroPaginas, @ISBN(type = Type.ANY) @NotBlank String isbn,
			@NotNull @Future LocalDate dataPublicacao, @NotNull Long categoriaId, @NotNull Long autorId) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.categoriaId = categoriaId;
		this.autorId = autorId;
	}

	public Livro map(EntityManager entityManager) {
		Categoria categoria = entityManager.find(Categoria.class, categoriaId);
		Autor autor = entityManager.find(Autor.class, autorId);
		
		return new Livro(
				titulo,
				resumo,
				sumario,
				preco,
				numeroPaginas,
				isbn,
				dataPublicacao,
				categoria,
				autor);
	}
	
}
