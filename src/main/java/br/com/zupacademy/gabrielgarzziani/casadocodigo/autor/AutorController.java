package br.com.zupacademy.gabrielgarzziani.casadocodigo.autor;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("autor")
public class AutorController {
	
	@Autowired
	private ProibidoEmailDuplicadoValidator proibidoEmailDuplicadoValidator;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(proibidoEmailDuplicadoValidator);
	}
	
	@Autowired
	private AutorRepository autorRepository;

	@PostMapping
	public ResponseEntity<AutorDto> cadastro(@Valid @RequestBody AutorForm form) {
		Autor autor = form.map();
		autorRepository.save(autor);
		return ResponseEntity.ok(new AutorDto(autor));
	}
	
}
