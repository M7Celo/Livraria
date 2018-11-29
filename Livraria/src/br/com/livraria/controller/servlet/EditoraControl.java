package br.com.livraria.controller.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.livraria.model.dao.EditoraDao;
import br.com.livraria.model.entity.Editora;

/**
 * Servlet implementation class EditoraControl
 */
@WebServlet("/EditoraControl")
public class EditoraControl extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	//criando um EditoraDao
	EditoraDao editoraDao = new EditoraDao();
	
	//criando objeto editora para atribuir valores
	Editora editora = new Editora();
	
	/**
     * Método Construtor
     */
    public EditoraControl() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
	
		try {
			String acao = request.getParameter("acao");
			String id = request.getParameter("editora");
			
			if(acao.equalsIgnoreCase("apagar")) {
				editora.setEditoraId(Integer.parseInt(id));
				editoraDao.excluir(editora);
				
				RequestDispatcher view =  request.getRequestDispatcher("/editora.jsp");
				request.setAttribute("lista", editoraDao.buscaTodos());
				
				view.forward(request, response);
			} else if(acao.equalsIgnoreCase("editar")) {
				
				editora = editoraDao.buscarPorId(Integer.parseInt(id));
				
				RequestDispatcher view =  request.getRequestDispatcher("/editora.jsp");
				request.setAttribute("editora", editora);
				
				view.forward(request, response);
			}
		}catch(Exception e1) {
			e1.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		//Recebe dados da tela
		String id = request.getParameter("txteditoraId");
		String nomeFantasia = request.getParameter("txtnomeFantasia"); 
		String razaoSocial = request.getParameter("txtrazaoSocial");
		String logradouroEditora = request.getParameter("txtlogradouroEditora");
		String numEndEditora = request.getParameter("txtnumEndEditora");
		String bairroEditora = request.getParameter("txtbairroEditora");
		String cidadeEditora = request.getParameter("txtcidadeEditora");
		
		String cepEditora = request.getParameter("txtcepEditora");
		String cnpjEditora = request.getParameter("txtcnpjEditora"); 
		String inscricaoEstEditora = request.getParameter("txtinscricaoEstEditora");
		String inscricaoMunEditora = request.getParameter("txtinscricaoMunEditora"); 
		String contatoPessoaEditora = request.getParameter("txtcontatoPessoaEditora");
		
		String ufEditora = request.getParameter("cbufEditora").toString();
		String tipoTelefoneEditora = request.getParameter("cbtipoTelefone").toString();
		
		String telefoneContatoEditora = request.getParameter("txttelefoneContatoEditora");
		String emailEditora = request.getParameter("txtemailEditora");
		String compEndEditora = request.getParameter("txtcompEndEditora");
		
		
		if(id!=null && id!="" && !id.isEmpty()) {
			editora.setEditoraId(Integer.parseInt(id));
		}
		
		// captura os valores da tela para o objeto editora
		editora.setNomeFantasiaEditora(nomeFantasia);
		editora.setRazaoSocialEditora(razaoSocial);
		editora.setLogradouroEditora(logradouroEditora);
		editora.setNumEnderecoEditora(numEndEditora);
		editora.setBairroEditora(bairroEditora);
		editora.setCidadeEditora(cidadeEditora);
		editora.setUfEditora(ufEditora.toString());
		editora.setCepEditora(cepEditora);
		editora.setCnpjEditora(cnpjEditora);
		editora.setInscricaoEstadual(inscricaoEstEditora);
		editora.setInscricaoMunicipal(inscricaoMunEditora);
		editora.setContatoPessoaEditora(contatoPessoaEditora);;
		editora.setTipoTelefoneEditora(tipoTelefoneEditora);
		editora.setTelefoneContatoEditora(telefoneContatoEditora);
		editora.setEmailEditora(emailEditora);
		editora.setComplementoEnderecoEditora(compEndEditora);
		
		editoraDao.salvar(editora);
	
			RequestDispatcher view =  request.getRequestDispatcher("/editora.jsp");
			request.setAttribute("lista", editoraDao.buscaTodos());
			
			view.forward(request, response);

		//Mensagem no Browser
		response.getWriter().print("Salvo com Sucesso");
	}
}
