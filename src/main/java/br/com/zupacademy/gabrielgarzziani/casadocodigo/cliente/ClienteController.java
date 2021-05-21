package br.com.zupacademy.gabrielgarzziani.casadocodigo.cliente;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@PersistenceContext
	private EntityManager entityManager;
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastra(@Valid @RequestBody ClienteForm form){
		Cliente cliente = form.map(entityManager);
		entityManager.persist(cliente);
		return ResponseEntity.ok(cliente.getId());
	}
}
