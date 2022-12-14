package br.com.daciosoftware.socialbooks.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import br.com.daciosoftware.socialbooks.domain.DetalheErro;
import br.com.daciosoftware.socialbooks.services.exceptions.AutorExistenteException;
import br.com.daciosoftware.socialbooks.services.exceptions.AutorNaoEncontraroException;
import br.com.daciosoftware.socialbooks.services.exceptions.LivroNaoEncontradoException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(LivroNaoEncontradoException.class)
	public ResponseEntity<DetalheErro> handleLivroNaoEncontradoExcpetion(LivroNaoEncontradoException e,
			HttpServletRequest request) {

		DetalheErro erro = DetalheErro
				.builder()
				.addStatus(404l)
				.addTitulo(e.getMessage())
				.addTimestamp(System.currentTimeMillis())
				.addMensagemDesenvolvedor("http://api.error.daciosoftware.com.br/404.html").build();

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);

	}
	
	@ExceptionHandler(AutorExistenteException.class)
	public ResponseEntity<DetalheErro> handleAutoExistenteExcpetion(AutorExistenteException e,
			HttpServletRequest request) {

		DetalheErro erro = DetalheErro.builder()
				.addStatus(409l)
				.addTitulo(e.getMessage())
				.addTimestamp(System.currentTimeMillis())
				.addMensagemDesenvolvedor("http://api.error.daciosoftware.com.br/409.html").build();

		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);

	}
	
	@ExceptionHandler(AutorNaoEncontraroException.class)
	public ResponseEntity<DetalheErro> handleAutorNaoEncontraroException(AutorNaoEncontraroException e,
			HttpServletRequest request) {

		DetalheErro erro = DetalheErro
				.builder()
				.addStatus(404l)
				.addTitulo(e.getMessage())
				.addTimestamp(System.currentTimeMillis())
				.addMensagemDesenvolvedor("http://api.error.daciosoftware.com.br/404.html").build();

		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);

	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<DetalheErro> handleMethodArgumentNotValidException(MethodArgumentNotValidException e,
			HttpServletRequest request) {
		
		DetalheErro erro = DetalheErro
				.builder()
				.addStatus(400l)
				.addTitulo("Argumentos Inv??lidos")
				.addTimestamp(System.currentTimeMillis())
				.addMensagemDesenvolvedor("http://api.error.daciosoftware.com.br/400.html").build();

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);

	}
	@ExceptionHandler(InvalidFormatException.class)
	public ResponseEntity<DetalheErro> handleInvalidFormatException(InvalidFormatException e,
			HttpServletRequest request) {
		
		DetalheErro erro = DetalheErro
				.builder()
				.addStatus(400l)
				.addTitulo("Argmentos com formato inv??lido")
				.addTimestamp(System.currentTimeMillis())
				.addMensagemDesenvolvedor("http://api.error.daciosoftware.com.br/400.html").build();

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);

	}
	

}
