package br.com.zupacademy.gabrielgarzziani.casadocodigo.autor;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
public class Autor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nome;
	@NotBlank
	@Email
	@Column(unique = true)
	private String email;
	@Size(max = 400)
	@NotBlank
	private String descricao;
	@NotNull
	@PastOrPresent
	private LocalDateTime instanteCriacao;

	@Deprecated
	@SuppressWarnings("unused")
	private Autor() {
	}
		
	public Autor(@NotBlank String nome, @NotBlank @Email String email, @NotBlank @Size(max = 400) String descricao,
			@PastOrPresent LocalDateTime instanteCriacao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
		this.instanteCriacao = instanteCriacao;
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
