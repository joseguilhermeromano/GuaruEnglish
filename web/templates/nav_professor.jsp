<%-- 
    Document   : nav_professor
    Created on : 04/07/2016, 19:42:40
    Author     : Luiz Felipe
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <ul class="nav navbar-nav">
            <li>
                <a href="<c:url value="Executa">
                       <c:param name="tarefa" value="RouteAcessa"></c:param>
                       <c:param name="action" value="verPlantao"></c:param>
                   </c:url>">
                    Plantão
                </a>
            </li>
            <li>
                <a href="<c:url value="Acessa">
                       <c:param name="tarefa" value="RouteAcessa"></c:param>
                       <c:param name="action" value="boletim"></c:param>
                   </c:url>">
                    Boletim
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