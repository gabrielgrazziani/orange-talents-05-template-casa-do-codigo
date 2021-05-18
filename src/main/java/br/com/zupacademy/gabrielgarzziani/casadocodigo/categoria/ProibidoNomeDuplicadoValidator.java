package br.com.zupacademy.gabrielgarzziani.casadocodigo.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProibidoNomeDuplicadoValidator implements Validator{
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return CategoriaForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		
		CategoriaForm form = (CategoriaForm) target;
		boolean exist = categoriaRepository.existsByNome(form.getNome());
		if(exist) {
			errors.rejectValue("nome", null, "Já existe uma categoria com este nome");
		}
	}

}
