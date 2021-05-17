package br.com.zupacademy.gabrielgarzziani.casadocodigo.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProibidoEmailDuplicadoValidator implements Validator{

	@Autowired
	private AutorRepository autorRepository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return AutorForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {	
		if(errors.hasErrors()) {
			return;
		}
		
		AutorForm form = (AutorForm) target;
		
		boolean exist = autorRepository.existsByEmail(form.getEmail());
		if(exist) {
			errors.rejectValue("email", null, "este email já foi cadastrado");
		}
	}

}
