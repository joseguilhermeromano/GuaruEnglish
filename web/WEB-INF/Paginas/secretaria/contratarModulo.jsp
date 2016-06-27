<%-- 
    Document   : contratarModulo
    Created on : 27/06/2016, 20:03:50
    Author     : Luiz Felipe
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <h1>Contrato:</h1>
        <form action="Executa" method="post">
            <select class="selectpicker" onclick="this.form.submit()">
                <c:forEach var="curso" items="${cursos}">
                    <option value="${curso.id}">${curso.descricao}</option>
                </c:forEach>
            </select>
            <input type="hidden" name="tarefa" value="ContrarModulo">
        </form>
        
        <c:if test="${modulos != null}">
            <form action="Executa" method="post">
                <select name="idModulo" class="selectpicker" onclick="this.form.submit()">
                    <c:forEach var="modulo" items="${modulos}">
                        <option value="${modulo.id}">${modulo.descricao}</option>
                    </c:forEach>
                </select>
                <input type="hidden" name="tarefa" value="ContrarModulo">
            </form>
        </c:if>
        
        <c:if test="${turmas != null}">
            <form action="Executa" method="post">
                <select class="selectpicker" onclick="this.form.submit()">
                    <c:forEach var="turma" items="${turmas}">
                        <option value="${turma.id}">${turma.descricao}</option>
                    </c:forEach>
                </select>
                <input type="hidden" name="tarefa" value="ContrarModulo">
            </form>
        </c:if>
        
    </body>
</html>
