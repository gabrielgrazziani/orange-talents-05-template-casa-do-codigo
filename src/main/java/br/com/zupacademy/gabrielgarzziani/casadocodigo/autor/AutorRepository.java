package br.com.zupacademy.gabrielgarzziani.casadocodigo.autor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long>{
	
	boolean existsByEmail(String email);
}
