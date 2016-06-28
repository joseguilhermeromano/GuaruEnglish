<%-- 
    Document   : realizarContratacao
    Created on : 27/06/2016, 17:05:56
    Author     : Luiz Felipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="/templates/header.jsp"/>
    <body>
        <h1>Realizar contratação</h1>
        <p>Realizar contratação para aluno já cadastrado:</p>
        <form action="Executa" method="post">
            <label>CPF:</label><input type="text" name="cpf">
            <input type="submit" value="Buscar">
            <input type="hidden" name="tarefa" value="RealizarContratacao">
        </form>
        
        <form action="Executa" method="post">
            <button type="submit">Cadastrar Aluno Contratante</button> 
            <input type="hidden" name="tarefa" value="RealizarContratacao">
            <input type="hidden" name="novoAluno" value="true">
        </form>
        
    </body>
</html>
