package br.com.daciosoftware.socialbooks.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.daciosoftware.socialbooks.domain.Autor;

public interface AutoresRepository extends JpaRepository<Autor, Long> {

	public Autor findByNomeAndNascimentoAndNacionalidade(String nome, Date nascimento, String nacionalidade);
}
