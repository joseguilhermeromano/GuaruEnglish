<%-- 
    Document   : listaSolicitacao
    Created on : 04/07/2016, 08:15:37
    Author     : Luiz Felipe
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="/templates/header.jsp"/>
    <body>
        <jsp:include page="/templates/nav_secretaria.jsp"></jsp:include>
        <div class="container">
            
            <h1 class="page-header">Solicitações de declaração de Matrícula:</h1>
            <c:if test="${empty declaracoes}">
                <p class="alert alert-info">Não há solicitações pendentes</p>
            </c:if>
            <table class="table">
                <tr class="text-center">
                    <th>Código</th>
                    <th>Status</th>
                    <th>Data</th>
                    <th>Matricula</th>
                    <th>Analisar</th>
                </tr>
                <c:if test="${empty declaracaoNull}">
                    <c:forEach items="${declaracoes}" var="declaracao">
                        <tr>
                            <td>${declaracao.id}</td>
                            <td>${declaracao.status}</td>
                            <td>${declaracao.data}</td>
                            <td>${declaracao.contrato.aluno.matricula}</td>
                            <td>
                                <button form="analisar" type="submit" 
                                        class="btn btn-default">
                                    Analisar
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>    
            </table>
            <form id="analisar" method="post">
                <input type="hidden" name="tarefa" value="DeclarcaoServlet">
                <input type="hidden" name="metodo" value="view">
            </form>
            
        </div>
    </body>
</html>
