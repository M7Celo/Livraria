package br.com.livraria.model.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.livraria.model.database.connection.SingleConnectionPostgre;
import br.com.livraria.model.entity.Cliente;

public class ClienteDao implements Serializable {

	private static final long serialVersionUID = 1L;

	private Connection con = SingleConnectionPostgre.getConnection();

	// Método para Salvar Cliente
	public void cadastrar(Cliente cliente) {

		String sql = "insert into public.cliente_tab(" + "nome_cliente, " + "rg_cliente, " + "cpf_cliente, "
				+ "data_nascimento, " + "endereco_cliente, " + "num_end_cliente, " + "comp_end_cliente, "
				+ "bairro_cliente, " + "cidade_cliente, " + "uf_cliente, " + "cep_cliente, " + "tipo_tel_cliente, "
				+ "telefone_cliente, " + "email_cliente) values(?," + " ?," + " ?," + " ?," + " ?," + " ?," + " ?,"
				+ " ?," + " ?," + " ?," + " ?," + " ?," + " ?," + " ?)";

		try {
			// Preparando SQL
			PreparedStatement preparador = con.prepareStatement(sql);

			// Substituindo os parametros do SQL pelos valores do objeto cliente
			preparador.setString(1, cliente.getNomeCliente());
			preparador.setString(2, cliente.getRgCliente());
			preparador.setString(3, cliente.getCpfCliente());
			preparador.setString(4, cliente.getDataNascimentoCliente());
			preparador.setString(5, cliente.getEnderecoCliente());
			preparador.setInt(6, cliente.getNumeroEnderecoCliente());
			preparador.setString(7, cliente.getComplementoCliente());
			preparador.setString(8, cliente.getBairroCliente());
			preparador.setString(9, cliente.getCidadeCliente());
			preparador.setString(10, cliente.getUfCliente());
			preparador.setString(11, cliente.getCepCliente());
			preparador.setString(12, cliente.getTipoTelefoneCliente());
			preparador.setString(13, cliente.getTelefoneCliente());
			preparador.setString(14, cliente.getEmailCliente());

			// Executa SQL
			preparador.execute();

			// Fecha Statment
			preparador.close();

			System.out.println("Cadastrado com sucesso!");

		} catch (SQLException e1) {
			System.out.println("Erro de SQL:" + e1.getMessage());
		}

	}

	// Método para atualizar Cliente
	public void alterar(Cliente cliente) {

		String sql = "update cliente_tab set nome_cliente=?, rg_cliente=?, cpf_cliente=?, data_nascimento=?, "
				+ "endereco_cliente=?, num_end_cliente=?, comp_end_cliente=?, bairro_cliente=?, "
				+ "cidade_cliente=?, uf_cliente=?, cep_cliente=?, tipo_tel_cliente=?, telefone_cliente=?, email_cliente=? where cliente_id=?";

		try {

			// Preparando o SQL
			PreparedStatement preparador = con.prepareStatement(sql);

			// Substituindo os parametros do SQL pelos valores do objeto cliente
			preparador.setString(1, cliente.getNomeCliente());
			preparador.setString(2, cliente.getRgCliente());
			preparador.setString(3, cliente.getCpfCliente());
			preparador.setString(4, cliente.getDataNascimentoCliente());
			preparador.setString(5, cliente.getEnderecoCliente());
			preparador.setInt(6, cliente.getNumeroEnderecoCliente());
			preparador.setString(7, cliente.getComplementoCliente());
			preparador.setString(8, cliente.getBairroCliente());
			preparador.setString(9, cliente.getCidadeCliente());
			preparador.setString(10, cliente.getUfCliente());
			preparador.setString(11, cliente.getCepCliente());
			preparador.setString(12, cliente.getTipoTelefoneCliente());
			preparador.setString(13, cliente.getTelefoneCliente());
			preparador.setString(14, cliente.getEmailCliente());
			preparador.setInt(15, cliente.getClienteId());

			// Executa SQL
			preparador.execute();

			// Fecha Statment
			preparador.close();

			System.out.println("Alterado com sucesso!");

		} catch (SQLException e1) {
			
			System.out.println("Erro de SQL aqui:" + e1.getMessage());
		}

	}

	// Método para Salvar o Cliente
	public void salvar(Cliente cliente) {
		if (cliente.getClienteId() != null && cliente.getClienteId() != 0) {
			alterar(cliente);
		} else {
			cadastrar(cliente);
		}
	}

