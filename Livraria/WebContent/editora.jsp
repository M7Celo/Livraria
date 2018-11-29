<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="br.com.livraria.model.dao.EditoraDao"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Editora</title>
</head>
<body>
<%
	//criando um EditoraDao
	EditoraDao editoraDao = new EditoraDao();

	request.setAttribute("lista", editoraDao.buscaTodos());
%>
	<h2>Cadastro de Editora</h2>
	<a href="menu.jsp">Menu</a>
	<form action="EditoraControl" method="post">
	<fieldset>
		<legend><h2>Cadastro de Editora</h2></legend>
		<table>
			<tr>
				<td>Id:</td>
				<td ><input type="text" id="editoraId" name="txteditoraId"
				value="${editora.editoraId}" disabled></td>
			</tr>
			
			<tr>
			<td>Nome Fantasia:</td>
				<td ><input type="text" id="nomeFantasia" name="txtnomeFantasia"
				value="${editora.nomeFantasiaEditora}"></td>
			</tr>
			
			<tr>
			<td>Razão Social:</td>
				<td ><input type="text" id="razaoSocial" name="txtrazaoSocial" 
				value="${editora.razaoSocialEditora}"></td>
			</tr>
			
			<tr>
			<td>CNPJ:</td>
				<td ><input type="text" id="cnpjEditora" name="txtcnpjEditora"
				placeholder="Ex.: 00.000.000/0000-00" value="${editora.cnpjEditora}"></td>
			</tr>
			
			<tr>
			<td>Inscrição Estadual:</td>
				<td ><input type="text" id="inscricaoEstEditora" name="txtinscricaoEstEditora"
				value="${editora.inscricaoEstadual}"></td>
			</tr>
			
			<tr>
			<td>Inscrição Municipal:</td>
				<td ><input type="text" id="inscricaoMunEditora" name="txtinscricaoMunEditora"
				value="${editora.inscricaoMunicipal}"></td>
			</tr>
			
			<tr>
			<td>Endereço:</td>
				<td ><input type="text" id="logradouroEditora" name="txtlogradouroEditora"
				value="${editora.logradouroEditora}"></td>
			</tr>
			
			<tr>
			<td>Nº:</td>
				<td ><input type="text" id="numEndEditora" name="txtnumEndEditora"
				value="${editora.numEnderecoEditora}"></td>
			</tr>
			
			<tr>
			<td>Bairro:</td>
				<td ><input type="text" id="bairroEditora" name="txtbairroEditora" 
				value="${editora.bairroEditora}"></td>
			</tr>
			
			<tr>
			<td>Cidade:</td>
				<td ><input type="text" id="cidadeEditora" name="txtcidadeEditora" 
				value="${editora.cidadeEditora}"></td>
			</tr>
			
			<tr>
			<td>UF:</td>
				<td >
				<select id="ufEditora" name="cbufEditora">
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
			<td>Cep:</td>
				<td ><input type="text" id="cepEditora" name="txtcepEditora"
				placeholder="Ex.: 00000-000" value="${editora.cepEditora}"></td>
			</tr>
			
			
			<tr>
			<td>Complemento:</td>
				<td ><input type="text" id="compEndEditora" name="txtcompEndEditora" 
				value="${editora.complementoEnderecoEditora}"></td>
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
				<td ><input type="text" id="telefoneContatoEditora" name="txttelefoneContatoEditora"
					placeholder="Ex.: (00) 0 0000-0000" value="${editora.telefoneContatoEditora}"></td>
			</tr>
			
			<tr>
			<td>Contato:</td>
				<td ><input type="text" id="contatoPessoaEditora" name="txtcontatoPessoaEditora" 
				value="${editora.contatoPessoaEditora}"></td>
			</tr>
			
			<tr>
			<td>Email:</td>
				<td ><input type="text" id="emailEditora" name="txtemailEditora"
					placeholder="Ex.: email@dominio.com.br" value="${editora.emailEditora}"></td>
			</tr>
			
		</table>
		<input type="submit" id="btSalvar" value="Salvar" />
		</fieldset>
	</form>
	<br />
	
	<fieldset>
		<legend><h2>Lista de Editoras</h2></legend>
			<table border="2">
			<tr>
				<th>Id</th>
				<th>Nome Fantasia</th>
				<th>Razão Social</th>
				<th>CNPJ</th>
				<th>Inscrição Estadual</th>
				<th>Inscrição Municipal</th>
				<th>Endereço</th>
				<th>Nº</th>
				<th>Bairro</th>
				<th>Cidade</th>
				<th>UF</th>
				<th>CEP</th>
				<th>Complemento</th>
				<th>Tipo Telefone</th>
				<th>Telefone</th>
				<th>Contato</th>
				<th>Email</th>			
			</tr>
		
			<c:forEach items="${lista}" var="editora">
				<tr>
				<td style="width: 50px"><c:out value="${editora.editoraId}"></c:out></td>
				<td style="width: 50px"><c:out value="${editora.nomeFantasiaEditora}"></c:out></td>
				<td style="width: 50px"><c:out value="${editora.razaoSocialEditora}"></c:out></td>
				<td style="width: 50px"><c:out value="${editora.cnpjEditora}"></c:out></td>
				<td style="width: 50px"><c:out value="${editora.inscricaoEstadual}"></c:out></td>
				<td style="width: 50px"><c:out value="${editora.inscricaoMunicipal}"></c:out></td>
				<td style="width: 50px"><c:out value="${editora.logradouroEditora}"></c:out></td>
				<td style="width: 50px"><c:out value="${editora.numEnderecoEditora}"></c:out></td>
				<td style="width: 50px"><c:out value="${editora.bairroEditora}"></c:out></td>
				<td style="width: 50px"><c:out value="${editora.cidadeEditora}"></c:out></td>
				<td style="width: 50px"><c:out value="${editora.ufEditora}"></c:out></td>
				<td style="width: 50px"><c:out value="${editora.cepEditora}"></c:out></td>
				<td style="width: 50px"><c:out value="${editora.complementoEnderecoEditora}"></c:out></td>
				<td style="width: 50px"><c:out value="${editora.tipoTelefoneEditora}"></c:out></td>
				<td style="width: 50px"><c:out value="${editora.telefoneContatoEditora}"></c:out></td>
				<td style="width: 50px"><c:out value="${editora.contatoPessoaEditora}"></c:out></td>
				<td style="width: 50px"><c:out value="${editora.emailEditora}"></c:out></td>
				<td><a href="EditoraControl?acao=apagar&editora=${editora.editoraId}">Excluir</a></td>
				<td><a href="EditoraControl?acao=editar&editora=${editora.editoraId}">Editar</a></td>
				</tr>
			</c:forEach>
			</table>
	</fieldset>
</body>
</html>