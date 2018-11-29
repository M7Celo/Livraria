package br.com.livraria.model.entity;

import java.io.Serializable;

public class Locacao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	private Integer locacaoLivroId;
		
	private String nomeCliente;
		
	private String tituloLivro;
	
	private String  dataLocacaoLivro;
	
	private String  dataDevolucaoLivro;

	private int qtdLivro;
	

	public Integer getLocacaoLivroId() {
		return locacaoLivroId;
	}

	public void setLocacaoLivroId(Integer locacaoLivroId) {
		this.locacaoLivroId = locacaoLivroId;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getTituloLivro() {
		return tituloLivro;
	}

	public void setTituloLivro(String tituloLivro) {
		this.tituloLivro = tituloLivro;
	}

	public String getDataLocacaoLivro() {
		return dataLocacaoLivro;
	}

	public void setDataLocacaoLivro(String dataLocacaoLivro) {
		this.dataLocacaoLivro = dataLocacaoLivro;
	}

	public String getDataDevolucaoLivro() {
		return dataDevolucaoLivro;
	}

	public void setDataDevolucaoLivro(String dataDevolucaoLivro) {
		this.dataDevolucaoLivro = dataDevolucaoLivro;
	}

	public int getQtdLivro() {
		return qtdLivro;
	}

	public void setQtdLivro(int qtdLivro) {
		this.qtdLivro = qtdLivro;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((locacaoLivroId == null) ? 0 : locacaoLivroId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Locacao other = (Locacao) obj;
		if (locacaoLivroId == null) {
			if (other.locacaoLivroId != null)
				return false;
		} else if (!locacaoLivroId.equals(other.locacaoLivroId))
			return false;
		return true;
	}

	
}
