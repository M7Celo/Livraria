package br.com.livraria.model.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.livraria.model.database.connection.SingleConnectionPostgre;
import br.com.livraria.model.entity.Autor;

public class AutorDao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Connection con = SingleConnectionPostgre.getConnection();
	
	// Método para Salvar Autor
		public void cadastrar(Autor autor) {
			
			String sql = "insert into autor_tab (nome_autor, nome_livro)  VALUES(?,?)";
			
			try {
				// Preparando SQL
				PreparedStatement preparador = con.prepareStatement(sql);
				
				// Substituindo os parametros do SQL pelos valores do objeto autor
				preparador.setString(1, autor.getNomeAutor());
				preparador.setString(2, autor.getNomeLivro());
				
				// Executa SQL
				preparador.execute();
				
				// Fecha Statment
				preparador.close();
				
				System.out.println("Cadastrado com sucesso!");
				
			}catch(SQLException e1) {
				System.out.println("Erro de SQL:" + e1.getMessage());
			}
			
		}
		
		// Método para atualizar Autor
		public void alterar(Autor autor){
			
			String sql = "update autor_tab set nome_autor=?, nome_livro=? where autor_id=?";
			
			try {
				
				// Preparando o SQL
				PreparedStatement preparador = con.prepareStatement(sql);
				
				// Substituindo os parametros do SQL pelos valores do objeto usuario
				preparador.setString(1, autor.getNomeAutor());
				preparador.setString(2, autor.getNomeLivro());
				preparador.setInt(3, autor.getAutorId());
				
				// Executa SQL
				preparador.execute();
				
				// Fecha Statment
				preparador.close();
				
				System.out.println("Alterado com sucesso!");
			
		}catch (SQLException e1) {
			System.out.println("Erro de SQL:"+ e1.getMessage());
		}
			
	}
		
		// Método para Salvar o Autor
		public void salvar(Autor autor) {
			if(autor.getAutorId()!=null && autor.getAutorId()!=0) {
				alterar(autor);
			}else {
				cadastrar(autor);
			}
			
		}
		
		// Método para apagar Autor
		public void excluir(Autor autor){
			
			String sql = "delete from autor_tab where autor_id=?";
			
			try {
				
				// Preparando o SQL
				PreparedStatement preparador = con.prepareStatement(sql);
				
				// Substituindo os parametros do SQL pelos valores do objeto Autor
				preparador.setInt(1, autor.getAutorId());
				
				// Executa SQL
				preparador.execute();
				
				// Fecha Statment
				preparador.close();
				
				System.out.println("Excluído com sucesso!");
				
			}catch (SQLException e1) {
				try {
					con.rollback();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				System.out.println("Erro de SQL:"+ e1.getMessage());
			}
		}
		
		// Método para Buscar o Autor por Id
		public Autor buscarPorId(Integer id) {
			
			//Objeto de retorno do método
			Autor autorRetorno = null;
			
			String sql = "select * from autor_tab where autor_id=?";
			
			try {
				
				PreparedStatement preparador = con.prepareStatement(sql);
				
				// Substituindo os parametros do SQL pelos valores do objeto autor
				preparador.setInt(1,id);
				
				//Retorno da consulta em Resultset
				ResultSet resultado = preparador.executeQuery();
				
				//Se tem registro
				if(resultado.next()){
					
				//instancia o objeto Autor
				autorRetorno = new Autor();
				
				autorRetorno.setAutorId(resultado.getInt("autor_id"));
				autorRetorno.setNomeAutor(resultado.getString("nome_autor"));
				autorRetorno.setNomeLivro(resultado.getString("nome_livro"));
				
				}

				System.out.println("Encontrado com sucesso!");
				
			}catch (SQLException e1) {
				System.out.println("Erro de SQL:"+ e1.getMessage());
			}
			return autorRetorno;
		}
		
		// Método fazer uma lista com todos os registros de Autores
		public List<Autor> buscaTodos(){
			
			//Objeto de retorno do método
			List<Autor> listaAutor = new ArrayList<Autor>();
			
			String sql = "select * from autor_tab order by autor_id";
			
			try {
				
				PreparedStatement preparador = con.prepareStatement(sql);
				
				//Retorno da consulta em Resultset
				ResultSet resultado = preparador.executeQuery();
				
					//Navega nos registros
					while(resultado.next()){
						
					//instancia o objeto Autor
					Autor autor = new Autor();
					
					autor.setAutorId(resultado.getInt("autor_id"));
					autor.setNomeAutor(resultado.getString("nome_autor"));
					autor.setNomeLivro(resultado.getString("nome_livro"));
					
					//adiciona na lista
					listaAutor.add(autor);
						
					}
				
					System.out.println("Busca com sucesso!");
					
			}catch(SQLException e1) {
				System.out.println("Erro de SQL:"+ e1.getMessage());
			}
			return listaAutor;
		}

}
