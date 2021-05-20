package br.com.zupacademy.gabrielgarzziani.casadocodigo.cliente;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.gabrielgarzziani.casadocodigo.local.Estado;

@Component
public class EstadoDeveSerDoMesmoPaisValidator implements Validator{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return ClienteForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		
		ClienteForm form = (ClienteForm) target;
		
		Long paisId = form.getPaisId();
		Long estadoId = form.getEstadoId();
		
		if(estadoId == null) {
			return;
		}
		
		Estado estado = entityManager.find(Estado.class,estadoId);
		
		if(estado.getPais().getId() != paisId) {
			errors.rejectValue("estadoId", null, "O estado deve ser do mesmo país");
		}
		
	}

}
