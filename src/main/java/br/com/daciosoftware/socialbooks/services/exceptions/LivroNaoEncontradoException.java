package br.com.daciosoftware.socialbooks.services.exceptions;

public class LivroNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public LivroNaoEncontradoException(String message) {
		super(message);
	}
	
	public LivroNaoEncontradoException(String message, Throwable throwable) {
		super(message, throwable);
	}
	

}
