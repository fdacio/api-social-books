package br.com.daciosoftware.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.daciosoftware.socialbooks.domain.Comentario;

public interface ComentariosRepository extends JpaRepository<Comentario, Long> {

}
