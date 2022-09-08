package br.com.daciosoftware.socialbooks.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.daciosoftware.socialbooks.domain.Autor;
import br.com.daciosoftware.socialbooks.repository.AutoresRepository;
import br.com.daciosoftware.socialbooks.services.exceptions.AutorExistenteException;
import br.com.daciosoftware.socialbooks.services.exceptions.AutorNaoEncontraroException;

@Service
public class AutoresServices {

	@Autowired
	AutoresRepository autoresRepository;

	public List<Autor> lista() {
		return autoresRepository.findAll();
	}

	public Autor salvar(Autor autor) {
		Autor autoExiste = autoresRepository.findByNomeAndNascimentoAndNacionalidade(autor.getNome(),
				autor.getNascimento(), autor.getNacionalidade());
		if (autoExiste != null) {
			throw new AutorExistenteException("Auto já cadastrado");
		}
		return autoresRepository.save(autor);
	}

	public Autor buscar(Long id) {
		Autor autor = autoresRepository.findById(id).orElse(null);
		if (autor == null) {
			throw new AutorNaoEncontraroException("Autor não encontrado");
		}
		return autor;
	}

	public void deletar(Long id) {
		try {
			autoresRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new AutorExistenteException("Autor não encontrado.");
		}
	}
}
