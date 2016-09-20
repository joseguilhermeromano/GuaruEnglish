<%-- 
    Document   : modulo
    Created on : 04/07/2016, 21:02:00
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modulo/title>
    </head>
    <body>
        <hr>
        <h1>Boletim dos Alunos</h1>
        <form action="Executa" method="post" id="boletimaltera">
            <c:if test="${not empty boletim}">
                <table border="1" class="table table-striped">
                    <tr>
                        <th>Id do Modulo</th>
                        <th>Duracao</th>
                        <th>Nivel</th>
                        <th>Preco</th>
                        <th>Publico Alvo</th>
                        <th>Status</th>
                        <th>descricao</th>
                        <th>Descrição do Curso</th>
                    </tr>
                    <c:forEach var="modulo" items="${modulo}">
                        <tr>
                            <td>${modulo.id}</td>
                            <td>${modulo.duracao}"></td>
                            <td>${modulo.nivel}</td>
                            <td>${modulo.preco}</td>
                            <td>${modulo.publicoAlvo}</td>
                            <td>${modulo.status}</td>
                            <td>${modulo.descricao}</td>
                            <td>${modulo.curso.descricao}</td>
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
