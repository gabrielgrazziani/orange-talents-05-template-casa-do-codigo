package br.com.zupacademy.gabrielgarzziani.casadocodigo.local;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
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
@RequestMapping("/estado")
public class CriaEstadoController {
	
	@Autowired
	private UnicoEstadoPorPaisValidator unicoEstadoPorPaisValidator;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(unicoEstadoPorPaisValidator);
	}
	
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	@PostMapping
	public ResponseEntity<Object> cria(@Valid @RequestBody EstadoFrom from) {
		Estado estado = from.map(entityManager);
		entityManager.persist(estado);
		return ResponseEntity.ok().build();
	}
}
