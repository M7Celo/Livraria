<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="br.com.livraria.model.dao.LivroDao"%>
<%@page import="br.com.livraria.model.dao.ClienteDao"%>
<%@page import="br.com.livraria.model.dao.LocacaoDao"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registro de Locações</title>
</head>
<body>
<%
	//Criando um ClienteDao
	ClienteDao clienteDao = new ClienteDao();
	
	// Criando um LivroDao
	LivroDao livroDao = new LivroDao();
	
	// Para carregar ista de Cliente do banco 
	request.setAttribute("listaCliente", clienteDao.buscaTodos());

	
	// Para carregar ista de Livro do banco 
	request.setAttribute("listaLivro", livroDao.buscaTodos());

	//Criando um LocacaoDao
	LocacaoDao locacaoDao = new LocacaoDao();

	request.setAttribute("lista", locacaoDao.buscaTodos());
%>
	<h2>Registro de Locações</h2>
	<a href="menu.jsp">Menu</a>
	<form action="LocacaoControl" method="post">
		<fieldset>
			<legend>
				<h2>Registro de Locações</h2>
			</legend>
			<table>
				<tr>
					<td>Id:</td>
					<td><input type="text" id="locacaoLivroId"
						name="txtlocacaoLivroId" value="" disabled /></td>
				</tr>

				<tr>
					<td>Cliente:</td>
					<td><select id="nomeCliente" name="cbnomeCliente">
							<c:forEach items="${listaCliente}" var="cliente">
								<option value="${cliente.nomeCliente}">${cliente.nomeCliente}</option>
							</c:forEach>
					</select></td>
				</tr>

				<tr>
					<td>Livro:</td>
					<td><select id="tituloLivro" name="cbtituloLivro">
							<c:forEach items="${listaLivro}" var="livro">
								<option value="${livro.tituloLivro}">${livro.tituloLivro}</option>
							</c:forEach>
					</select></td>
				</tr>

				<tr>
					<td>Data de Locação:</td>
					<td><input id="dataLoca" name="dtLocaLivro" type="date"
						required /></td>
				</tr>

				<tr>
					<td>Data de Devolução:</td>
					<td><input id="dataDevol" name="dtDevLivro" type="date"
						required /></td>
				</tr>

				<tr>
					<td>Quantidade:</td>
					<td><input type="text" id="qtdLivro" name="txtqtdLivro"
						value="" /></td>
				</tr>

			</table>
			<input type="submit" id="btSalvar" value="Salvar" />
		</fieldset>
	</form>
	<br />
	<fieldset>
		<legend>
			<h2>Registro de Locações</h2>
		</legend>
		<table border="2">
			<tr>
				<th>Id</th>
				<th>Cliente</th>
				<th>Livro</th>
				<th>Data de Locação</th>
				<th>Data de Devolução</th>
				<th>Quantidade</th>
			</tr>
			<c:forEach items="${lista}" var="locacao">
				<tr>
					<td style="width: 50px"><c:out
							value="${locacao.locacaoLivroId}"></c:out></td>
					<td style="width: 50px"><c:out value="${locacao.nomeCliente}"></c:out></td>
					<td style="width: 50px"><c:out value="${locacao.tituloLivro}"></c:out></td>
					<td style="width: 50px"><c:out
							value="${locacao.dataLocacaoLivro}"></c:out></td>
					<td style="width: 50px"><c:out
							value="${locacao.dataDevolucaoLivro}"></c:out></td>
					<td style="width: 50px"><c:out value="${locacao.qtdLivro}"></c:out></td>
					<td><a
						href="LocacaoControl?acao=apagar&locacao=${locacao.locacaoLivroId}">Excluir</a></td>
					<td><a
						href="LocacaoControl?acao=editar&locacao=${locacao.locacaoLivroId}">Editar</a></td>
				</tr>
			</c:forEach>
		</table>
	</fieldset>
</body>
</html>