package br.com.livraria.controller.servlet;

import java.io.IOException;
//import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.livraria.model.dao.UsuarioDao;
import br.com.livraria.model.entity.Usuario;

/**
 * Servlet implementation class UsuarioControl
 */
@WebServlet("/UsuarioControl")
public class UsuarioControl extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	//criando um UsuarioDao
	UsuarioDao usuarioDao = new UsuarioDao();
	
	//criando objeto usuario para atribuir valores
	Usuario usuario = new Usuario();
	       
    /**
     * Método Construtor
     */
    public UsuarioControl() {
        super();
    }

    /**
	 * Método de requisição GET
	 */
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		try {
		String acao = request.getParameter("acao");
		String id = request.getParameter("usuario");
		
			if(acao.equalsIgnoreCase("apagar")) {
				usuario.setUsuarioId(Integer.parseInt(id));
				usuarioDao.excluir(usuario);
				
					RequestDispatcher view =  request.getRequestDispatcher("/usuario.jsp");
					request.setAttribute("lista", usuarioDao.buscaTodos());
					
					view.forward(request, response);
				}
			else if(acao.equalsIgnoreCase("editar")) {
				
				usuario = usuarioDao.buscarPorId(Integer.parseInt(id));
				
				RequestDispatcher view =  request.getRequestDispatcher("/usuario.jsp");
				request.setAttribute("usuario", usuario);
				
				view.forward(request, response);
			}
		}catch(Exception e1) {
			e1.printStackTrace();	
			}
		
	}

	/**
	 * Método de requisição POST
	 */
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		// Captura a ação
		//String acao = request.getParameter("acao");
		
		//Recebe dados da tela
		String id = request.getParameter("txtusuarioId");
		String nome = request.getParameter("txtnomeUsuario");
		String login = request.getParameter("txtloginUsuario");
		String senha = request.getParameter("pwsenhaUsuario");
		
		if(id!=null && id!="" && !id.isEmpty()) {
			usuario.setUsuarioId(Integer.parseInt(id));
		}
		
		// captura os valores da tela para o objeto usuário 
		usuario.setNomeUsuario(nome);
		usuario.setLoginUsuario(login);
		usuario.setSenhaUsuario(senha);
		
		
		usuarioDao.salvar(usuario);		
		
			RequestDispatcher view =  request.getRequestDispatcher("/usuario.jsp");
			request.setAttribute("lista", usuarioDao.buscaTodos());
			
			view.forward(request, response);
	
		//Mensagem no Browser
		response.getWriter().print("Salvo com Sucesso");
		
	}

}
