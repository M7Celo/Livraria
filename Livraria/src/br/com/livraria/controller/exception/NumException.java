package br.com.livraria.controller.exception;

public class NumException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NumException() {
	}

	public NumException(String message) {
		super(message);
	}

	public NumException(Throwable throwed) {
		super(throwed);
	}

	public NumException(String message, Throwable throwed) {
		super(message, throwed);
	}

}
