<%@ page language="java" contentType="text/html charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>AboutMe</title>
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
		       		<a id="titulo-nome" href="${contextPath}/curriculo">
		       			<c:choose>
		       				<c:when test="${not empty sessionScope.nome}">
		       					${sessionScope.nome}
		       				</c:when> 
		       				<c:otherwise>
		       					Bem Vindo!
		       				</c:otherwise>
		       				
		       			</c:choose>
		       		</a>
		       	</div>
		    	<div class="menubar dont-print">
				   	<div class="div-lado-a-lado">
						<img class="img-back" src="resources/icons/facebook-64.png" id="botao-face" />
			     	</div>
			     	<div class="div-lado-a-lado">
						<img class="img-back" src="resources/icons/github-64.png" id="botao-git" />
			     	</div>
			     	<div class="div-lado-a-lado">
			        	<img class="img-back" src="resources/icons/googleplus-64.png" id="botao-gplus"/>
			     	</div>
			     	<div class="div-lado-a-lado">
			        	<img class="img-back" src="resources/icons/linkedin-64.png" id="botao-ldin" />
			     	</div>
		    	</div>
		   
		    	<div class="menubar dont-print">
		        	<div class="div-lado-a-lado">
		            	<a href="http://facebook.com/faceDoGeorge" target="_blank">
		                	<img class="img-front" src="resources/icons/facebook-64-black.png" />
		            	</a>
		        	</div>
			        <div class="div-lado-a-lado">
			            <a href="https://github.com/georgematos" target="_blank">
			                <img class="img-front" src="resources/icons/github-64-black.png" />
			            </a>
			        </div>
			        <div class="div-lado-a-lado">
			            <a href="https://plus.google.com/u/0/+GeorgeMatos/posts" target="_blank">
			                <img class="img-front" src="resources/icons/googleplus-64-black.png" />
			            </a>
			        </div>
			        <div class="div-lado-a-lado">
			            <a href="http://www.linkedin.com/pub/george-matos/36/496/264" target="_blank">
			                <img class="img-front" src="resources/icons/linkedin-64-black.png" />
			            </a>
			        </div>
		    	</div>
		    	
		    	<div class="div-nav-menu how-table dont-print" align="center">
		    		<nav>
					  	<ul class="menu">
					        <li><a href="${contextPath}/curriculo">Currículo</a></li>
					        <li><a href="${contextPath}/mensagens">Mensagens</a></li>
					        <li><a href="${contextPath}/edicao-curriculo">Editar</a></li>
				            <li><a href="">Tecnologias</a>
				            	<ul class="shadow">
			                      <li><a href="http://docs.oracle.com/javase/" target="_blank">Java SE 7</a></li>
			                      <li><a href="http://projects.spring.io/spring-framework/" target="_blank">Spring Web MVC</a></li>
			                      <li><a href="http://projects.spring.io/spring-security/" target="_blank">Spring Security</a></li>                
			                      <li><a href="http://www.oracle.com/technetwork/java/javaee/tech/persistence-jsp-140049.html" target="_blank">JPA 2.1</a></li>                
			                      <li><a href="http://hibernate.org/" target="_blank">Hibernate</a></li>
			                      <li><a href="http://www.w3schools.com/html/html5_intro.asp" target="_blank">HTML5</a></li>
			                      <li><a href="http://www.w3schools.com/css/css3_intro.asp" target="_blank">CSS3</a></li>
			                      <li><a href="http://jquery.com/" target="_blank">jQuery</a></li>
				                </ul>
				            </li>
							<!-- Verifica se exite um contexto de sessão, ou seja, se há alguém logado. -->
				            <c:if test="${not empty sessionScope.SPRING_SECURITY_CONTEXT}">
						        <li><a href="#">Mais</a>
						        	<ul class="shadow">
						        		<li>							        		
<!-- 										    <div align="center"> -->
												<div class="div-menu-suspenso">
										    		<a href="${contextPath}/j_spring_security_logout">Logout</a>
										    	</div>
<!-- 										    </div> -->
						        		</li>
						        	</ul>
				       			</li>
							</c:if>
						</ul>
					</nav>
		  		</div>
		    </div>

		</div>
	

    	<div class="content inner-shadow">
		