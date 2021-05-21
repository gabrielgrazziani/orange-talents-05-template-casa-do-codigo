package br.com.zupacademy.gabrielgarzziani.casadocodigo.local;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.zupacademy.gabrielgarzziani.casadocodigo.cliente.ClienteForm;
import br.com.zupacademy.gabrielgarzziani.casadocodigo.generic.LocalValido;

public class EstadoValidator implements ConstraintValidator<LocalValido, ClienteForm>{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public boolean isValid(ClienteForm form, ConstraintValidatorContext context) {
		if(form.getPaisId() == null) return true;
		if(form.getEstadoId() == null) {
			setMessage(context, "Estado é obrigatorio porque este pais possui estados");
			return paisNaoPossuiEstados(form);			
		}else {
			setMessage(context, "Estado deve pertencer ao mesmo pais");
			return estadoPertenseAoMesmoPais(form);			
		}
	}
	
	private void setMessage(ConstraintValidatorContext context,String message) {
		context.disableDefaultConstraintViolation();
		context.buildConstraintViolationWithTemplate(message)
			.addConstraintViolation();
	}

	private boolean paisNaoPossuiEstados(ClienteForm form) {
		Query query = entityManager.createQuery("select 1 from Estado e where e.pais.id = :paisId");
		query.setParameter("paisId", form.getPaisId());
		List<?> list = query.getResultList();
		return list.isEmpty();
	}

	private boolean estadoPertenseAoMesmoPais(ClienteForm form) {
		Long paisId = form.getPaisId();
		Long estadoId = form.getEstadoId();
		
		Estado estado = entityManager.find(Estado.class,estadoId);
		
		return estado.getPais().getId() == paisId;
	}


}
