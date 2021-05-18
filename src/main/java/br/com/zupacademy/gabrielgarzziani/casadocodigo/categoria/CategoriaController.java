package br.com.zupacademy.gabrielgarzziani.casadocodigo.categoria;

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
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	private ProibidoNomeDuplicadoValidator nomeValidator;
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(nomeValidator);
	}
	
	@PostMapping
	public ResponseEntity<?> cadastro(@Valid @RequestBody CategoriaForm from) {
		categoriaRepository.save(from.map());
		return ResponseEntity.ok().build();
	}
}
