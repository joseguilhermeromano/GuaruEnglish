<%-- 
    Document   : boletim
    Created on : 04/07/2016, 20:01:12
    Author     : Aluno
--%>
<%-- 
    Document   : verPlantao
    Created on : 27/06/2016, 00:46:02
    Author     : rafin
--%>
<jsp:include page="/templates/header.jsp"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<jsp:include page="/templates/header.jsp"/>
    <body>
        <jsp:include page="/templates/nav_aluno.jsp"></jsp:include>
        <hr>
        <h1>Boletim dos Alunos</h1>
        <form action="Executa" method="post" id="boletimaltera">
            <c:if test="${not empty boletim}">
                <table border="1" class="table table-striped">
                    <tr>
                        <th>Id do Boletim</th>
                        <th>Matricula</th>
                        <th>Nome do Aluno</th>
                        <th>Nota Parcial</th>
                        <th>Nota Final</th>
                        <th>Faltas</th>
                    </tr>
                    <c:forEach var="boletim" items="${boletim}">
                        <tr>
                            <td>${boletim.id} </td>
                            <td><label type="text" name="matricula" >${boletim.aluno.matricula}</label>  </td>
                            <td><label type="text" name="nome" >${boletim.aluno.nome}</label>  </td>
                            <td>${boletim.conceitoParcial} </td>
                            <td>${boletim.conceitoFinal}</td>
                            <td>${boletim.qtdFaltas}</td>
                        </tr>
                    </c:forEach>
                </table> 
            </c:if>
            <input type="hidden" name="tarefa" value="BoletimServlet">
            <input type="hidden" name="metodo" value="consultaBoletinsAluno">
        </form>
    </body>
</html>
