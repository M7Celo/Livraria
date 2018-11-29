package br.com.livraria.model.database.connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Responsável por fazer a conexão com o banco de dados
 * @author Marcelo
 *
 */

public class SingleConnectionPostgre {
	
	private static String urlDatabase= "jdbc:postgresql://localhost:5432/livraria?autoReconnect=true";
	private static String password = "admin";
	private static String user = "admin";
	
	private static Connection connection = null;

	// Chamando o método conectar
	static {
		conectar();
	}
	
	public SingleConnectionPostgre() {
		conectar();
	}
	
	private static void conectar() {
		try {
			
			if(connection == null) {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(urlDatabase, user, password);
				connection.setAutoCommit(false);
			}
			
		}catch(Exception e) {
			throw new RuntimeException("Erro ao conectar com o banco de dados!");
		}
	}
	
	// 
	public static Connection getConnection() {
		return connection;
	}
}
