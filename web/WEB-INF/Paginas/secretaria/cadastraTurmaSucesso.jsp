<%-- 
    Document   : cadastraTurmaSucesso
    Created on : 27/06/2016, 13:24:21
    Author     : Luiz Felipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Turma</title>
    </head>
    <body>
        <jsp:include page="/templates/nav_secretaria.jsp"></jsp:include>
        <h1>A Turma foi cadastrada com sucesso.</h1>
        <form action="Acesso" method="post">    
            <input type="hidden" name="tarefa" value="RouteAcessa">
            <input type="hidden" name="action" value="Secretaria">
            <button type="submit">Ok</button>
        </form>
    </body>
</html>
