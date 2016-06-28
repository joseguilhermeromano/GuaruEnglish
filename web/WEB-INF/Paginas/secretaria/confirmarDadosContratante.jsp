<%-- 
    Document   : confirmarDadosContratante
    Created on : 28/06/2016, 00:06:19
    Author     : Luiz Felipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="/templates/header.jsp"/>
    <body>
        <h1>Dados do contratante</h1>
        <p>UserName: </p>
        <form action="Executa">
            <label>Nome: </label><input type="text" name="nome" value="" >
            <label>CPF: </label><input type="text"  name="cpf" >
        </form>
    </body>
</html>
