<%-- 
    Document   : nav_aluno
    Created on : 04/07/2016, 11:25:03
    Author     : Luiz Felipe
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <ul class="nav navbar-nav">
            <li>
                <a href="<c:url value="Executa">
                       <c:param name="tarefa" value="BoletimServlet"></c:param>
                       <c:param name="metodo" value="consultaBoletinsAluno"></c:param>
                   </c:url>">Boletins
                </a>
            </li>
            <li>
                <a href="<c:url value="Executa">
                    <c:param name="tarefa" value="Logoff"></c:param>
                    </c:url>">
                    Logoff
                </a>
            </li>
        </ul>
    </div>
</nav>
