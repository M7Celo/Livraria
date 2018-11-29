package br.com.livraria.model.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.livraria.model.database.connection.SingleConnectionPostgre;
import br.com.livraria.model.entity.Livro;

public class LivroDao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Connection con = SingleConnectionPostgre.getConnection();
		
	// Método para Salvar Livro
			public void cadastrar(Livro livro) {
				
				String sql = "INSERT INTO livro_tab(" 
				+ "titulo_livro, "
				+ "edicao_livro, "
				+ "editora_livro, "
				+ "categ_livro, " 
				+ "ano_livro, "
				+ "isbn_livro) VALUES "
				+ "(?, ?, ?, ?, ?, ?)";
				
				try {
					// Preparando SQL
					PreparedStatement preparador = con.prepareStatement(sql);
					
					// Substituindo os parametros do SQL pelos valores do objeto livro
					preparador.setString(1, livro.getTituloLivro());
					preparador.setString(2, livro.getEdicaoLivro());
					preparador.setString(3, livro.getEditoraLivro());
					preparador.setString(4, livro.getCategLivro());
					preparador.setInt(5, livro.getAnoLivro());
					preparador.setString(6, livro.getIsbnLivro());
					
					// Executa SQL
					preparador.execute();
					
					// Fecha Statment
					preparador.close();
					
					System.out.println("Cadastrado com sucesso!");
					
				}catch(SQLException e1) {
					System.out.println("Erro de SQL:" + e1.getMessage());
				}
				
			}
			
			// Método para atualizar Livro
			public void alterar(Livro livro) {
				
				String sql = "UPDATE livro_tab SET "
						+ "titulo_livro=?, "
						+ "edicao_livro=?, "
						+ "editora_livro=?, "
						+ "categ_livro=?, "
						+ "ano_livro=?, "
						+ "isbn_livro=? "
						+ "WHERE livro_id=?";
			
				try {
					
					// Preparando o SQL
					PreparedStatement preparador = con.prepareStatement(sql);
					
					// Substituindo os parametros do SQL pelos valores do objeto usuario
					preparador.setString(1, livro.getTituloLivro());
					preparador.setString(2, livro.getEdicaoLivro());
					preparador.setString(3, livro.getEditoraLivro());
					preparador.setString(4, livro.getCategLivro());
					preparador.setInt(5, livro.getAnoLivro());
					preparador.setString(6, livro.getIsbnLivro());
					preparador.setInt(7, livro.getLivroId());
					
					// Executa SQL
					preparador.execute();
					
					// Fecha Statment
					preparador.close();
					
					System.out.println("Alterado com sucesso!");
					
				}catch(SQLException e1) {
					System.out.println("Erro de SQL:"+ e1.getMessage());
				}
			}
	
			// Método para Salvar o Autor
			public void salvar(Livro livro) {
				if(livro.getLivroId()!=null && livro.getLivroId()!=0) {
					alterar(livro);
				}else {
					cadastrar(livro);
				}
			}
		
			// Método para apagar Livro
			public void excluir(Livro livro) {
				
				String sql = "DELETE FROM livro_tab WHERE WHERE livro_id=?";
				
				try {
					
					// Preparando o SQL
					PreparedStatement preparador = con.prepareStatement(sql);
					
					// Substituindo os parametros do SQL pelos valores do objeto Autor
					preparador.setInt(1, livro.getLivroId());
					
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
			
			// Método para Buscar o Livro por Id
			public Livro buscarPorId(Integer id) {
				
				//Objeto de retorno do método
				Livro livroRetorno = null;
				
				String sql = "select * from livro_tab  where livro_id=?";
				
				try {
					
					PreparedStatement preparador = con.prepareStatement(sql);
					
					// Substituindo os parametros do SQL pelos valores do objeto livro
					preparador.setInt(1,id);
					
					//Retorno da consulta em Resultset
					ResultSet resultado = preparador.executeQuery();
					
					//Se tem registro
					if(resultado.next()){
						
					//instancia o objeto Usuario
					livroRetorno = new Livro();
					
					livroRetorno.setLivroId(resultado.getInt("livro_id"));
					livroRetorno.setTituloLivro(resultado.getString("titulo_livro"));
					livroRetorno.setEdicaoLivro(resultado.getString("edicao_livro"));
					livroRetorno.setEditoraLivro(resultado.getString("editora_livro"));
					livroRetorno.setIsbnLivro(resultado.getString("isbn_livro"));
					livroRetorno.setCategLivro(resultado.getString("categ_livro"));
					livroRetorno.setAnoLivro(resultado.getInt("ano_livro"));
					
					}
					
					System.out.println("Encontrado com sucesso!");
					
				}catch(SQLException e1) {
					System.out.println("Erro de SQL:"+ e1.getMessage());
				}
				return livroRetorno;
			}
			
			// Método fazer uma lista com todos os registros de Autores
			public List<Livro> buscaTodos(){
				
				//Objeto de retorno do método
				List<Livro> listaLivro = new ArrayList<Livro>();
				
				String sql = "select * from livro_tab order by livro_id";
				
				try {
					
					PreparedStatement preparador = con.prepareStatement(sql);
					
					//Retorno da consulta em Resultset
					ResultSet resultado = preparador.executeQuery();
					
						//Navega nos registros
						while(resultado.next()){
							
						//instancia o objeto Livro
						Livro livro = new Livro();
						
						livro.setLivroId(resultado.getInt("livro_id"));
						livro.setTituloLivro(resultado.getString("titulo_livro"));
						livro.setEdicaoLivro(resultado.getString("edicao_livro"));
						livro.setEditoraLivro(resultado.getString("editora_livro"));
						livro.setIsbnLivro(resultado.getString("isbn_livro"));
						livro.setCategLivro(resultado.getString("categ_livro"));
						livro.setAnoLivro(resultado.getInt("ano_livro"));
						
						//adiciona na lista
						listaLivro.add(livro);
						
						}
						
						System.out.println("Busca com sucesso!");
						
				}catch(SQLException e1) {
					System.out.println("Erro de SQL:"+ e1.getMessage());
				}
				return listaLivro;
			}

}
