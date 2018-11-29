package br.com.livraria.controller.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.livraria.model.dao.LocacaoDao;
import br.com.livraria.model.entity.Locacao;

/**
 * Servlet implementation class LocacaoControl
 */
@WebServlet("/LocacaoControl")
public class LocacaoControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Criando um LocacaoDao
	LocacaoDao locacaoDao = new LocacaoDao();
	
	// Criando objeto locacao para atribuir valores
	Locacao locacao = new Locacao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LocacaoControl() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			try {
			
			String acao = request.getParameter("acao");
			String id = request.getParameter("locacao");
			
			// para apagar autor
			if(acao.equalsIgnoreCase("apagar")) {
				locacao.setLocacaoLivroId(Integer.parseInt(id));
				locacaoDao.excluir(locacao);
				
				RequestDispatcher view =  request.getRequestDispatcher("/locacao.jsp");
				request.setAttribute("lista", locacaoDao.buscaTodos());
				
				view.forward(request, response);
				
				// para editar autor
			} else if(acao.equalsIgnoreCase("editar")) {
			
				locacao = locacaoDao.buscarPorId(Integer.parseInt(id));
				
				RequestDispatcher view =  request.getRequestDispatcher("/locacao.jsp");
				request.setAttribute("locacao", locacao);
				
				view.forward(request, response);
			}
		}catch(Exception e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
				//Recebe dados da tela
				String id = request.getParameter("txtlocacaoLivroId");
				String nomeCliente = request.getParameter("cbnomeCliente").toString();
				String tituloLivro = request.getParameter("cbtituloLivro").toString();
				String dataLocacaoLivro = request.getParameter("dtLocaLivro").replaceAll("-", "/");
				String dataDevolucaoLivro = request.getParameter("dtDevLivro").replaceAll("-", "/");
				String qtdLivro = request.getParameter("txtqtdLivro");
				
				// Verificação para cadastrar ou alterar
				if(id!=null && id!="" && !id.isEmpty()) {
					locacao.setLocacaoLivroId(Integer.parseInt(id));
				}
				
				// Tratando Datas
				String[] dataSeparadaLocacao = dataLocacaoLivro .split("/");
				int diaLoc = Integer.parseInt(dataSeparadaLocacao[2]);
				int mesLoc = Integer.parseInt(dataSeparadaLocacao[1]);
				int anoLoc = Integer.parseInt(dataSeparadaLocacao[0]);
				
				String dataBancoLoc = diaLoc+"/"+mesLoc+"/"+anoLoc;
				
				String[] dataSeparadaDevolucao= dataDevolucaoLivro .split("/");
				int diaDev = Integer.parseInt(dataSeparadaDevolucao[2]);
				int mesDev = Integer.parseInt(dataSeparadaDevolucao[1]);
				int anoDev = Integer.parseInt(dataSeparadaDevolucao[0]);
				
				String dataBancoDev = diaDev+"/"+mesDev+"/"+anoDev;
				
				// captura os valores da tela para o objeto locacao
				locacao.setNomeCliente(nomeCliente);
				locacao.setTituloLivro(tituloLivro);
				locacao.setDataLocacaoLivro(dataBancoLoc);
				locacao.setDataDevolucaoLivro(dataBancoDev);
				locacao.setQtdLivro(Integer.parseInt(qtdLivro));
				
				locacaoDao.salvar(locacao);
				
					RequestDispatcher view =  request.getRequestDispatcher("/locacao.jsp");
					request.setAttribute("lista", locacaoDao.buscaTodos());
					
					view.forward(request, response);
			
				//Mensagem no Browser
				response.getWriter().print("Salvo com Sucesso");
	}

}
