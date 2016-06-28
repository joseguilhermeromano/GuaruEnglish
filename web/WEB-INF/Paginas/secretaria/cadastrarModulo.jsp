<%-- 
    Document   : cadastrarModulo
    Created on : 26/06/2016, 18:45:44
    Author     : Luiz Felipe
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="/templates/header.jsp"/>
    <body>
        <jsp:include page="/templates/nav_secretaria.jsp"></jsp:include>
        <h1>Cadastrar Módulo</h1>
        <c:if test="${cursos == null}"><p>Não há cursos cadastrados</p></c:if>
        <c:if test="${cursos != null}">
            <form action="Executa" method="post">
                <label>Curso: </label>
                <select name="curso">
                    <c:forEach var="curso" items="${cursos}">
                        <option value="${curso.id}">${curso.descricao}</option>
                    </c:forEach>
                </select><br/><br/>
                <label>Descrição: </label><input type="text" name="descricao"><br/><br/>
                <label>Conteúdo Básico: </label><br/><textarea name="conteudoBasico"></textarea><br/><br/>
                <label>Publico Alvo: </label><input type="text" name="publicoAlvo"><br/><br/>
                <input type="checkbox" name="status" value="1"><label>Oferecer módulo</label><br/><br/>
                <label>Nivel: </label>
                <select name="nivel">
                    <option value="1">Básico</option>
                    <option value="2">Intermediario</option>
                    <option value="3">Avançado</option>
                </select><br/><br/>
                <label>Valor: </label><input type="text" name="preco"><br/><br/>
                <label>Duração em horas:</label><input type="text" name="duracao"><br/><br/>
                <input type="submit" value="Cadastrar">
                <input type="hidden" name="tarefa" value="CadastrarModulo">
            </form>
        </c:if>
    </body>
</html>
