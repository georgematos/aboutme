<%@ page language="java" contentType="text/html charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ include file="/resources/header-and-footer/header.jsp" %>
       
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

<script src="resources/js/jquery-2.1.0.min.js"></script>
<script src="resources/js/usuario.js"></script>

<%@ include file="/resources/header-and-footer/footer.jsp" %>	

