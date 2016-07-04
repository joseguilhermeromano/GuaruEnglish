<%-- 
    Document   : cadastraTurmaSucesso
    Created on : 27/06/2016, 13:24:21
    Author     : Luiz Felipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
    <jsp:include page="/templates/header.jsp"/>
    <body>
        <jsp:include page="/templates/nav_secretaria.jsp"></jsp:include>
        <h1>A Turma foi cadastrada com sucesso.</h1>
        
        <form action="Executa" method="post">    
            <input type="hidden" name="tarefa" value="TurmaServlet">
            <input type="hidden" name="action" value="executa">
            <button class="btn btn-default" type="submit">Ok</button>
        </form>
    </body>
</html>
