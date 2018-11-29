<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="br.com.livraria.model.dao.EditoraDao"%>
<%@page import="br.com.livraria.model.dao.LivroDao"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Livro</title>
</head>
<body>
<%
	//Criando um EditoraDao
	EditoraDao editoraDao = new EditoraDao();

	request.setAttribute("listaEditora", editoraDao.buscaTodos());
	
	//Criando um LivroDao
	LivroDao livroDao = new LivroDao();

	request.setAttribute("lista", livroDao.buscaTodos());
%>
	<h2>Cadastro de Livro</h2>
	<a href="menu.jsp">Menu</a>
	<form action="LivroControl" method="post">
		<fieldset>
			<legend>
				<h2>Cadastro de Livro</h2>
			</legend>

			<table>
				<tr>
					<td>Id:</td>
					<td><input type="text" id="livroId" name="txtlivroId"
						value="${livro.livroId}" disabled/></td>
				</tr>

				<tr>
					<td>Título:</td>
					<td><input type="text" id="tituloLivro" name="txttituloLivro"
						value="${livro.tituloLivro}" /></td>
				</tr>

				<tr>
					<td>Ano:</td>
					<td><input type="text" id="anoLivro" name="txtanoLivro"
						value="${livro.anoLivro}" /></td>
				</tr>

				<tr>
					<td>Edição:</td>
					<td><input type="text" id="edicaoLivro" name="txtedicaoLivro"
						value="${livro.edicaoLivro}" /></td>
				</tr>

				<tr>
					<td>Editora:</td>
					<td>
					<select id="nomeEditora" name="cbnomeEditora">
							<c:forEach items="${listaEditora}" var="editora">
								<option value="${editora.nomeFantasiaEditora}">
									${editora.nomeFantasiaEditora}</option>
							</c:forEach>
					</select>
					</td>
				</tr>

				<tr>
					<td>ISBN nº:</td>
					<td><input type="text" id="isbnLivro" name="txtisbnLivro"
						value="${livro.isbnLivro}" /></td>
				</tr>

				<tr>
					<td>Categoria:</td>
					<td><select id="categLivro" name="cbcategLivro">
							<option value="OURO">OURO</option>
							<option value="PRATA">PRATA</option>
					</select></td>
				</tr>
			</table>
			<input type="submit" id="btSalvar" value="Salvar" />
		</fieldset>
	</form>

	<br />
	<fieldset>
		<legend>
			<h2>Lista de Livros</h2>
		</legend>
		<table border="2">
			<tr>
				<th>Id</th>
				<th>Título</th>
				<th>Ano</th>
				<th>Edição</th>
				<th>Editora</th>
				<th>ISBN</th>
				<th>Categoria</th>
			</tr>

			<c:forEach items="${lista}" var="livro">
				<tr>
				<td style="width: 50px"><c:out value="${livro.livroId}"/></td>
				<td style="width: 50px"><c:out value="${livro.tituloLivro}"/></td>
				<td style="width: 50px"><c:out value="${livro.anoLivro}"/></td>
				<td style="width: 50px"><c:out value="${livro.edicaoLivro}"/></td>
				<td style="width: 50px"><c:out value="${livro.editoraLivro}"/></td>
				<td style="width: 50px"><c:out value="${livro.isbnLivro}"/></td>
				<td style="width: 50px"><c:out value="${livro.categLivro}"/></td>
				<td><a href="LivroControl?acao=apagar&livro=${livro.livroId}">Excluir</a></td>
				<td><a href="LivroControl?acao=editar&livro=${livro.livroId}">Editar</a></td>
				</tr>
			</c:forEach>
		</table>
	</fieldset>
</body>
</html>