<%-- 
    Document   : cadastrarTurma
    Created on : 26/06/2016, 23:43:43
    Author     : Luiz Felipe
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="/templates/header.jsp"/>
    <body>
        <jsp:include page="/templates/nav_secretaria.jsp"></jsp:include>
        <h1>Cadastrar Turma</h1>
        
        <select name="modulo" form="formTurma">
            <option>--- Escolha um módulo de curso ---</option>
            <c:forEach var="curso" items="${cursos}">
                <c:forEach var="modulo" items="${curso.modulos}">
                    <c:if test="${modulo.status == 1}">
                        <option value="${modulo.id}">
                            Curso: ${curso.descricao} - Módulo: ${modulo.descricao}
                        </option>
                    </c:if>
                </c:forEach>
            </c:forEach>
        </select><br/><br/>
        
        <form id="formTurma" action="Executa" method="post">
            <label>Data Inicio: </label><input type="date" name="dataInicio"><br/><br/>
            <label>Data Termino: </label><input type="date" name="dataFim"><br/><br/>
            <label>Período: </label>
            <select name="periodo"><br/><br/>
                <option value="manutino">matutino</option>
                <option value="vespertino">vespertino</option>
                <option value="noturno">noturno</option>
            </select><br/><br/>
            <input type="submit" value="cadastrar">
            <input type="hidden" name="tarefa" value="CadastrarTurma">
        </form>
        
    </body>
</html>
