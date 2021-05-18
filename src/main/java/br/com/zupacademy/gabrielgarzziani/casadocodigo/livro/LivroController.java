package br.com.zupacademy.gabrielgarzziani.casadocodigo.livro;

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
@RequestMapping("/livro")
public class LivroController {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	@PostMapping
	public ResponseEntity<?> cadastro(@Valid @RequestBody LivroForm form) {
		Livro livro = form.map(entityManager);
		entityManager.persist(livro);
		return ResponseEntity.ok().build();
	}
}
