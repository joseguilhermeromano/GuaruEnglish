<%-- 
    Document   : editarTurma
    Created on : 03/07/2016, 16:48:29
    Author     : Luiz Felipe
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="/templates/header.jsp"/>
    <body>
        <jsp:include page="/templates/nav_secretaria.jsp"></jsp:include>
        <div class="container">
            <h1 class="page-header">Atualizar Turma:</h1>
            <p>
                <b>Curso:</b> ${turma.modulo.curso.descricao}
                <br><b>Módulo:</b> ${turma.modulo.descricao}
            </p>
        
            <form id="formTurma" action="Executa" method="post">
                <fmt:formatDate value="${turma.dataInicio}" pattern="yyyy-MM-dd" var="dataInicio"/>
                <fmt:formatDate value="${turma.dataFim}" pattern="yyyy-MM-dd" var="dataFim"/>
                <label>Data Inicio: </label><input type="date" name="dataInicio" value="${dataInicio}"><br/><br/>
                <label>Data Termino: </label><input type="date" name="dataFim" value="${dataFim}"><br/><br/>
                <label>Período: </label>
                <select name="periodo"><br/><br/>
                    <option value="matutino" 
                            <c:if test="${turma.periodo eq 'matutino'}">selected</c:if>>
                        matutino
                    </option>
                    <option value="vespertino" 
                        <c:if test="${turma.periodo eq 'vespertino'}">selected</c:if>>
                        vespertino</option>
                    <option value="noturno" <c:if test="${turma.periodo eq 'noturno'}">selected</c:if>>
                        noturno
                    </option>
                </select><br/><br/>
                <button type="submit" class="btn btn-default">Atualizar</button>
                <input type="hidden" name="tarefa" value="TurmaServlet">
                <input type="hidden" name="metodo" value="atualizar">
                <input type="hidden" name="idTurma" value="${turma.id}">
            </form>
            
            <c:if test="${not empty erroAtualizar}">
                <br><br><p class="alert alert-danger">${erroAtualizar}<p>
            </c:if>
        </div>
    </body>
</html>
