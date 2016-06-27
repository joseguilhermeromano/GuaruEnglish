<%-- 
    Document   : verPlantao
    Created on : 27/06/2016, 00:46:02
    Author     : rafin
--%>
<jsp:include page="/templates/header.jsp"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Professor</title>
    </head>
    <body>
        <h1>Ver plantões</h1>
        <form class="form-inline" action="Executa" method="post" id="formplantao">
            <label>De: </label><input type="date" name="dataInicial">
            <label>Até: </label><input type="date" name="dataFinal">
            <input type="hidden" name="tarefa" value="ConsultarPlantao">
            <button form="formplantao" type="submit">Consultar</button>
        </form>
        <hr>
        <h1>Plantões:</h1>
        <c:if test="${not empty plantao}">
            <table border="1" class="table table-striped">
                <tr>
                    <th>ID</th>
                    <th>DATA</th>
                    <th>QUANTIDADE DE HORAS</th>
                </tr>
                <c:forEach var="plantao" items="${plantao}">
                    <tr>
                        <td>${plantao.id}</td>
                        <td>${plantao.data}</td>
                        <td>${plantao.qtdhoras}</td>
                    </tr>
                </c:forEach>
            </table> 
        </c:if>
        
    </body>
</html>
