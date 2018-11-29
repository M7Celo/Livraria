<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="br.com.livraria.model.dao.ClienteDao"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Cliente</title>
</head>
<body>
<%
	//Criando um ClienteDao
	ClienteDao clienteDao = new ClienteDao();

	request.setAttribute("lista", clienteDao.buscaTodos());
%>
	<h2>Cadastro de Cliente<h2>
	<a href="menu.jsp">Menu</a>
	<form action="ClienteControl" method="post">
	<fieldset>
		<legend><h2>Cadastro de Cliente</h2></legend>
		<table>
			<tr>
			<td>Id:</td>
			<td><input type="text" id="clienteId" name="txtclienteId"
			value="${cliente.clienteId}"disabled/></td>
			</tr>
			
			<tr>
			<td>Nome:</td>
			<td><input type="text" id="nomecliente" name="txtnomecliente" 
			value="${cliente.nomeCliente}"/></td>
			</tr>
			
			<tr>
			<td>RG:</td>
			<td><input type="text" id="rgCliente" name="txtrgCliente" 
			value="${cliente.rgCliente}"/></td>
			</tr>
			
			<tr>
			<td>CPF:</td>
			<td><input type="text" id="cpfCliente" name="txtcpfCliente" 
			value="${cliente.cpfCliente}"/></td>
			</tr>
			
			<tr>
			<td>Data de Nascimento:</td>
			<td><input id="dataNasc" name="dtNascCliente" type="date" 
			required/>
			</td>
			</tr>
			
			<tr>
			<td>Endereço:</td>
			<td><input type="text" id="enderecoCliente" name="txtenderecoCliente" 
			value="${cliente.enderecoCliente}"/></td>
			</tr>
			
			<tr>
			<td>Nº:</td>
			<td><input type="text" id="numEndCliente" name="txtnumEndCliente" 
			value="${cliente.numeroEnderecoCliente}"/></td>
			</tr>
			
			<tr>
			<td>Complemento:</td>
			<td><input type="text" id="compEndCliente" name="txtcompEndCliente" 
			value="${cliente.complementoCliente}"/></td>
			</tr>
			
			<tr>
			<td>Bairro:</td>
			<td><input type="text" id="bairroCliente" name="txtbairroCliente" 
			value="${cliente.bairroCliente}"/></td>
			</tr>
			
			<tr>
			<td>Cidade:</td>
			<td><input type="text" id="cidadeCliente" name="txtcidadeCliente" 
			value="${cliente.cidadeCliente}"/></td>
			
			<tr>
			<td>UF:</td>
				<td >
				<select id="ufCliente" name="cbufCliente">
				<option value="AC">AC</option>
				<option value="AL">AL</option>
				<option value="AM">AM</option>
				<option value="AP">AP</option>
				<option value="BA">BA</option>
				<option value="CE">CE</option>
				<option value="DF">DF</option>
				<option value="ES">ES</option>
				<option value="GO">GO</option>
				<option value="MA">MA</option>
				<option value="MG">MG</option>
				<option value="MS">MS</option>
				<option value="MT">MT</option>
				<option value="PA">PA</option>
				<option value="PB">PB</option>
				<option value="PE">PE</option>
				<option value="PI">PI</option>
				<option value="PR">PR</option>
				<option value="RJ">RJ</option>
				<option value="RN">RN</option>
				<option value="RO">RO</option>
				<option value="RR">RR</option>
				<option value="RS">RS</option>
				<option value="SC">SC</option>
				<option value="SE">SE</option>
				<option value="SP">SP</option>
				<option value="TO">TO</option>
				</select>
				</td>
			</tr>
			
			<tr>
			<td>CEP:</td>
			<td><input type="text" id="cepCliente" name="txtcepCliente" 
			value="${cliente.cepCliente}"/></td>
			</tr>
			
			<tr>
			<td>Tipo de Telefone:</td>
				<td >
				<select size="1" id="tipoTelefone" name="cbtipoTelefone">
				<option value="CELULAR">CELULAR</option>
				<option value="COMERCIAL">COMERCIAL</option>
				<option value="PRINCIPAL">PRINCIPAL</option>
				<option value="RECADO">RECADO</option>
				<option value="RESIDENCIAL">RESIDENCIAL</option>
				</select>
				</td>
			</tr>
			
			<tr>
			<td>Telefone:</td>
			<td><input type="text" id="telCliente" name="txttelCliente" 
			value="${cliente.telefoneCliente}"/></td>
			</tr>
			
			<tr>
			<td>E-mail:</td>
			<td><input type="text" id="emailCliente" name="txtemailCliente" 
			value="${cliente.emailCliente}"/></td>
			</tr>
			
			</table>		
		<input type="submit" id="btSalvar" value="Salvar" />
		</fieldset>
	</form>
	
	<br />
	<fieldset>
	<legend><h2>Lista de Clientes</h2></legend>
	<table border="2">
		<tr>
			<th>Id</th>
			<th>Nome</th>
			<th>RG</th>
			<th>CPF</th>
			<th>Data de Nascimento</th>
			<th>Endereço</th>
			<th>Nº</th>
			<th>Complemento</th>
			<th>Bairro</th>
			<th>Cidade</th>
			<th>UF</th>
			<th>CEP</th>
			<th>Tipo de Telefone</th>
			<th>Telefone</th>
			<th>E-mail</th>
		</tr>
		
		<c:forEach items="${lista}" var="cliente">
			<tr>
				<td style="width: 50px"><c:out value="${cliente.clienteId}"></c:out></td>
				<td style="width: 50px"><c:out value="${cliente.nomeCliente}"></c:out></td>
				<td style="width: 50px"><c:out value="${cliente.rgCliente}"></c:out></td>
				<td style="width: 50px"><c:out value="${cliente.cpfCliente}"></c:out></td>
				<td style="width: 50px"><c:out value="${cliente.dataNascimentoCliente}"></c:out></td>
				<td style="width: 50px"><c:out value="${cliente.enderecoCliente}"></c:out></td>
				<td style="width: 50px"><c:out value="${cliente.numeroEnderecoCliente}"></c:out></td>
				<td style="width: 50px"><c:out value="${cliente.complementoCliente}"></c:out></td>
				<td style="width: 50px"><c:out value="${cliente.bairroCliente}"></c:out></td>
				<td style="width: 50px"><c:out value="${cliente.cidadeCliente}"></c:out></td>
				<td style="width: 50px"><c:out value="${cliente.ufCliente}"></c:out></td>
				<td style="width: 50px"><c:out value="${cliente.cepCliente}"></c:out></td>
				<td style="width: 50px"><c:out value="${cliente.tipoTelefoneCliente}"></c:out></td>
				<td style="width: 50px"><c:out value="${cliente.telefoneCliente}"></c:out></td>
				<td style="width: 50px"><c:out value="${cliente.emailCliente}"></c:out></td>
				<td><a href="ClienteControl?acao=apagar&cliente=${cliente.clienteId}">Excluir</a></td>
				<td><a href="ClienteControl?acao=editar&cliente=${cliente.clienteId}">Editar</a></td>
			</tr>
		</c:forEach>
	</table>
	</fieldset>	
</body>
</html>