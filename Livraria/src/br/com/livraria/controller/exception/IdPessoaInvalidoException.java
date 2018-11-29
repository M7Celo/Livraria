package br.com.livraria.controller.exception;

public class IdPessoaInvalidoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IdPessoaInvalidoException() {
	}

	public IdPessoaInvalidoException(String message) {
		super(message);
	}

	public IdPessoaInvalidoException(Throwable cause) {
		super(cause);
	}

	public IdPessoaInvalidoException(String message, Throwable cause) {
		super(message, cause);
	}
}
