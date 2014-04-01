<%@ page language="java" contentType="text/html charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/resources/header-and-footer/header.jsp" %>

<div align="center">
	<table class="tabela-msg">
		<tr>
			<th>ID</th>
			<th>Data</th>
			<th>Remetente</th>
			<th>Email</th>
			<th>Mensagem</th>
		</tr>
		<c:forEach items="${listaMensagens}" var="msg">
			<tr id="registro">
				<td id="td-id">${msg.id}</td>
				<td>${msg.data}</td>
				<td>${msg.remetente}</td>
				<td><a href="mailto:${msg.email}">${msg.email}</a></td>
				<td>${msg.mensagem}</td>
				<td id="td-remover"><a class="link-excluir-msg" href="">Remover</a></td>
			</tr>
		</c:forEach>
	</table>
</div>


<script src="resources/js/jquery-2.1.0.min.js"></script>
<script src="resources/js/usuario.js"></script>

<%@ include file="/resources/header-and-footer/footer.jsp" %>

