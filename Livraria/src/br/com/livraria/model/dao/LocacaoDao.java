package br.com.livraria.model.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.livraria.model.database.connection.SingleConnectionPostgre;
import br.com.livraria.model.entity.Locacao;

public class LocacaoDao implements Serializable {

	private static final long serialVersionUID = 1L;

	private Connection con = SingleConnectionPostgre.getConnection();

	// Método para Cadastrar Locação
	public void cadastrar(Locacao locacao) {

		String sql = "INSERT INTO public.locacao_tab(nome_cliente, titulo_livro, data_locacao, data_devolucao, qtd_livro) VALUES (?, ?, ?, ?, ?)";

		try {
			// Preparando SQL
			PreparedStatement preparador = con.prepareStatement(sql);

			// Substituindo os parametros do SQL pelos valores do objeto Locação
			preparador.setString(1, locacao.getNomeCliente());
			preparador.setString(2, locacao.getTituloLivro());
			preparador.setString(3, locacao.getDataLocacaoLivro());
			preparador.setString(4, locacao.getDataDevolucaoLivro());
			preparador.setInt(5, locacao.getQtdLivro());

			// Executa SQL
			preparador.execute();

			// Fecha Statment
			preparador.close();

			System.out.println("Cadastrado com sucesso!");

		} catch (SQLException e1) {
			System.out.println("Erro de SQL:" + e1.getMessage());
		}
	}

	// Método para atualizar Locação
	public void alterar(Locacao locacao) {

		String sql = "UPDATE public.locacao_tab SET nome_cliente=?, titulo_livro=?, data_locacao=?, data_devolucao=?, qtd_livro=? WHERE locacao_id=?";

		try {

			// Preparando o SQL
			PreparedStatement preparador = con.prepareStatement(sql);

			// Substituindo os parametros do SQL pelos valores do objeto Locação
			preparador.setString(1, locacao.getNomeCliente());
			preparador.setString(2, locacao.getTituloLivro());
			preparador.setString(3, locacao.getDataLocacaoLivro());
			preparador.setString(4, locacao.getDataDevolucaoLivro());
			preparador.setInt(5, locacao.getQtdLivro());
			preparador.setInt(6, locacao.getLocacaoLivroId());

			// Executa SQL
			preparador.execute();

			// Fecha Statment
			preparador.close();

			System.out.println("Alterado com sucesso!");

		} catch (SQLException e1) {
			System.out.println("Erro de SQL:" + e1.getMessage());
		}
	}

	// Método para Salvar o Locação
	public void salvar(Locacao locacao) {
				if(locacao.getLocacaoLivroId()!=null && locacao.getLocacaoLivroId()!=0) {
					alterar(locacao);
				}else {
					cadastrar(locacao);
				}
			}
	
	// Método para apagar Locação
	public void excluir(Locacao locacao) {
		
		String sql = "DELETE FROM locacao_tab WHERE locacao_id=?";
		
		try {
			
			// Preparando o SQL
			PreparedStatement preparador = con.prepareStatement(sql);
			
			// Substituindo os parametros do SQL pelos valores do objeto Locação
			preparador.setInt(1, locacao.getLocacaoLivroId());
			
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
	
	// Método para Buscar o Locação por Id
	public Locacao buscarPorId(Integer id) {
		
		//Objeto de retorno do método
		Locacao locacaoRetorno = null;
		
		String sql = "select * from locacao_tab where locacao_id=?";
		
		try {
			
			PreparedStatement preparador = con.prepareStatement(sql);
			
			// Substituindo os parametros do SQL pelos valores do objeto autor
			preparador.setInt(1,id);
			
			//Retorno da consulta em Resultset
			ResultSet resultado = preparador.executeQuery();
			
			//Se tem registro
			if(resultado.next()){
				
				//instancia o objeto Locação
				locacaoRetorno = new Locacao();
				
				locacaoRetorno.setLocacaoLivroId(resultado.getInt("locacao_id"));
				locacaoRetorno.setNomeCliente(resultado.getString("nome_cliente"));
				locacaoRetorno.setTituloLivro(resultado.getString("titulo_livro"));
				locacaoRetorno.setDataLocacaoLivro(resultado.getString("data_locacao"));
				locacaoRetorno.setDataDevolucaoLivro(resultado.getString("data_devolucao"));
				locacaoRetorno.setQtdLivro(resultado.getInt("qtd_livro"));
				
			}
			
		}catch(SQLException e1) {
			System.out.println("Erro de SQL:"+ e1.getMessage());
		}
		return locacaoRetorno;
	}
	
	// Método fazer uma lista com todos os registros de Locações
	public List<Locacao> buscaTodos(){
		
		List<Locacao> listaLocacao = new ArrayList<Locacao>();
		
		String sql = "SELECT * FROM locacao_tab  order by locacao_id";
		
		try {
			
			PreparedStatement preparador = con.prepareStatement(sql);
			
			//Retorno da consulta em Resultset
			ResultSet resultado = preparador.executeQuery();
			
			//Navega nos registros
			while(resultado.next()){
				
				//instancia o objeto Locação
				Locacao locacao = new Locacao();
				
				locacao.setLocacaoLivroId(resultado.getInt("locacao_id"));
				locacao.setNomeCliente(resultado.getString("nome_cliente"));
				locacao.setTituloLivro(resultado.getString("titulo_livro"));
				locacao.setDataLocacaoLivro(resultado.getString("data_locacao"));
				locacao.setDataDevolucaoLivro(resultado.getString("data_devolucao"));
				locacao.setQtdLivro(resultado.getInt("qtd_livro"));
				
				//adiciona na lista
				listaLocacao.add(locacao);
				
			}
		}catch(SQLException e1) {
			System.out.println("Erro de SQL:"+ e1.getMessage());
		}
		return listaLocacao; 
	}
}
