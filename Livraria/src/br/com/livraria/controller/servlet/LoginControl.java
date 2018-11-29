package br.com.livraria.controller.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.livraria.model.dao.LoginDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/LoginControl")
public class LoginControl extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private LoginDao loginDao = new LoginDao();
       
    /**
     * Método Construtor
     */
    public LoginControl() {
        super();
    }

	/**
	 * Método de requisição GET
	 */
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * Método de requisição POST
	 */
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
			try {
			
			String login =  request.getParameter("loginUsuario");
			String senha = request.getParameter("senhaUsuario");
			
			if(loginDao.validarLogin(login, senha)) { // acesso ok
				RequestDispatcher requestDispatcher =  request.getRequestDispatcher("menu.jsp");
				requestDispatcher.forward(request, response);
			}else { // acesso negado
			RequestDispatcher requestDispatcher =  request.getRequestDispatcher("acessonegado.jsp");
			requestDispatcher.forward(request, response);
			}
		}catch(Exception e1){
			e1.printStackTrace();
		}
	}

}
