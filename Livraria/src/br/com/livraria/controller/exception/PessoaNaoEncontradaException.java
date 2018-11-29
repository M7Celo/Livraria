package br.com.livraria.controller.exception;

public class PessoaNaoEncontradaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PessoaNaoEncontradaException() {
	}

	public PessoaNaoEncontradaException(String arg0) {
		super(arg0);
	}

	public PessoaNaoEncontradaException(Throwable arg0) {
		super(arg0);
	}

	public PessoaNaoEncontradaException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
