package br.com.daciosoftware.socialbooks.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.daciosoftware.socialbooks.domain.Comentario;
import br.com.daciosoftware.socialbooks.domain.Livro;
import br.com.daciosoftware.socialbooks.repository.ComentariosRepository;
import br.com.daciosoftware.socialbooks.repository.LivrosRepository;
import br.com.daciosoftware.socialbooks.services.exceptions.LivroNaoEncontradoException;

@Service
public class LivrosServices {

	@Autowired
	LivrosRepository livrosRepository;
	
	@Autowired
	ComentariosRepository comentariosRepository;
	
	public List<Livro> listar() {
		return livrosRepository.findAll();
	}

	public Livro buscar(Long id) {
		Livro livro = livrosRepository.findById(id).orElse(null);
		if (livro == null) {
			throw new LivroNaoEncontradoException("Livro não encontrado");
		}
		return livro;
	}

	public List<Livro> buscarPorNome(String nome) {
		List<Livro> livros = livrosRepository.findByNomeContainsIgnoreCase(nome);
		if (livros.size() == 0) {
			throw new LivroNaoEncontradoException(String.format("Nenhum livro encontrado contendo %s", nome));
		}
		return livros;
	}

	public Livro salvar(Livro livro) {
		livro.setId(null);
		return livrosRepository.save(livro);
	}
	
	public void deletar(Long id) {
		try {
			livrosRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new LivroNaoEncontradoException("Livro não encontrado.");
		}		
	}

	public void atualizar(Livro livro) {
		verificaExistencia(livro);
		livrosRepository.save(livro);
	}
	
	private void verificaExistencia(Livro livro) {
		buscar(livro.getId());
	}
	
	public Comentario salvarComentario(Long idLivro, Comentario comentario) {
		Livro livro = buscar(idLivro);
		comentario.setLivro(livro);
		comentario.setData(new Date());
		return comentariosRepository.save(comentario);		
	}
	
	public List<Comentario> listarComentarios(Long idLivro) {
		Livro livro = buscar(idLivro);
		return livro.getComentarios();
	}
	
}
