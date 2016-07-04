<%-- 
    Document   : turma
    Created on : 01/07/2016, 13:24:47
    Author     : Luiz Felipe
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="/templates/header.jsp"/>
    <body>
        <jsp:include page="/templates/nav_secretaria.jsp"></jsp:include>
        <div class="container">
            <h1 class="page-header">Turma:</h1>
            <p class="container"> 
                <br><b>Curso:</b> ${turma.modulo.curso.descricao}
                <br><b>Módulo:</b> ${turma.modulo.descricao}
                <br><b>Nível:</b>  
                <c:if test="${turma.modulo.nivel eq 1}">Básico</c:if>
                <c:if test="${turma.modulo.nivel eq 2}">Médio</c:if>
                <c:if test="${turma.modulo.nivel eq 3}">Avançado</c:if>
                <br><b>Professor responsavel:</b> ${turma.professor.nome} 
                <c:if test="${empty turma.professor}">
                    <span class="text-warning">Você precisa definir um professor para essa turma</span>
                </c:if>
                <br><b>Data de Inicio:</b>  <fmt:formatDate pattern="dd/MM/yyyy" value="${turma.dataInicio}"/>
                <br><b>Data de Conclusão:</b> <fmt:formatDate pattern="dd/MM/yyyy" value="${turma.dataFim}"/>
            </p>
            <br/>
            <div class="btn-toolbar center-block">
                <button type="submit" form="formAlterarTurma" class="btn btn-primary">
                    Alterar Turma
                </button>
                <button class="btn btn-primary" type="submit" form="definirProfessor">
                    Definir/Alterar Professor
                </button>
            </div>
            <form action="Executa" method="post" id="formAlterarTurma">
                <input type="hidden" name="tarefa" value="TurmaServlet">
                <input type="hidden" name="metodo" value="editar"> 
                <input type="hidden" name="idTurma" value="${turma.id}">
            </form>
            
            <form action="Executa" method="post" id="definirProfessor">
                <input type="hidden" name="tarefa" value="TurmaServlet">
                <input type="hidden" name="metodo" value="definirProfessorParaTurma">
                <input type="hidden" name="idTurma" value="${turma.id}">
            </form>
            
            
        </div>
    </body>
</html>
