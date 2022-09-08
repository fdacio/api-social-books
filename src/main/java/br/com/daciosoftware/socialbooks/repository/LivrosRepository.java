package br.com.daciosoftware.socialbooks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.daciosoftware.socialbooks.domain.Livro;

public interface LivrosRepository extends JpaRepository<Livro, Long> {
	
	List<Livro> findByNomeContainsIgnoreCase(String nome);
}
