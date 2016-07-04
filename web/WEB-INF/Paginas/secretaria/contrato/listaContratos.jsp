<%-- 
    Document   : contratos
    Created on : 03/07/2016, 21:21:10
    Author     : Luiz Felipe
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="/templates/header.jsp"/>
    <body>
        <jsp:include page="/templates/nav_secretaria.jsp"></jsp:include>
        
        <div class="container">
            <form action="Executa" method="post" class="form-inline">
                <label class="control-label">Código contrato</label>
                <input class="form-control" type="text" name="idContrato">
                <input type="hidden" name="tarefa" value="ContratoServlet">
                <input type="hidden" name="metodo" value="view">
                <button type="submit" class="btn btn-default">Buscar</button>
            </form>
            <h1 class="page-header">Contratos</h1>
            <table class="table">
                <tr>
                    <th class="text-center">Código</th>
                    <th class="text-center">Aluno</th>
                    <th class="text-center">Módulo</th>
                    <th class="text-center">Detalhes</th>
                </tr>
                
                <c:forEach var="contrato" items="${contratos}">
                    <tr class="text-center">
                        <td>${contrato.id}</td>
                        <td>${contrato.aluno.nome}</td>
                        <td>${contrato.modulo.descricao}</td>
                        <td>
                            <button form="detalhesContrato" class="btn btn-default" type="submit" 
                                    name="idContrato" value="${contrato.id}">
                                Detalhes
                            </button>
                        </td>
                    </tr>    
                </c:forEach> 
                
            </table>
            <form id="detalhesContrato" action="Executa" method="post">
                <input type="hidden" name="tarefa" value="ContratoServlet">
                <input type="hidden" name="metodo" value="view">
            </form>
            
        </div>
    </body>
</html>
