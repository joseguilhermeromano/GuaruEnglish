<%-- 
    Document   : listTurma
    Created on : 01/07/2016, 18:27:50
    Author     : Luiz Felipe
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="/templates/header.jsp"/>
    <body>
        <jsp:include page="/templates/nav_secretaria.jsp"></jsp:include>
        <div class="container">    
            <form action="Executa" method="post" class="form-inline">
                <label class="control-label">Código da Turma:</label> 
                <input class="form-control" type="text" name="idTurma">
                <button class="btn btn-default" type="submit">Buscar</button>
                <input type="hidden" name="tarefa" value="TurmaServlet">
                <input type="hidden" name="metodo" value="view">
            </form>
            
            <h1 class="page-header">Turmas:</h1>
            
            <c:if test="${empty turmas}">
                <p class="alert alert-info">Não há turmas Cadastradas</p>
            </c:if>
            <c:if test="${not empty turmas}">
                <table class="table">
                    <tr>
                        <th class="text-center">Código</th>
                        <th class="text-center">Curso</th>
                        <th class="text-center">Módulo</th>
                        <th class="text-center">Data de Inicio</th>
                        <th class="text-center">Data de termino</th>
                        <th class="text-center">Período</th>
                        <th class="text-center">Ação</th>
                    </tr>

                    <c:forEach var="turma" items="${turmas}">
                        <tr class="text-center">
                            <td>${turma.id}</td>
                            <td>${turma.modulo.curso.descricao}</td>
                            <td>${turma.modulo.descricao}</td>  
                            <td><fmt:formatDate pattern="dd/MM/yyyy" value="${turma.dataInicio}"/></td>
                            <td><fmt:formatDate pattern="dd/MM/yyyy" value="${turma.dataFim}"/></td>
                            <td>${turma.periodo}</td>
                            <td>
                                <button type="submit" class="btn btn-info" 
                                        name="idTurma" value="${turma.id}" form="detalhesTurma">
                                    Detalhes
                                </button>
                            </tr>
                    </c:forEach>
                </table>
                <form id="detalhesTurma" action="Executa" method="post">
                    <input type="hidden" name="tarefa" value="TurmaServlet">
                    <input type="hidden" name="metodo" value="view">
                </form>
            </c:if>
                
        </div>    
    </body>
</html>
