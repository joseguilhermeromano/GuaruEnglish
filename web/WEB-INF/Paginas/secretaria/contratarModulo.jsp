<%-- 
    Document   : contratarModulo
    Created on : 27/06/2016, 20:03:50
    Author     : Luiz Felipe
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="/templates/header.jsp"/>
    <body>
        <jsp:include page="/templates/nav_secretaria.jsp"></jsp:include>
        <h1>Contratar Módulo: </h1>
        <form action="Executa" method="post"> 
            <label>Código do Módulo: </label><input type="text" name="idModulo"
            <c:if test="${modulo != null}">value="${modulo.id}"</c:if>                                  >
            <input type="hidden" name="tarefa" value="ContratarModulo">
            <input type="submit" value="Buscar">
        </form>
        
        <c:if test="${modulo != null}">
            <h3>Informações do módulo:</h3>
            <p>
               <b>Curso: </b> ${modulo.curso.descricao}<br>
               <b>Descrição: </b> ${modulo.descricao}
               <b>Preço: </b> R$ ${modulo.preco}<br>
               <b>Duração: </b> ${modulo.duracao} horas
            </p>
            
            <c:if test="${empty turmas}"><p>Não há Turmas cadastradas para esse módulo</p></c:if>
            <c:if test="${not empty turmas}"> 
            <h4>Turmas:</h4>
                <form action="Executa">
                    <select name="idTurma">
                        <c:forEach var="turma" items="${turmas}">
                            <option value="${turma.id}">Turma ${turma.id} - ${turma.periodo}</option>
                        </c:forEach>
                    </select><br/><br/>
                    <input type="submit" value="Continuar Contratação">
                    <input type="hidden" name="tarefa" value="PagamentoContrato">
                </form>
            </c:if>
        </c:if>
    </body>
</html>
