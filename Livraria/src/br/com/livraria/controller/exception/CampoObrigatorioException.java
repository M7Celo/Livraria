package br.com.livraria.controller.exception;

public class CampoObrigatorioException extends Exception {

	
	private static final long serialVersionUID = 1L;

	public CampoObrigatorioException() {
	}

	public CampoObrigatorioException(String arg0) {
		super(montaMensagem(arg0));
	}

	private static String montaMensagem(String arg0) {
		return "Campo '" + arg0 + "' obrigatorio";
	}

	public CampoObrigatorioException(Throwable arg0) {
		super(arg0);
	}

	public CampoObrigatorioException(String arg0, Throwable arg1) {
		super(montaMensagem(arg0), arg1);
	}

}
