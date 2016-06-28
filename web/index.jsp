<%-- 
    Document   : index
    Created on : 23/06/2016, 12:16:23
    Author     : Luiz Felipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="/templates/header.jsp"/>
<body>
        <h1>GuaruEnglish:</h1>
        <h3>Login:</h3>
        <form action="Executa" method="post">
            <label>UserName:</label><input type="text" name="userName">
            <label>Senha:</label><input type="password" name="senha">
            <input type="submit">
            <input type="hidden" name="tarefa" value="Login">
        </form>
    </body>
</html>
