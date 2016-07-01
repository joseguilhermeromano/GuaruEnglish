<%-- 
    Document   : consultaModulos
    Created on : 30/06/2016, 20:47:30
    Author     : Luiz Felipe
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="/templates/header.jsp"/>
    <body>
        <jsp:include page="/templates/nav_secretaria.jsp"></jsp:include>
        <form>
            <input type="text">
            
            <button>Buscar</button>
            
            
        </form>
        <h1>Módulos:</h1>
        <table class="table">
            <tr>
                <th>Cod</th>
                <th>Descrição</th>
                <th>Publico Alvo</th>
                <th>Curso</th>
                <th>Status</th>
                <th>Nivel</th>
                
            </tr>
        <c:forEach var="modulo" items="${modulos}">
            <tr>
                <td>${modulo.id}</td>
                <td>${modulo.descricao}</td>
                <td>${modulo.publicoAlvo}</td>
                <td>${modulo.curso.descricao}</td>
                <c:if test="${modulo.status eq 1}"><td>Ativado</td></c:if>
                <c:if test="${modulo.status eq 0}"><td>Desativado</td></c:if>
                <c:if test="${modulo.nivel eq 1}"><td>Básico</td></c:if>
                <c:if test="${modulo.nivel eq 2}"><td>Intermediário</td></c:if>
                <c:if test="${modulo.nivel eq 3}"><td>Avançado</td></c:if>
            </tr>
        </c:forEach>
        </table>
    </body>
</html>
