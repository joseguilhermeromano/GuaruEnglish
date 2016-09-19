<%-- 
    Document   : definirPlantao
    Created on : 04/07/2016, 21:18:32
    Author     : Luiz Felipe
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="/templates/header.jsp"/>
    <body>
        <jsp:include page="/templates/nav_secretaria.jsp"></jsp:include>
        <div class="container">
        <h1>Definir Plantão:</h1>
        
        <form action="Executa" class="form-inline">
            Data:<input type="date" name="data">
            Quantidade de horas: <input type="text" name="qtdHoras">
            <button type="submit" class="btn btn-default">Definir</button>
            <input type="hidden" name="tarefa" value="PlantaoServlet">
            <input type="hidden" name="metodo" value="inserirPlantao">
            <input type="hidden" name="idProfessor" value="${professor.id}">
        </form>
        
        <p>
            Nome: ${professor.nome}
            <br>Carga Horária: ${professor.cargaHoraria}
            <br>Carga Horária Disponivel: ${professor.cargaHorariaDisponivel}
        </p>
        
        <c:if test="${not empty erro}">${error}</c:if>
        </div>
    </body>
</html>
