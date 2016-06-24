<%-- 
    Document   : redefinirSenha
    Created on : 24/06/2016, 15:34:56
    Author     : Luiz Felipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Redefinir Senha</title>
    </head>
    <body>
        <h3>É necessario redefinir sua senha</h3>
        <form action="Executa" method="post">
            <label>Senha:</label> <input type="password" name="senha">
            <label>Confirmar:</label> <input type="password" name="confirmar">
            <input type="submit" value="Salvar">
            <input type="hidden" name="tarefa" value="RedefinirSenha">
        </form>
        <c:if test="${not empty error}"><span>${error}</span> </c:if>
    </body>
</html>
