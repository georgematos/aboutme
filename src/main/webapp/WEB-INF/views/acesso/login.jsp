<%@ page language="java" contentType="text/html charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
	<title>Login</title>
	<link rel="stylesheet" href="resources/css/aboutme.css" />
	<link rel="stylesheet" href="resources/css/aboutme-print.css" media="print" />
</head>
<body>
	<!-- Cria uma variável com a url do contexto da página -->
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	
	<div class="container full-height">
		
		<div class="how-table">

		    <div class="header">
		       	<div id="div-meunome">
		       		Bem vindo ao AboutMe!
		       	</div>
			</div>
			
			<div class="content">

			<div>
				<h1>Logar</h1>
				<div class="div-info div-lado-a-lado">
					<form id="form-login" action="${pageContext.request.contextPath}/j_spring_security_check" method="post">
						<table>
							<tr>
								<td>Login(Email):</td>
								<td><input class="input-text" id="email" type="text" name="j_username" /></td>
							</tr>
							<tr>
								<td>Senha:</td>
								<td><input class="input-text" id="senha" type="password" name="j_password" /></td>
							</tr>
							<tr>
								<td></td>
								<td colspan="2"><input id="btn-cadastrar-usuario" class="botao-ok" type="submit" value="Entrar" /></td>
							</tr>
						</table>
					</form>
				</div>
				<c:if test="${param.status == 'erro'}">
					<div class="div-lado-a-lado div-error-caution">
						<ul>
							<li>
				    			Usuário e/ou senha inválidos!<br/>
								<%-- Causa do erro: ${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message} --%>
							</li>
						</ul>
					</div>
				</c:if>
			</div>

<script src="resources/js/jquery-2.1.0.min.js"></script>
<script src="resources/js/acesso.js"></script>

<%@ include file="/resources/header-and-footer/footer.jsp" %>