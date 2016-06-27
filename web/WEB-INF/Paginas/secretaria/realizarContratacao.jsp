<%-- 
    Document   : realizarContratacao
    Created on : 27/06/2016, 17:05:56
    Author     : Luiz Felipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
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
        </form>
        
    </body>
</html>
