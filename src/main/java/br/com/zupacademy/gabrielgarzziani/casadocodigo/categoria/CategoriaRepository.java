package br.com.zupacademy.gabrielgarzziani.casadocodigo.categoria;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

	boolean existsByNome(String nome);

}
