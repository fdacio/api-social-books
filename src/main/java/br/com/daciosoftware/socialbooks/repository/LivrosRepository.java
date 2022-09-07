package br.com.daciosoftware.socialbooks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.daciosoftware.socialbooks.domain.Livro;

public interface LivrosRepository extends JpaRepository<Livro, Long> , JpaSpecificationExecutor<Livro> {
	
	List<Livro> findByNomeContainsIgnoreCase(String nome);
}
