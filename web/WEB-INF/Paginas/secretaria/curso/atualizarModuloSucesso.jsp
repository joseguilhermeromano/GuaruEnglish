<%-- 
    Document   : alterarModuloSucesso
    Created on : 30/06/2016, 19:05:39
    Author     : Luiz Felipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="/templates/header.jsp"/>
    <body>
        <jsp:include page="/templates/nav_secretaria.jsp"></jsp:include>
        <h1>O módulo foi atualizado com sucesso</h1>
        <form action="Executa">
            <input type="submit" value="Ok">
            <input type="hidden" name="tarefa" value="RouteAcessa">
            <input type="hidden" name="action" value="Secretaria">
        </form>
    </body>
</html>
