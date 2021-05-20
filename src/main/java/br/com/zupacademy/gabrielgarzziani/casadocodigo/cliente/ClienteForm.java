package br.com.zupacademy.gabrielgarzziani.casadocodigo.cliente;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.gabrielgarzziani.casadocodigo.generic.CpfOuCnpj;
import br.com.zupacademy.gabrielgarzziani.casadocodigo.generic.ExistById;
import br.com.zupacademy.gabrielgarzziani.casadocodigo.generic.UniqueValue;
import br.com.zupacademy.gabrielgarzziani.casadocodigo.local.Estado;
import br.com.zupacademy.gabrielgarzziani.casadocodigo.local.Pais;

public class ClienteForm {

	@Email
	@NotBlank
	@UniqueValue(domainClass = Cliente.class,fieldName = "email")
	private String email;
	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;
	@NotBlank
	@CpfOuCnpj
	@UniqueValue(domainClass = Cliente.class,fieldName = "documento")
	private String documento;
	@NotBlank
	private String endereco;
	@NotBlank
	private String complemento;
	@NotBlank
	private String cidade;
	@NotBlank
	private String telefone;
	@NotBlank
	private String cep;
	@NotNull
	@ExistById(domainClass = Pais.class)
	private Long paisId;
	@ExistById(domainClass = Estado.class)
	private Long estadoId;
	
	public ClienteForm(@Email @NotBlank String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotBlank String telefone, @NotBlank String cep, Long paisId) {
		super();
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.telefone = telefone;
		this.cep = cep;
		this.paisId = paisId;
	}
	
	public Long getPaisId() {
		return paisId;
	}
	
	public Long getEstadoId() {
		return estadoId;
	}
	
	public void setEstadoId(Long estadoId) {
		this.estadoId = estadoId;
	}
	
	public Cliente map(EntityManager entityManager) {
		Pais pais = entityManager.find(Pais.class, paisId);
		
		Cliente cliente = new Cliente(
				email,
				nome,
				sobrenome,
				documento,
				endereco,
				complemento,
				cidade,
				telefone,
				cep,
				pais);
		
		if(estadoId != null) {
			Estado estado = entityManager.find(Estado.class,estadoId);
			cliente.setEstado(estado);			
		}
		
		return cliente;
	}
}
