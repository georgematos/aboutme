<%@ page language="java" contentType="text/html charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@ include file="/resources/header-and-footer/header.jsp" %> --%>
<head>
	<title>Bem Vindo</title>
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
	    		<div class="div-inner-content-home div-lado-a-lado" align="center">
	    			<div class="div-inner-root">
			    		<div><a href="${contextPath}/cadastro">Cadastre-se</a></div>
					</div>
	    		</div>
	    		<div class="div-inner-content-home div-lado-a-lado" align="center">
					<div class="div-inner-root">
						<div><a href="${contextPath}/login">Login</a></div>
					</div>
	    		</div>
	    	</div>
		
		<script src="resources/js/jquery-2.1.0.min.js"></script>
		<script src="resources/js/acesso.js"></script>

<%@ include file="/resources/header-and-footer/footer.jsp" %>