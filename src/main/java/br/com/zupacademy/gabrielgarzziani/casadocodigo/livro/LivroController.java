package br.com.zupacademy.gabrielgarzziani.casadocodigo.livro;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	
	@Transactional
	@GetMapping
	public ResponseEntity<List<LivroDto>> lista() {
		TypedQuery<Livro> query = entityManager.createQuery("select l from Livro l", Livro.class);
		List<Livro> list = query.getResultList();
		List<LivroDto> listDto = list.stream()
			.map(LivroDto::new)
			.collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<LivroDetalheDto> detelhes(@PathVariable Long id) {
		Livro livro = entityManager.find(Livro.class, id);
		if(livro == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(new LivroDetalheDto(livro));
	}
}
