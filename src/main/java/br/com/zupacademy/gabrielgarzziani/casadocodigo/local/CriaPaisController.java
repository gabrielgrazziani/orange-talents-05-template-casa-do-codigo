package br.com.zupacademy.gabrielgarzziani.casadocodigo.local;

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
@RequestMapping("/pais")
public class CriaPaisController {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	@PostMapping
	public ResponseEntity<?> cria(@Valid @RequestBody PaisForm form) {
		Pais pais = form.map();
		entityManager.persist(pais);
		return ResponseEntity.ok().build();
	}
}
