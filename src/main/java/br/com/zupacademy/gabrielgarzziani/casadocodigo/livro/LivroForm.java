package br.com.zupacademy.gabrielgarzziani.casadocodigo.livro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.zupacademy.gabrielgarzziani.casadocodigo.autor.Autor;
import br.com.zupacademy.gabrielgarzziani.casadocodigo.categoria.Categoria;
import br.com.zupacademy.gabrielgarzziani.casadocodigo.config.validacao.ErroDeValidacaoException;
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
	private String isbn;
	@NotNull
	@Future
	private LocalDate dataPublicacao;
	@NotNull
	private Long categoriaId;
	@NotNull
	private Long autorId;
	
	
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public void setSumario(String sumario) {
		this.sumario = sumario;
	}



	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public void setCategoriaId(Long categoriaId) {
		this.categoriaId = categoriaId;
	}

	public void setAutorId(Long autorId) {
		this.autorId = autorId;
	}

	public Livro map(EntityManager entityManager) {
		Categoria categoria = entityManager.find(Categoria.class, categoriaId);
		if(categoria == null) throw new ErroDeValidacaoException("categoriaId", "Não existe uma categoria com id "+categoriaId);
		
		Autor autor = entityManager.find(Autor.class, autorId);
		if(autor == null) throw new ErroDeValidacaoException("autorId", "Não existe um autor com id "+autorId);
		
		
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
