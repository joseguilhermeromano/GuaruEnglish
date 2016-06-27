<%-- 
    Document   : cadastrarTurma
    Created on : 26/06/2016, 23:43:43
    Author     : Luiz Felipe
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cadastrar Turma</h1>
        
        
        
        <select name="modulo">
            <c:forEach var="curso" items="${cursos}">
                <c:forEach var="modulo" items="${curso.modulos}">
                    <option value="${modulo.id}">Curso: ${curso.descricao} - Módulo: ${modulo.descricao}</option>
                </c:forEach>
            </c:forEach>
        </select>
        
    </body>
</html>
