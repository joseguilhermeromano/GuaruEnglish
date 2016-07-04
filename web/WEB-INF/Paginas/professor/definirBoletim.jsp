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
        <title>BOLETIM</title>
    </head>

    <body>

        <form action="Executa" method="post" id="consultaBoletim">
            <p>digite o id da turma</p>
            <input class="btn-default" type="text" name="idTurma" value="">
            <input type="hidden" name="tarefa" value="BoletimServlet">
            <input type="hidden" name="metodo" value="consultaBoletinsTurma">
            <button form="consultaBoletim" class="btn-warning" type="submit">Consultar</button>
        </form>

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
                            <td><input type="number" name="id" value="${boletim.id}">${boletim.id}</label> </td>
                            <td><label type="text" name="matricula" value="${boletim.aluno.matricula}">${boletim.aluno.matricula}</label>  </td>
                            <td><label type="text" name="nome" value="${boletim.aluno.nome}">${boletim.aluno.nome}</label>  </td>
                            <td><input type="number" name="parcial" value="${boletim.conceitoParcial}"> </td>
                            <td><input type="number" name="final" value="${boletim.conceitoFinal}"> </td>
                            <td><input type="number" name="faltas" value="${boletim.qtdFaltas}"> </td>
                        </tr>
                    </c:forEach>
                </table> 
            </c:if>
            <input type="hidden" name="tarefa" value="BoletimServlet">
            <input type="hidden" name="metodo" value="alteraBoletim">
            <button form="boletimaltera" class="btn-warning" type="submit">enviar</button>
        </form>

        

    </body>
</html>


