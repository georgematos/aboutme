<%@ page language="java" contentType="text/html charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/resources/header-and-footer/header.jsp" %>

<div>
	<div>
		<form action="atualizarCurriculo" method="post">
			<h3>Informações Pessoais:</h3> <br />
			<input type="hidden" id="usuario-id" value="${usuario.id}" />
			<table class="tabela-msg">
				<tr>
					<td>Nome:</td>
					<td><input name="nome" class="input-text" type="text" value="${usuario.nome}" /></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><input name="email" class="input-text" type="text" value="${usuario.email}" /></td>
				</tr>
				<tr>
					<td>Telefone:</td>
					<td><input name="telefone" class="input-text" type="tel" value="${usuario.telefone}" /></td>
				</tr>
				<tr>
					<td>Celular:</td>
					<td><input name="celular" class="input-text" type="tel" value="${usuario.celular}" /></td>
				</tr>
				<tr>
					<td>Objetivo Profissional:</td>
					<td><input name="objProfissional" class="input-text" type="text" value="${usuario.curriculo[0].objProfissional}" /></td>
				</tr>
			</table>
			<br />
			
			<h3>Formação Academica:</h3> <br />
			<table class="tabela-edit-curriculo">
				<tr>
					<th>Instituição</th>
					<th>Curso</th>
				</tr>
				<c:forEach items="${usuario.curriculo[0].formacaoAcademica}" var="formacao">
					<tr>				
						<td class="id-formacao" hidden="true">${formacao.id}</td>
						<td class="td-background"><input class="formacao-instituicao-up input-text" type="text" value="${formacao.instituicao}" /></td>
						<td class="td-background"><input class="formacao-curso-up input-text" type="text" value="${formacao.curso}" /></td>
						<td id="td-atualizar"><a class="link-atualizar-formacao" href="">Atualizar</a></td>
						<td id="td-remover"><a class="link-excluir-formacao" href="">Remover</a></td>
					</tr>
				</c:forEach>
				<tr>
					<td><input id="formacao-instituicao" class="input-text" type="text" /></td>
					<td><input id="formacao-curso" class="input-text" type="text" /></td>
					<td id="td-adicionar"><a class="link-add-formacao" href="">Adicionar</a></td>
				</tr>
			</table>
			<br />
			
			<h3>Cursos:</h3> <br />
			<table class="tabela-edit-curriculo">
				<tr>
					<th>Titulo</th>
					<th>Instituição</th>
				</tr>
				<c:forEach items="${usuario.curriculo[0].cursoLivre}" var="curso">
					<tr>
						<td class="id-curso" hidden="true">${curso.id}</td>
						<td class="td-background"><input class="curso-titulo-up input-text" type="text" value="${curso.titulo}" /></td>
						<td class="td-background"><input class="curso-instituicao-up input-text" type="text" value="${curso.instituicao}" /></td>
						<td id="td-atualizar"><a class="link-atualizar-curso" href="">Atualizar</a></td>
						<td id="td-remover"><a class="link-excluir-curso" href="">Remover</a></td>
					</tr>
				</c:forEach>
				<tr>
					<td><input id="curso-titulo" class="input-text" type="text" /></td>
					<td><input id="curso-instituicao" class="input-text" type="text" /></td>
					<td id="td-adicionar"><a class="link-add-curso" href="">Adicionar</a></td>
				</tr>
			</table>			
			<br />		
				
			<h3>Qualificações:</h3> <br />
			<c:choose>
				<c:when test="${ not empty usuario.curriculo[0].qualificacoes }">
					<textarea name="qualificacoes" class="input-text" rows="10" cols="30">${usuario.curriculo[0].qualificacoes}</textarea> <br />
				</c:when>
				<c:otherwise>
					<textarea name="qualificacoes" class="input-text" rows="10" cols="30"></textarea> <br />
				</c:otherwise>
			</c:choose>
			<input type="submit" value="Salvar" />
			
		</form>
	</div>
</div>

<script src="resources/js/jquery-2.1.0.min.js"></script>
<script src="resources/js/usuario.js"></script>

<%@ include file="/resources/header-and-footer/footer.jsp" %>