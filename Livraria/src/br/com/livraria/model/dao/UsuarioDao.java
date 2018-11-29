package br.com.livraria.model.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.livraria.model.database.connection.SingleConnectionPostgre;
import br.com.livraria.model.entity.Usuario;

public class UsuarioDao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Connection con = SingleConnectionPostgre.getConnection();

	// Método para Cadastrar Usuário
	public void cadastrar(Usuario usu) {
		
		String sql = "insert into usuario_tab (login_usuario, nome_usuario, senha_usuario) values(?, ?,md5(?))";
		
		try {
			// Preparando SQL
			PreparedStatement preparador = con.prepareStatement(sql);
			
			// Substituindo os parametros do SQL pelos valores do objeto usuario
			preparador.setString(1, usu.getLoginUsuario());
			preparador.setString(2, usu.getNomeUsuario());
			preparador.setString(3, usu.getSenhaUsuario());
			
			// Executa SQL
			preparador.execute();
			
			// Fecha Statment
			preparador.close();
			
			System.out.println("Cadastrado com sucesso!");
			
		} catch (SQLException e) {
			System.out.println("Erro de SQL:" + e.getMessage());
		}
	}
	

	// Método para Atualizar Usuário
	public void alterar(Usuario usu){
		
		String sql = "update usuario_tab set nome_usuario=?, login_usuario=?, senha_usuario=md5(?) where usuario_id=?";
		
		try {
			
			// Preparando o SQL
			PreparedStatement preparador = con.prepareStatement(sql);
			
			// Substituindo os parametros do SQL pelos valores do objeto usuario
			preparador.setString(1, usu.getNomeUsuario());
			preparador.setString(2, usu.getLoginUsuario());
			preparador.setString(3, usu.getSenhaUsuario());
			preparador.setInt(4, usu.getUsuarioId());
			
			// Executa SQL
			preparador.execute();
			
			// Fecha Statment
			preparador.close();
			
			System.out.println("Alterado com sucesso!");
			
		} catch (SQLException e) {
			System.out.println("Erro de SQL:"+ e.getMessage());
		}
	}
	
	// Método para Salvar o Usuário
	public void salvar(Usuario usuario) {
		if(usuario.getUsuarioId()!=null && usuario.getUsuarioId()!=0) {
			alterar(usuario);
		}else {
			cadastrar(usuario);
		}
		
	}	
	
	// Método para Apagar Usuário
	public void excluir(Usuario usu){
		
		String sql = "delete from usuario_tab where usuario_id=?";
		
		try {
			
			// Preparando o SQL
			PreparedStatement preparador = con.prepareStatement(sql);
			
			// Substituindo os parametros do SQL pelos valores do objeto usuario
			preparador.setInt(1, usu.getUsuarioId());
			
			// Executa SQL
			preparador.execute();
			
			// Fecha Statment
			preparador.close();
			
			System.out.println("Excluído com sucesso!");
			
		} catch (SQLException e1) {
			try {
				con.rollback();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			System.out.println("Erro de SQL:"+ e1.getMessage());
		}
	}
	
	
	// Método para Buscar o Usuário por Id
	public Usuario buscarPorId(Integer id) {
		
		//Objeto de retorno do método
		Usuario usuRetorno = null;
		
		String sql = "select * from usuario_tab  where usuario_id=?";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			
			// Substituindo os parametros do SQL pelos valores do objeto usuario
			preparador.setInt(1,id);
			
			//Retorno da consulta em Resultset
			ResultSet resultado = preparador.executeQuery();
			
			//Se tem registro
			if(resultado.next()){
				
			//instancia o objeto Usuario
			usuRetorno = new Usuario();
			
			usuRetorno.setUsuarioId(resultado.getInt("usuario_id"));
			usuRetorno.setNomeUsuario(resultado.getString("nome_usuario"));
			usuRetorno.setLoginUsuario(resultado.getString("login_usuario"));
			usuRetorno.setSenhaUsuario(resultado.getString("senha_usuario"));
			}
			
			System.out.println("Encontrado com sucesso!");
			
		}catch (SQLException e) {
			System.out.println("Erro de SQL:"+ e.getMessage());
		}
		return usuRetorno;
	}
	
	
	// Método fazer uma lista com todos os registros de usuários
	public List<Usuario> buscaTodos(){
		
		//Objeto de retorno do método
		List<Usuario> listaUsuario = new ArrayList<Usuario>();
		
		String sql = "select * from usuario_tab order by usuario_id";
		
		try {
		PreparedStatement preparador = con.prepareStatement(sql);
		
		//Retorno da consulta em Resultset
		ResultSet resultado = preparador.executeQuery();
		
			//Navega nos registros
			while(resultado.next()){
				
				//instancia o objeto Usuario
				Usuario usuario = new Usuario();
				
				//Carga de dados no usuário
				usuario.setUsuarioId(resultado.getInt("usuario_id"));
				usuario.setNomeUsuario(resultado.getString("nome_usuario"));
				usuario.setLoginUsuario(resultado.getString("login_usuario"));
				usuario.setSenhaUsuario(resultado.getString("senha_usuario"));
				
			//adiciona na lista
			listaUsuario.add(usuario);
			}
			
			System.out.println("Busca com sucesso!");
			
		} catch (SQLException e1) {
			System.out.println("Erro de SQL:"+ e1.getMessage());
		}
		return listaUsuario;
		}
	
}
