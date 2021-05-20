package br.com.zupacademy.gabrielgarzziani.casadocodigo.cliente;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class EstadoObrigatorioSePaisTiveEstadoValidator implements Validator{

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
		
		if(possuiEstados(paisId) && estadoId == null) {
			errors.rejectValue("estadoId", null, "Campo é obrigatorio porque o pais informado possui estados");
		}
		
	}

	private boolean possuiEstados(Long paisId) {
		Query query = entityManager.createQuery("select 1 from Estado e where e.pais.id = :paisId");
		query.setParameter("paisId", paisId);
		List<?> list = query.getResultList();
		return !list.isEmpty();
	}

}
