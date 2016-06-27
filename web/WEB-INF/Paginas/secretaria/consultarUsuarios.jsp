<%-- 
    Document   : consultarUsuarios
    Created on : 26/06/2016, 17:08:09
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
        <jsp:include page="/templates/nav_secretaria.jsp"></jsp:include>
        <h1>Consultar Usuários</h1>
        <c:if test="${not empty usuarios}">
            <table>
                <tr>
                    <th>Nome</th>
                    <th>UserName</th>
                    <th>Cargo</th>
                    <th>Perfil de Acesso</th>
                    <th>Status</th>
                </tr>
                <c:forEach var="usuario" items="${usuarios}">
                    <tr>
                        <td>${usuario.nome}</td>
                        <td>${usuario.userName}</td>
                        <td>${usuario.cargo}</td>
                        <td>${usuario.perfilAcesso}</td>
                        <c:if test="${usuario.status == 1}"><td>Ativado</td></c:if>
                        <c:if test="${usuario.status == 0}"><td>Desativado</td></c:if>
                    </tr>
                </c:forEach>
            </table>
            
            
        </c:if>
        
    </body>
</html>
