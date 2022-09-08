package br.com.daciosoftware.socialbooks.services.exceptions;

public class AutorNaoEncontraroException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public AutorNaoEncontraroException(String message) {
		super(message);
	}
	
	public AutorNaoEncontraroException(String message, Throwable throwable) {
		super(message, throwable);
	}
	

}
