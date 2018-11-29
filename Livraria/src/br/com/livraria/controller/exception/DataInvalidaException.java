package br.com.livraria.controller.exception;

public class DataInvalidaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DataInvalidaException() {
	}

	public DataInvalidaException(String message) {
		super(message);
	}

	public DataInvalidaException(Throwable cause) {
		super(cause);
	}

	public DataInvalidaException(String message, Throwable cause) {
		super(message, cause);
	}

}
