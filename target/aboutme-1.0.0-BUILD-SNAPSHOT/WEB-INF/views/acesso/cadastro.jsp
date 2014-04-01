<%@ page language="java" contentType="text/html charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/resources/header-and-footer/header.jsp" %>

<h1>Cadastre-se</h1>
<div class="div-info div-lado-a-lado">
	<table>
		<tr>
			<td>Email:</td>
			<td><input class="input-text" id="email" type="text" name="email" /></td>
		</tr>
		<tr>
			<td>Senha:</td>
			<td><input class="input-text" id="senha" type="password" name="senha" /></td>
		</tr>
		<tr>
			<td>Confirmar:</td>
			<td><input class="input-text" id="confirmacao" type="password" name="confirmacao" /></td>
		</tr>
		<tr>
			<td></td>
			<td colspan="2"><input id="btn_cadastrar_usuario" class="botao-ok" type="submit" value="Cadastrar" onclick="cadastrar()" /></td>
		</tr>
	</table>
</div>
<div id="div-msgs" class="div-lado-a-lado">
	<ul id="mensagem">
		
	</ul>
</div>

<script src="resources/js/jquery-2.1.0.min.js"></script>
<script src="resources/js/acesso.js"></script>

<%@ include file="/resources/header-and-footer/footer.jsp" %>