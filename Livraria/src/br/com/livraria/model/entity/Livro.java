package br.com.livraria.model.entity;

import java.io.Serializable;

public class Livro implements Serializable{

	private static final long serialVersionUID = 1L;
	

	private Integer livroId;
	
	private String tituloLivro;
	
	private Integer anoLivro;
	
	private String edicaoLivro;
	
	private String editoraLivro;
	
	private String isbnLivro;
	
	private String categLivro;
	

	public Integer getLivroId() {
		return livroId;
	}

	public void setLivroId(Integer livroId) {
		this.livroId = livroId;
	}

	public String getTituloLivro() {
		return tituloLivro;
	}

	public void setTituloLivro(String tituloLivro) {
		this.tituloLivro = tituloLivro;
	}

	public Integer getAnoLivro() {
		return anoLivro;
	}

	public void setAnoLivro(Integer anoLivro) {
		this.anoLivro = anoLivro;
	}

	public String getEdicaoLivro() {
		return edicaoLivro;
	}

	public void setEdicaoLivro(String edicaoLivro) {
		this.edicaoLivro = edicaoLivro;
	}

	public String getEditoraLivro() {
		return editoraLivro;
	}

	public void setEditoraLivro(String editoraLivro) {
		this.editoraLivro = editoraLivro;
	}

	public String getIsbnLivro() {
		return isbnLivro;
	}

	public void setIsbnLivro(String isbnLivro) {
		this.isbnLivro = isbnLivro;
	}

	public String getCategLivro() {
		return categLivro;
	}

	public void setCategLivro(String categLivro) {
		this.categLivro = categLivro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((livroId == null) ? 0 : livroId.hashCode());
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
		Livro other = (Livro) obj;
		if (livroId == null) {
			if (other.livroId != null)
				return false;
		} else if (!livroId.equals(other.livroId))
			return false;
		return true;
	}
	
}
