package br.com.livraria.model.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.livraria.model.database.connection.SingleConnectionPostgre;

public class LoginDao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Connection connection;
	
	public LoginDao() {
		
		connection = SingleConnectionPostgre.getConnection();
	}
	
	public boolean validarLogin(String login, String senha) throws Exception{
		
		String sql = "select * from usuario_tab where login_usuario = '"+login+
				"' and senha_usuario =md5( '"+senha+"')";
		
		// Prepara a String sql
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		ResultSet resultSet =  preparedStatement.executeQuery();
		
		if(resultSet.next()) {
			return true; // validou o usuário
		}else {
			return false; // não validou o usuário
		}
		
	}

}
