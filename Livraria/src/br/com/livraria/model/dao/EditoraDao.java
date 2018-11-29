package br.com.livraria.model.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.livraria.model.database.connection.SingleConnectionPostgre;
import br.com.livraria.model.entity.Editora;

public class EditoraDao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Connection con = SingleConnectionPostgre.getConnection();
	
	// Método para Cadastrar Editora
		public void cadastrar(Editora editora) {
			
			String sql = "insert into editora_tab ("
					+ "nome_fantasia, " // 1
					+ "razao_social, " // 2
					+ "logradouro_editora, " // 3
					+ "num_endereco_editora, " // 4
					+ "bairro_editora, " // 5
					+ "cidade_editora, " // 6
					+ "uf_editora, " // 7
					+ "cep_editora, " // 8
					+ "cnpj_editora, " // 9
					+ "inscricao_est_editora, " // 10
					+ "inscricao_mun_editora, " // 11
					+ "contato_pessoa_editora, " // 12
					+ "tipo_telefone_editora, " // 13 
					+ "telefone_contato_editora, " // 14
					+ "email_editora, " // 15
					+ "comp_end_editora) " // 16
					+ "values(?, ?, ?, ?, " // 4
					+ "?, ?, ?, ?, " // 8
					+ "?, " // 9
					+ "?, " // 10
					+ "?, " // 11
					+ "?, " // 12
					+ "?, " // 13
					+ "?, " // 14
					+ "?, " // 15
					+ "?)";  // 16
			
			try {
				
				// Preparando o SQL
				PreparedStatement preparador = con.prepareStatement(sql);
				
				// Substituindo os parametros do SQL pelos valores do objeto editora
				preparador.setString(1, editora.getNomeFantasiaEditora());
				preparador.setString(2, editora.getRazaoSocialEditora());
				preparador.setString(3, editora.getLogradouroEditora());
				preparador.setString(4, editora.getNumEnderecoEditora());
				preparador.setString(5, editora.getBairroEditora());
				preparador.setString(6, editora.getCidadeEditora());
				preparador.setString(7, editora.getUfEditora());
				preparador.setString(8, editora.getCepEditora());
				preparador.setString(9, editora.getCnpjEditora());	
				preparador.setString(10, editora.getInscricaoEstadual());
				preparador.setString(11, editora.getInscricaoMunicipal());
				preparador.setString(12, editora.getContatoPessoaEditora());
				preparador.setString(13, editora.getTipoTelefoneEditora());
				preparador.setString(14, editora.getTelefoneContatoEditora());
				preparador.setString(15, editora.getEmailEditora());
				preparador.setString(16, editora.getComplementoEnderecoEditora());
				
				// Executa SQL
				preparador.execute();
				
				// Fecha Statment
				preparador.close();
				
			}catch(SQLException e) {
				System.out.println("Erro de SQL:"+ e.getMessage());
			}

			
		}
		
		// Método para Atualizar Editora
		public void alterar(Editora editora) {
			String sql = "update editora_tab  set "
					+ "nome_fantasia=?, razao_social=?, "
					+ "logradouro_editora=?, num_endereco_editora=?, "
					+ "bairro_editora=?, cidade_editora=?, uf_editora=?, " + 
					"cep_editora=?, cnpj_editora=?, "
					+ "inscricao_est_editora=?, inscricao_mun_editora=?, " + 
					"contato_pessoa_editora=?, tipo_telefone_editora=?, "
					+ "telefone_contato_editora=?, " + 
					"email_editora=?, comp_end_editora=? where editora_id=?";
			
			try {
				
				// Preparando o SQL
				PreparedStatement preparador = con.prepareStatement(sql);
				
				// Substituindo os parametros do SQL pelos valores do objeto Editora
				preparador.setString(1, editora.getNomeFantasiaEditora());
				preparador.setString(2, editora.getRazaoSocialEditora());
				preparador.setString(3, editora.getLogradouroEditora());
				preparador.setString(4, editora.getNumEnderecoEditora());
				preparador.setString(5, editora.getBairroEditora());
				preparador.setString(6, editora.getCidadeEditora());
				preparador.setString(7, editora.getUfEditora());
				preparador.setString(8, editora.getCepEditora());
				preparador.setString(9, editora.getCnpjEditora());
				preparador.setString(10, editora.getInscricaoEstadual());
				preparador.setString(11, editora.getInscricaoMunicipal());
				preparador.setString(12, editora.getContatoPessoaEditora());
				preparador.setString(13, editora.getTipoTelefoneEditora());
				preparador.setString(14, editora.getTelefoneContatoEditora());
				preparador.setString(15, editora.getEmailEditora());
				preparador.setString(16, editora.getComplementoEnderecoEditora());
				preparador.setInt(17, editora.getEditoraId());
				
				// Executa SQL
				preparador.execute();
				
				// Fecha Statment
				preparador.close();
				
				System.out.println("Alterado com sucesso!");
				
			}catch(SQLException e1) {
				System.out.println("Erro de SQL:"+ e1.getMessage());
			}
			
		}
		
		// Método para Salvar o Editora
		public void salvar(Editora editora) {
			if(editora.getEditoraId()!=null && editora.getEditoraId()!=0) {
				alterar(editora);
			}else {
				cadastrar(editora);
			}
			
		}
		
		// Método para Apagar Editora
		public void excluir(Editora editora) {
			
		String sql = "delete from editora_tab where editora_id=?";
		
		try {
			
			// Preparando o SQL
			PreparedStatement preparador = con.prepareStatement(sql);
			
			// Substituindo os parametros do SQL pelos valores do objeto editora
			preparador.setInt(1, editora.getEditoraId());
			
			// Executa SQL
			preparador.execute();
						
			// Fecha Statment
			preparador.close();
						
						System.out.println("Excluído com sucesso!");
		}catch(SQLException e1) {
			try {
				con.rollback();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			System.out.println("Erro de SQL:"+ e1.getMessage());
		}
			
	}
		
	// Método para Buscar o Editora por Id
	public Editora buscarPorId(Integer id) {
		
		//Objeto de retorno do método
		Editora editoraRetorno = null;
		
		String sql = "select * from editora_tab  where editora_id=?";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			
			// Substituindo os parametros do SQL pelos valores do objeto editora
			preparador.setInt(1,id);
			
			//Retorno da consulta em Resultset
			ResultSet resultado = preparador.executeQuery();
			
			//Se tem registro
			if(resultado.next()){
				
				//instancia o objeto Editora
				editoraRetorno = new Editora();
				
				editoraRetorno.setEditoraId(resultado.getInt("editora_id"));
				editoraRetorno.setNomeFantasiaEditora(resultado.getString("nome_fantasia"));
				editoraRetorno.setRazaoSocialEditora(resultado.getString("razao_social"));
				editoraRetorno.setLogradouroEditora(resultado.getString("logradouro_editora"));
				editoraRetorno.setNumEnderecoEditora(resultado.getString("num_endereco_editora"));
				editoraRetorno.setBairroEditora(resultado.getString("bairro_editora"));
				editoraRetorno.setCidadeEditora(resultado.getString("cidade_editora"));
				editoraRetorno.setUfEditora(resultado.getString("uf_editora"));
				editoraRetorno.setCepEditora(resultado.getString("cep_editora"));
				editoraRetorno.setCnpjEditora(resultado.getString("cnpj_editora"));
				editoraRetorno.setInscricaoEstadual(resultado.getString("inscricao_est_editora"));
				editoraRetorno.setInscricaoMunicipal(resultado.getString("inscricao_mun_editora"));
				editoraRetorno.setContatoPessoaEditora(resultado.getString("contato_pessoa_editora"));
				editoraRetorno.setTipoTelefoneEditora(resultado.getString("tipo_telefone_editora"));
				editoraRetorno.setTelefoneContatoEditora(resultado.getString("telefone_contato_editora"));
				editoraRetorno.setEmailEditora(resultado.getString("email_editora"));
				editoraRetorno.setComplementoEnderecoEditora(resultado.getString("comp_end_editora"));
				
			}
			
			System.out.println("Encontrado com sucesso!");
			
		}catch(SQLException e1) {
			System.out.println("Erro de SQL:"+ e1.getMessage());
		}
		return editoraRetorno;
	}
	
	// Método fazer uma lista com todos os registros de Editoras
		public List<Editora> buscaTodos(){
		
			//Objeto de retorno do método
			List<Editora> listaEditora = new ArrayList<Editora>();
			
			String sql = "select * from editora_tab order by editora_id";
			
			try {
				PreparedStatement preparador = con.prepareStatement(sql);
				
				//Retorno da consulta em Resultset
				ResultSet resultado = preparador.executeQuery();
				
				//Navega nos registros
				while(resultado.next()){
				
					//instancia o objeto Editora
					Editora editora = new Editora(); 
					
					//Carga de dados no Editora
					editora.setEditoraId(resultado.getInt("editora_id"));
					editora.setNomeFantasiaEditora(resultado.getString("nome_fantasia"));
					editora.setRazaoSocialEditora(resultado.getString("razao_social"));
					editora.setLogradouroEditora(resultado.getString("logradouro_editora"));
					editora.setNumEnderecoEditora(resultado.getString("num_endereco_editora"));
					editora.setBairroEditora(resultado.getString("bairro_editora"));
					editora.setCidadeEditora(resultado.getString("cidade_editora"));
					editora.setUfEditora(resultado.getString("uf_editora"));
					editora.setCepEditora(resultado.getString("cep_editora"));
					editora.setCnpjEditora(resultado.getString("cnpj_editora"));
					editora.setInscricaoEstadual(resultado.getString("inscricao_est_editora"));
					editora.setInscricaoMunicipal(resultado.getString("inscricao_mun_editora"));
					editora.setContatoPessoaEditora(resultado.getString("contato_pessoa_editora"));
					editora.setTipoTelefoneEditora(resultado.getString("tipo_telefone_editora"));
					editora.setTelefoneContatoEditora(resultado.getString("telefone_contato_editora"));
					editora.setEmailEditora(resultado.getString("email_editora"));
					editora.setComplementoEnderecoEditora(resultado.getString("comp_end_editora"));
				
					//adiciona na lista
					listaEditora.add(editora);
				}
				
				System.out.println("Busca com sucesso!");
				
			}catch(SQLException e1) {
				System.out.println("Erro de SQL:"+ e1.getMessage());
			}
			return listaEditora;
		}

}
