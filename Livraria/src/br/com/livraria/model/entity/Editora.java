package br.com.livraria.model.entity;

import java.io.Serializable;

public  class Editora implements Serializable{

	private static final long serialVersionUID = 1L;


	private Integer editoraId;
	
	private String nomeFantasiaEditora;
	
	private String razaoSocialEditora;
	
	private String logradouroEditora;

	private String numEnderecoEditora;
	
	private String bairroEditora;
	
	private String cidadeEditora;

	private String ufEditora;
	
	private String cepEditora;
	
	private String complementoEnderecoEditora;
	
	private String cnpjEditora;
	
	private String inscricaoEstadual;
	
	private String inscricaoMunicipal;

	private String contatoPessoaEditora;
	
	private String tipoTelefoneEditora;
	
	private String telefoneContatoEditora;
	
	private String emailEditora;
	

	public Integer getEditoraId() {
		return editoraId;
	}

	public void setEditoraId(Integer editoraId) {
		this.editoraId = editoraId;
	}

	public String getNomeFantasiaEditora() {
		return nomeFantasiaEditora;
	}

	public void setNomeFantasiaEditora(String nomeFantasiaEditora) {
		this.nomeFantasiaEditora = nomeFantasiaEditora;
	}

	public String getRazaoSocialEditora() {
		return razaoSocialEditora;
	}

	public void setRazaoSocialEditora(String razaoSocialEditora) {
		this.razaoSocialEditora = razaoSocialEditora;
	}

	public String getLogradouroEditora() {
		return logradouroEditora;
	}

	public void setLogradouroEditora(String logradouroEditora) {
		this.logradouroEditora = logradouroEditora;
	}

	public String getNumEnderecoEditora() {
		return numEnderecoEditora;
	}

	public void setNumEnderecoEditora(String numEnderecoEditora) {
		this.numEnderecoEditora = numEnderecoEditora;
	}

	public String getBairroEditora() {
		return bairroEditora;
	}

	public void setBairroEditora(String bairroEditora) {
		this.bairroEditora = bairroEditora;
	}

	public String getCidadeEditora() {
		return cidadeEditora;
	}

	public void setCidadeEditora(String cidadeEditora) {
		this.cidadeEditora = cidadeEditora;
	}

	public String getUfEditora() {
		return ufEditora;
	}

	public void setUfEditora(String ufEditora) {
		this.ufEditora = ufEditora;
	}

	public String getCepEditora() {
		return cepEditora;
	}

	public void setCepEditora(String cepEditora) {
		this.cepEditora = cepEditora;
	}

	public String getComplementoEnderecoEditora() {
		return complementoEnderecoEditora;
	}

	public void setComplementoEnderecoEditora(String complementoEnderecoEditora) {
		this.complementoEnderecoEditora = complementoEnderecoEditora;
	}

	public String getCnpjEditora() {
		return cnpjEditora;
	}

	public void setCnpjEditora(String cnpjEditora) {
		this.cnpjEditora = cnpjEditora;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}

	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}

	public String getContatoPessoaEditora() {
		return contatoPessoaEditora;
	}

	public void setContatoPessoaEditora(String contatoPessoaEditora) {
		this.contatoPessoaEditora = contatoPessoaEditora;
	}

	public String getTipoTelefoneEditora() {
		return tipoTelefoneEditora;
	}

	public void setTipoTelefoneEditora(String tipoTelefoneEditora) {
		this.tipoTelefoneEditora = tipoTelefoneEditora;
	}

	public String getTelefoneContatoEditora() {
		return telefoneContatoEditora;
	}

	public void setTelefoneContatoEditora(String telefoneContatoEditora) {
		this.telefoneContatoEditora = telefoneContatoEditora;
	}

	public String getEmailEditora() {
		return emailEditora;
	}

	public void setEmailEditora(String emailEditora) {
		this.emailEditora = emailEditora;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((editoraId == null) ? 0 : editoraId.hashCode());
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
		Editora other = (Editora) obj;
		if (editoraId == null) {
			if (other.editoraId != null)
				return false;
		} else if (!editoraId.equals(other.editoraId))
			return false;
		return true;
	}
		
}
