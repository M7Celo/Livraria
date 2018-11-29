package br.com.livraria.controller.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.livraria.model.dao.ClienteDao;
import br.com.livraria.model.entity.Cliente;

/**
 * Servlet implementation class ClienteControl
 */
@WebServlet("/ClienteControl")
public class ClienteControl extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	// Criando um ClienteDao
	ClienteDao clienteDao = new ClienteDao();
	
	// Criando objeto cliente para atribuir valores
	Cliente cliente = new Cliente();
	
	/**
     * Método Construtor
     */
    public ClienteControl() {
        super();
    }

    /**
	 * Método de requisição GET
	 */
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
			try {
			
			String acao = request.getParameter("acao");
			String id = request.getParameter("cliente");
			
			System.out.println("Id: "+id);
			
			// para apagar cliente
			if(acao.equalsIgnoreCase("apagar")) {
				cliente.setClienteId(Integer.parseInt(id));
				clienteDao.excluir(cliente);
				
				RequestDispatcher view =  request.getRequestDispatcher("/cliente.jsp");
				request.setAttribute("lista", clienteDao.buscaTodos());
				
				view.forward(request, response);
				
				// para editar cliente
			} else if(acao.equalsIgnoreCase("editar")) {
				
				cliente = clienteDao.buscarPorId(Integer.parseInt(id));
				
				RequestDispatcher view =  request.getRequestDispatcher("/cliente.jsp");
				request.setAttribute("cliente", cliente);
				
				view.forward(request, response);
				}
			}catch(Exception e1) {
				e1.printStackTrace();
			}
	}

	/**
	 * Método de requisição POST
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Recebe dados da tela
		String id = request.getParameter("txtclienteId");
		String nomeCliente  = request.getParameter("txtnomecliente");
		String rgCliente  = request.getParameter("txtrgCliente");
		String cpfCliente  = request.getParameter("txtcpfCliente");
		String dataNascCliente  = request.getParameter("dtNascCliente").replaceAll("-", "/");
		String endCliente  = request.getParameter("txtenderecoCliente");
		String numEndCliente  = request.getParameter("txtnumEndCliente");
		String compCliente  = request.getParameter("txtcompEndCliente");
		String bairroCliente  = request.getParameter("txtbairroCliente");
		String cidadeCliente  = request.getParameter("txtcidadeCliente");
		String ufCliente  = request.getParameter("cbufCliente").toString();
		String cepCliente  = request.getParameter("txtcepCliente");
		String tipoTelefoneCliente  = request.getParameter("cbtipoTelefone").toString();
		String telefoneCliente  = request.getParameter("txttelCliente");
		String emailCliente  = request.getParameter("txtemailCliente");
		
		String[] dataSeparada = dataNascCliente.split("/");
		int dia = Integer.parseInt(dataSeparada[2]);
		int mes = Integer.parseInt(dataSeparada[1]);
		int ano = Integer.parseInt(dataSeparada[0]);
		
		String dataBanco = dia+"/"+mes+"/"+ano;
		
		boolean verifica = true;
		
		if(id!=null && id!="" && !id.isEmpty()) {
			cliente.setClienteId(Integer.parseInt(id));
			verifica = true;
		}
		
		
		// captura os valores da tela para o objeto usuário 
		cliente.setNomeCliente(nomeCliente);
		cliente.setRgCliente(rgCliente);
		cliente.setCpfCliente(cpfCliente);		
		cliente.setDataNascimentoCliente(dataBanco);
		cliente.setEnderecoCliente(endCliente);
		cliente.setNumeroEnderecoCliente(Integer.parseInt(numEndCliente));
		cliente.setComplementoCliente(compCliente);
		cliente.setBairroCliente(bairroCliente);
		cliente.setCidadeCliente(cidadeCliente);
		cliente.setUfCliente(ufCliente);
		cliente.setCepCliente(cepCliente);
		cliente.setTipoTelefoneCliente(tipoTelefoneCliente);
		cliente.setTelefoneCliente(telefoneCliente);
		cliente.setEmailCliente(emailCliente);
		
		//clienteDao.salvar(cliente);
		
		if(verifica == true) {
			clienteDao.alterar(cliente);
		}else if(verifica == false) {
			clienteDao.cadastrar(cliente); 
		}
		
			RequestDispatcher view =  request.getRequestDispatcher("/cliente.jsp");
			request.setAttribute("lista", clienteDao.buscaTodos());
			
			view.forward(request, response);
		
		//Mensagem no Browser
		response.getWriter().print("Salvo com Sucesso");
	}
	
}
