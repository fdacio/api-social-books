package br.com.daciosoftware.socialbooks.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.daciosoftware.socialbooks.domain.Comentario;
import br.com.daciosoftware.socialbooks.domain.Livro;
import br.com.daciosoftware.socialbooks.services.LivrosServices;

@RestController
@RequestMapping("/livros")
public class LivrosResources {

	@Autowired
	LivrosServices livrosServices;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Livro>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(livrosServices.listar());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Livro> buscar(@PathVariable("id") Long id) {
		Livro livro = livrosServices.buscar(id);
		return ResponseEntity.status(HttpStatus.OK).body(livro);
	}

	@RequestMapping(value = "/nome/{nome}", method = RequestMethod.GET)
	public ResponseEntity<List<Livro>> buscarPorNome(@PathVariable("nome") String nome) {
		List<Livro> livros = livrosServices.buscarPorNome(nome);
		return ResponseEntity.status(HttpStatus.OK).body(livros);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid @RequestBody Livro livro) {
		livro = livrosServices.salvar(livro);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(livro.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		livrosServices.deletar(id);
		return ResponseEntity.notFound().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@PathVariable("id") Long id, @RequestBody Livro livro) {
		livro.setId(id);
		livrosServices.atualizar(livro);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}/comentarios", method = RequestMethod.POST)
	public ResponseEntity<Void> adicionarComentario(@PathVariable("id") Long idLivro, @RequestBody Comentario comentario) {
		livrosServices.salvarComentario(idLivro, comentario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}/comentarios", method = RequestMethod.GET)
	public ResponseEntity<List<Comentario>> listarComentarios(@PathVariable("id") Long idLivro) {
		List<Comentario> comentarios = livrosServices.listarComentarios(idLivro);
		return ResponseEntity.status(HttpStatus.OK).body(comentarios);
	}
}
