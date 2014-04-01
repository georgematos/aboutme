<%@ page language="java" contentType="text/html charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

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

		    <div class="header-publico">
		       	<div id="div-meunome">
		       		<a id="titulo-nome">
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
		    </div>

		</div>
	
    	<div class="content inner-shadow">
       
			<div class="div-info">
			    <p><c:if test="${not empty usuario.telefone}">Telefone: ${usuario.telefone} <br /></c:if>
			    <c:if test="${not empty usuario.celular}">Celular: ${usuario.celular} <br /></c:if>
			    E-mail: <a href="mailto:${usuario.email}">${usuario.email}</a></p>
			</div>
			<br />
			
			<div class="div-info">
			    <h3>Objetivo Profissional</h3>
			    <ul>
			<%--         <li>${objPro}</li> --%>
			        <li>${usuario.curriculo[0].objProfissional}</li>
			    </ul>
			    </div>
			<br />
			
			<div class="div-info">
			    <h3>Formação Acadêmica</h3>
			    
			    <c:forEach items="${usuario.curriculo[0].formacaoAcademica}" var="f">
				   	<ul>
				        <li>${f.instituicao}
					        <ul>
					            <li><i>${f.curso}</i></li>
					        </ul>
				        </li>
				    </ul>
			    </c:forEach>
			
			</div>
			<br />
			    
			<div class="div-info">
			    <h3>Qualificações</h3>
			
			    <ul>
			        <li>
						${usuario.curriculo[0].qualificacoes}
			        </li>
			    </ul>
			</div>
			<br />
			
			<div class="div-info">
			    <h3>Cursos <span style="font-size: small">(clique sobre o curso para exibir o certificado)</span></h3>
			
			    <ul>
			        <c:forEach items="${usuario.curriculo[0].cursoLivre}" var="curso">
			        	<li><a href="${curso.link}" target="_blank">${curso.titulo} - ${curso.instituicao}</a></li>
			        </c:forEach>
			    </ul>
			    
			</div>
			<br />
			
			<div class="how-table dont-print">
				<div class="div-info div-lado-a-lado">
					<h3>Fale Comigo</h3>
					<br />
					<input type="hidden" id="user_id" name="user_id" value="${usuario.id}" />
					<table class="tabela">
						<tr>
							<td>Nome:</td>
							<td>
								<input id="remetente" class="input-text" type="text" name="remetente" />
							</td>
						</tr>
						<tr>
							<td>Email:</td>
							<td>
								<input id="email" class="input-text" type="text" name="email" />
							</td>
						</tr>
						<tr>
							<td></td>
							<td colspan="2">
								<textarea id="msg" class="input-textarea"  rows="10" cols="50"  name="mensagem"></textarea>
							</td>
						</tr>
						<tr>
							<td></td>
							<td><input id="btn_enviar_msg" class="botao-ok" type="submit" value="Enviar"  onclick="enviar()"/></td>
						</tr>
					</table>
					
				</div>
				<div id="div-msgs" class="div-info div-lado-a-lado">
					<ul id="mensagem">
						
					</ul>
				</div>
			</div>   

<script src="resources/js/jquery-2.1.0.min.js"></script>
<script src="resources/js/usuario.js"></script>

<%@ include file="/resources/header-and-footer/footer.jsp" %>	

