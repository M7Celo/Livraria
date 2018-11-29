<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="br.com.livraria.model.dao.LivroDao" %>
<%@page import="br.com.livraria.model.dao.AutorDao" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Autor</title>
</head>
<body>
<%
	//Criando um LivroDao
	LivroDao livroDao = new LivroDao();

	request.setAttribute("listaLivro", livroDao.buscaTodos());

	//Criando um AutorDao
	AutorDao autorDao = new AutorDao();

	request.setAttribute("lista", autorDao.buscaTodos());

%>
	<h2>Cadastro de Autor</h2>
	<a href="menu.jsp">Menu</a>
	<form action="AutorControl" method="post">
		<fieldset>
			<legend>
				<h2>Cadastro de Autor</h2>
			</legend>
			<table>
				<tr>
					<td>Id:</td>
					<td><input type="text" id="autorId" name="txtautorId"
						value="${autor.autorId}" disabled></td>
				</tr>

				<tr>
					<td>Nome:</td>
					<td><input type="text" id="nomeAutor" name="txtnomeAutor"
						value="${autor.nomeAutor}" /></td>
				</tr>

				<tr>
					<td>Livro:</td>
					<td>
					<select id="nomeLivro" name="cbnomeLivro">
							<c:forEach items="${listaLivro}" var="livro">
								<option value="${livro.tituloLivro}">
									${livro.tituloLivro}</option>
							</c:forEach>
					</select>
					</td>
				</tr>
			</table>
			<input type="submit" id="btSalvar" value="Salvar" />
		</fieldset>
	</form>

	<br />
	<fieldset>
		<legend>
			<h2>Lista de Autores</h2>
		</legend>
		<table border="2">
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Livro</th>
			</tr>

			<c:forEach items="${lista}" var="autor">
				<tr>
					<td style="width: 50px"><c:out value="${autor.autorId}"></c:out></td>
					<td style="width: 50px"><c:out value="${autor.nomeAutor}"></c:out></td>
					<td style="width: 50px"><c:out value="${autor.nomeLivro}"></c:out></td>
					<td><a href="AutorControl?acao=apagar&autor=${autor.autorId}">Excluir</a></td>
					<td><a href="AutorControl?acao=editar&autor=${autor.autorId}">Editar</a></td>
				</tr>
			</c:forEach>
		</table>
	</fieldset>
</body>
</html>