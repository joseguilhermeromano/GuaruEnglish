<%-- 
    Document   : atualizarModulo
    Created on : 30/06/2016, 08:27:53
    Author     : Luiz Felipe
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="/templates/header.jsp"/>

    <body>
        <jsp:include page="/templates/nav_secretaria.jsp"></jsp:include>
        <h1>Atualização dos módulos:</h1>
        <form action="Executa" method="post">
            <label>Código do módulo:</label>
            <input type="text" name="idModulo" <c:if test="${not empty modulo.id}">value="${modulo.id}"</c:if>>
            <input type="submit" value="Buscar">
            <input type="hidden" name="tarefa" value="AtualizarModulo">
        </form>
        
            
        <c:if test="${not empty erro}">${erro}</c:if>
        <c:if test="${not empty modulo}">
           
            <h2>Informações do módulo:</h2>
            <form action="Executa" method="post">
                <h4>Curso: ${modulo.curso.descricao}</h4>
                <label>Descricao</label> <input type="text" name="descricao" value="${modulo.descricao}">
                <br><label>Conteúdo Básico:</label> 
                <br><textarea name="conteudoBasico">${modulo.conteudoBasico}</textarea>
                <br><label>Oferecer módulo:</label> <input name="status" type="checkbox" value="1"
                        <c:if test="${modulo.status == 1}">
                            checked
                        </c:if>
                    >
                <br><label>Publico alvo:</label> <input name="publicoAlvo" value="${modulo.publicoAlvo}">
                <br><label>Nível:</label> 
                <select name="nivel">
                    <option value="1" <c:if test="${modulo.nivel eq 1}"> selected </c:if>>Básico</option>
                    <option value="2" <c:if test="${modulo.nivel eq 2}"> selected </c:if>>Médio</option>
                    <option value="3" <c:if test="${modulo.nivel eq 3}"> selected </c:if>>Avançado</option>
                </select>
                <br><label>Valor:</label> <input type="text" name="preco" value="${modulo.preco}">
                    <br><label>Duração em horas:</label>  
                    <input type="text" name="duracao" value="${modulo.duracao}">
                <br><input type="submit" value="Atualizar">
                <input type="hidden" name="tarefa" value="RealizarAtualizacaoModulo">
                <input type="hidden" name="idModulo" value="${modulo.id}">
            </form>
        </c:if>    
    </body>
</html>
