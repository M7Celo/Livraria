package br.com.livraria.model.enums;

public enum CategoriaLivro {
	
	PRATA("PRATA"),
	OURO("OURO");
	
	private String descricao;
	
	CategoriaLivro(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
		}
}