	// Método para apagar Cliente
	public void excluir(Cliente cliente) {
		String sql = "delete from cliente_tab where cliente_id=?";

		try {

			// Preparando o SQL
			PreparedStatement preparador = con.prepareStatement(sql);

			// Substituindo os parametros do SQL pelos valores do objeto Cliente
			preparador.setInt(1, cliente.getClienteId());

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
			System.out.println("Erro de SQL:" + e1.getMessage());
		}
	}

	// Método para Buscar o Cliente por Id
	public Cliente buscarPorId(Integer id) {

		// Objeto de retorno do método
		Cliente clienteRetorno = null;

		String sql = "select * from cliente_tab where cliente_id=?";

		try {

			PreparedStatement preparador = con.prepareStatement(sql);

			// Substituindo os parametros do SQL pelos valores do objeto cliente
			preparador.setInt(1, id);

			// Retorno da consulta em Resultset
			ResultSet resultado = preparador.executeQuery();

			// Se tem registro
			if (resultado.next()) {

				// instancia o objeto Cliente
				clienteRetorno = new Cliente();

				clienteRetorno.setClienteId(resultado.getInt("cliente_id"));
				clienteRetorno.setNomeCliente(resultado.getString("nome_cliente"));
				clienteRetorno.setRgCliente(resultado.getString("rg_cliente"));
				clienteRetorno.setCpfCliente(resultado.getString("cpf_cliente"));
				clienteRetorno.setDataNascimentoCliente(resultado.getString("data_nascimento"));
				clienteRetorno.setEnderecoCliente(resultado.getString("endereco_cliente"));
				clienteRetorno.setNumeroEnderecoCliente(resultado.getInt("num_end_cliente"));
				clienteRetorno.setComplementoCliente(resultado.getString("comp_end_cliente"));
				clienteRetorno.setBairroCliente(resultado.getString("bairro_cliente"));
				clienteRetorno.setCidadeCliente(resultado.getString("cidade_cliente"));
				clienteRetorno.setUfCliente(resultado.getString("uf_cliente"));
				clienteRetorno.setCepCliente(resultado.getString("cep_Cliente"));
				clienteRetorno.setTipoTelefoneCliente(resultado.getString("tipo_tel_cliente"));
				clienteRetorno.setTelefoneCliente(resultado.getString("telefone_cliente"));
				clienteRetorno.setEmailCliente(resultado.getString("email_cliente"));

			}

			System.out.println("Encontrado com sucesso!");

		} catch (SQLException e1) {
			System.out.println("Erro de SQL:" + e1.getMessage());
		}
		return clienteRetorno;
	}

	// Método fazer uma lista com todos os registros de Clientes
	public List<Cliente> buscaTodos() {

		// Objeto de retorno do método
		List<Cliente> listaCliente = new ArrayList<Cliente>();

		String sql = "select * from cliente_tab order by cliente_id";

		try {

			PreparedStatement preparador = con.prepareStatement(sql);

			// Retorno da consulta em Resultset
			ResultSet resultado = preparador.executeQuery();

			// Navega nos registros
			while (resultado.next()) {

				// instancia o objeto Cliente
				Cliente cliente = new Cliente();

				cliente.setClienteId(resultado.getInt("cliente_id"));
				cliente.setNomeCliente(resultado.getString("nome_cliente"));
				cliente.setRgCliente(resultado.getString("rg_cliente"));
				cliente.setCpfCliente(resultado.getString("cpf_cliente"));
				cliente.setDataNascimentoCliente(resultado.getString("data_nascimento"));
				cliente.setEnderecoCliente(resultado.getString("endereco_cliente"));
				cliente.setNumeroEnderecoCliente(resultado.getInt("num_end_cliente"));
				cliente.setComplementoCliente(resultado.getString("comp_end_cliente"));
				cliente.setBairroCliente(resultado.getString("bairro_cliente"));
				cliente.setCidadeCliente(resultado.getString("cidade_cliente"));
				cliente.setUfCliente(resultado.getString("uf_cliente"));
				cliente.setCepCliente(resultado.getString("cep_Cliente"));
				cliente.setTipoTelefoneCliente(resultado.getString("tipo_tel_cliente"));
				cliente.setTelefoneCliente(resultado.getString("telefone_cliente"));
				cliente.setEmailCliente(resultado.getString("email_cliente"));

				// adiciona na lista
				listaCliente.add(cliente);

			}

			System.out.println("Busca com sucesso!");

		} catch (SQLException e1) {
			System.out.println("Erro de SQL:" + e1.getMessage());
		}

		return listaCliente;
	}
}
