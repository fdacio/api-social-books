package br.com.daciosoftware.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.daciosoftware.socialbooks.domain.Autor;

public interface AutoresRepository extends JpaRepository<Autor, Long> {

}
