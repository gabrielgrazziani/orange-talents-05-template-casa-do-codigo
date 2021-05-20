package br.com.zupacademy.gabrielgarzziani.casadocodigo.local;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UnicoEstadoPorPaisValidator implements Validator {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return EstadoFrom.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		
		EstadoFrom form = (EstadoFrom) target;
		
		TypedQuery<Estado> query = entityManager.createQuery("select e from Estado e where e.pais.id = :paisId and e.nome = :nome",Estado.class);
		query.setParameter("paisId", form.getPaisId());
		query.setParameter("nome", form.getNome());
		List<Estado> list = query.getResultList();
		
		if(!list.isEmpty()) {
			errors.rejectValue("nome", null, "Já existe um estado um esse nome neste país");
		}
	}


}
