package br.com.daciosoftware.socialbooks.services.exceptions;

public class AutorExistenteException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public AutorExistenteException(String message) {
		super(message);
	}
	
	public AutorExistenteException(String message, Throwable throwable) {
		super(message, throwable);
	}
	

}
