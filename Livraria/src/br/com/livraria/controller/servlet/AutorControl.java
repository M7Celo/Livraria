package br.com.livraria.controller.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.livraria.model.dao.AutorDao;
import br.com.livraria.model.entity.Autor;

/**
 * Servlet implementation class AutorControl
 */
@WebServlet("/AutorControl")
public class AutorControl extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
		
	// Criando um AutorDao
	AutorDao autorDao = new AutorDao();
	
	// Criando objeto autor para atribuir valores
	Autor autor = new Autor();
       
	/**
     * Método Construtor
     */
    public AutorControl() {
        super();
    }

    /**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
	}
	
    /**
	 * Método de requisição GET
	 */
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			
			String acao = request.getParameter("acao");
			String id = request.getParameter("autor");
			
			// para apagar autor
			if(acao.equalsIgnoreCase("apagar")) {
				autor.setAutorId(Integer.parseInt(id));
				autorDao.excluir(autor);
				
				//valores iniciais
				id ="";
				acao = "";
				
				RequestDispatcher view =  request.getRequestDispatcher("/autor.jsp");
				request.setAttribute("lista", autorDao.buscaTodos());
				
				view.forward(request, response);
				
				// para editar autor
			} else if(acao.equalsIgnoreCase("editar")) {
			
				autor = autorDao.buscarPorId(Integer.parseInt(id));
								
				RequestDispatcher view =  request.getRequestDispatcher("/autor.jsp");
				request.setAttribute("autor", autor);
				
				view.forward(request, response);
				
				//valores iniciais
				id ="";
				acao = "";
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
		
		
		//Recebe dados da tela
		String id = request.getParameter("txtautorId");
		String nome = request.getParameter("txtnomeAutor");	
		String livro = request.getParameter("cbnomeLivro").toString();		
		
		if(id!=null && id!="" && !id.isEmpty()) {
			autor.setAutorId(Integer.parseInt(id));
		}
		
		// captura os valores da tela para o objeto autor
		autor.setNomeAutor(nome);
		autor.setNomeLivro(livro);
		
		autorDao.salvar(autor);
		
		//valores iniciais
		id ="";
		nome = "";
		livro ="";
		
			RequestDispatcher view =  request.getRequestDispatcher("/autor.jsp");
			request.setAttribute("lista", autorDao.buscaTodos());
			
			view.forward(request, response);
		
		//Mensagem no Browser
		response.getWriter().print("Salvo com Sucesso");
		
	}
	

}
