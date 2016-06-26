<%-- 
    Document   : nav_secretaria
    Created on : 25/06/2016, 15:58:06
    Author     : Luiz Felipe
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<ul>
    <li>Cursos
        <ul>
            <li>Cadastrar Módulos</li>
            <li>Consultar Módulos</li>
            <li>Cadastrar Turmas</li>
            <li>Consultar Turmas</li>
        </ul>
    </li>
    <li>Usuarios
        <ul>
            <li><a href="<c:url value="Acessa">
                       <c:param name="tarefa" value="RouteAcessa"></c:param>
                       <c:param name="action" value="cadastrarUsuario"></c:param>
                   </c:url>">Cadastra Usuário</a></li>
            <li><a href="<c:url value="Acessa">
                       <c:param name="tarefa" value="RouteAcessa"></c:param>
                       <c:param name="action" value="consultarUsuario"></c:param>
                   </c:url>">Consultar Usuários</a></li>
        </ul>
    </li>
    <li>Alunos
    
    </li>
    <li>Professor
    
    
    </li>
</ul>
