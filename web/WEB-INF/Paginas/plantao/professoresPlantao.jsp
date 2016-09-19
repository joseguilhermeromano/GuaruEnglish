<%-- 
    Document   : professoresPlantao
    Created on : 04/07/2016, 17:52:29
    Author     : Luiz Felipe
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="/templates/header.jsp"/>
    <body>
        <jsp:include page="/templates/nav_secretaria.jsp"></jsp:include>
        <div class="container">
        <h1 class="page-header"t>Professores para plantão:</h1>
        <table class="table">
            <tr class="text-center">
                <th class="text-center">Código</th>
                <th class="text-center">Nome</th>
                <th class="text-center">Carga Horária</th>
                <th class="text-center">Carga Horária Disponivel</th>
                <th class="text-center">Ação</th>
            </tr>
            <c:if test="${not empty professores}">
                <c:forEach items="${professores}" var="professor">
                    <tr class="text-center">
                        <td>${professor.id}</td>
                        <td>${professor.nome}</td>
                        <td>${professor.cargaHoraria}</td>
                        <td>${professor.cargaHorariaDisponivel}</td>
                        <td>
                            <button form="definirPlantao" name="idProfessor" 
                                    value="${professor.id}" class="btn btn-primary">
                                Definir plantão
                            </button>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>
        </table>
        <form action="Executa" method="post" id="definirPlantao">
            <input type="hidden" name="tarefa" value="PlantaoServlet">
            <input type="hidden" name="metodo" value="definirPlantao">
        </form>
        </div>
    </body>
</html>
