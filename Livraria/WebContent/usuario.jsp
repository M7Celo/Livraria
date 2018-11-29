<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="br.com.livraria.model.dao.UsuarioDao"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Usuário</title>
</head>

<body>
<%
	//criando um UsuarioDao
	UsuarioDao usuarioDao = new UsuarioDao();

	request.setAttribute("lista", usuarioDao.buscaTodos());
%>
	<h2>Cadastro de Usuário</h2>
	<a href="menu.jsp">Menu</a>
	<form action="UsuarioControl" method="post">
	<fieldset >
		<legend><h2>Cadastro de Usuário</h2></legend>
		<table>
			<tr>
				<td>Id:</td>
				<td><input type="text" id="usuarioId" name="txtusuarioId"
					value="${usuario.usuarioId}" disabled></td>
			</tr>

			<tr>
				<td>Nome:</td>
				<td><input type="text" id="nomeUsuario" name="txtnomeUsuario"
					value="${usuario.nomeUsuario}"></td>
			</tr>

			<tr>
				<td>Login:</td>
				<td><input type="text" id="loginUsuario" name="txtloginUsuario"
					value="${usuario.loginUsuario}"></td>
			</tr>

			<tr>
				<td>Senha:</td>
				<td><input type="password" id="senhaUsuario"
					name="pwsenhaUsuario" value="${usuario.senhaUsuario}"></td>
			</tr>

		</table>		
		<input type="submit" id="btSalvar" value="Salvar" />
		</fieldset>
	</form>
	<br />
	
	<fieldset>
	<legend><h2>Lista de Usuário</h2></legend>
	<table border="2">
		<tr>
			<th>Id</th>
			<th>Nome</th>
			<th>Login</th>
			<th>Senha</th>
		</tr>

		<c:forEach items="${lista}" var="usuario">

			<tr>
				<td style="width: 50px"><c:out value="${usuario.usuarioId}"></c:out></td>
				<td style="width: 50px"><c:out value="${usuario.nomeUsuario}"></c:out></td>
				<td style="width: 50px"><c:out value="${usuario.loginUsuario}"></c:out></td>
				<td style="width: 50px"><c:out value="${usuario.senhaUsuario}"></c:out></td>
				<td><a href="UsuarioControl?acao=apagar&usuario=${usuario.usuarioId}">Excluir</a></td>
				<td><a href="UsuarioControl?acao=editar&usuario=${usuario.usuarioId}">Editar</a></td>
			</tr>
		</c:forEach>

	</table>
	</fieldset>
</body>

</html>