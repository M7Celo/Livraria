<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Login</title>
	</head>
	
	<body>
		<h2>Login</h2>
		<form action="LoginControl" method="post">
			<label>Login:</label>
			<input type="text" id="loginUsuario" name="loginUsuario">
			<br/>
			<label>Senha:</label>
			<input type="password" id="senhaUsuario" name="senhaUsuario">
			<br/>
			<input type="submit" value="Entrar"/>
		</form>
	</body>
	
</html>