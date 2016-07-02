<%-- 
    Document   : turmaSemProfessor
    Created on : 30/06/2016, 22:59:58
    Author     : Luiz Felipe
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<jsp:include page="/templates/header.jsp"/>
    <body>
        <jsp:include page="/templates/nav_secretaria.jsp"></jsp:include>
        <h1>Turmas sem professores:</h1>
        <c:if test="${empty turmas}"><p class="container alert alert-info">Não há turmas sem professores</p></c:if>
        <ul class="list-group">
            <c:if test="${not empty turmas}">
                <table class="table">
                    <tr>
                        <th class="text-center">Curso</th>
                        <th class="text-center">Módulo</th>
                        <th class="text-center">Data de Inicio</th>
                        <th class="text-center">Data de termino</th>
                        <th class="text-center">Período</th>
                        <th class="text-center">Ação</th>
                    </tr>

                        <c:forEach var="turma" items="${turmas}">
                            <tr class="text-center">
                                <td>${turma.modulo.curso.descricao}</td>
                                <td>${turma.modulo.descricao}</td>  
                                <td><fmt:formatDate pattern="dd/MM/yyyy" value="${turma.dataInicio}"/></td>
                                <td><fmt:formatDate pattern="dd/MM/yyyy" value="${turma.dataFim}"/></td>
                                <td>${turma.periodo}</td>
                                <td>
                                    <button type="submit" class="btn btn-default" 
                                            name="idTurma" value="${turma.id}" form="definirProfessor">
                                        Definir Professor
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                </table>
            </c:if>
            <form action="Executa" method="post" id="definirProfessor">
                <input type="hidden" name="tarefa" value="TurmaServlet">
                <input type="hidden" name="metodo" value="definirProfessorParaTurma">
            </form>
        </ul>
    </body>
</html>
