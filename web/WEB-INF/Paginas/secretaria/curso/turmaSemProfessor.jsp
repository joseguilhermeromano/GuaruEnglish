<%-- 
    Document   : turmaSemProfessor
    Created on : 30/06/2016, 22:59:58
    Author     : Luiz Felipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="/templates/header.jsp"/>
    <body>
        <jsp:include page="/templates/nav_secretaria.jsp"></jsp:include>
        <h1>Turmas sem professores</h1>
        <ul>
            <li>${turma.modulo.descricao}</li>
        </ul>
    </body>
</html>
