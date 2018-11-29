package br.com.livraria.controller.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.livraria.model.dao.LivroDao;
import br.com.livraria.model.entity.Livro;

/**
 * Servlet implementation class LivroControl
 */
@WebServlet("/LivroControl")
public class LivroControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Criando um LivroDao
	LivroDao livroDao = new LivroDao();
	
	// Criando objeto livro para atribuir valores
	Livro livro = new Livro();
	
    public LivroControl() {
        super();
    }


    /**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
	}
	
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String acao = request.getParameter("acao");
			String id = request.getParameter("livro");
			
			if(acao.equalsIgnoreCase("apagar")) {
				livro.setLivroId(Integer.parseInt(id));
				livroDao.excluir(livro);
				
				RequestDispatcher view =  request.getRequestDispatcher("/livro.jsp");
				request.setAttribute("lista", livroDao.buscaTodos());
				
				view.forward(request, response);
			} else if(acao.equalsIgnoreCase("editar")) {
			
				livro = livroDao.buscarPorId(Integer.parseInt(id));
				
				RequestDispatcher view =  request.getRequestDispatcher("/livro.jsp");
				request.setAttribute("livro", livro);
				
				view.forward(request, response);
			}
			
		}catch(Exception e1) {
			e1.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		//Recebe dados da tela
		String id = request.getParameter("txtlivroId");
		String titulo= request.getParameter("txttituloLivro");
		String ano = request.getParameter("txtanoLivro");
		String edicao = request.getParameter("txtedicaoLivro");
		String editora = request.getParameter("cbnomeEditora");
		String isbn = request.getParameter("txtisbnLivro");
		String categ = request.getParameter("cbcategLivro");
		
		if(id!=null && id!="" && !id.isEmpty()) {
			livro.setLivroId(Integer.parseInt(id));
		}
		
		// captura os valores da tela para o objeto livro
		livro.setTituloLivro(titulo);
		livro.setAnoLivro(Integer.parseInt(ano));
		livro.setEdicaoLivro(edicao);
		livro.setEditoraLivro(editora);
		livro.setIsbnLivro(isbn);
		livro.setCategLivro(categ);
		
		livroDao.salvar(livro);
		
			RequestDispatcher view =  request.getRequestDispatcher("/livro.jsp");
			request.setAttribute("lista", livroDao.buscaTodos());
			
			view.forward(request, response);
		
		//Mensagem no Browser
		response.getWriter().print("Salvo com Sucesso");
		
	}

}
