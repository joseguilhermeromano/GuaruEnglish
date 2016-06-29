<%-- 
    Document   : cadastrarAluno
    Created on : 27/06/2016, 17:53:47
    Author     : Luiz Felipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="/templates/header.jsp"/>
    <body>
        <h1>Cadastro do aluno:</h1>
        <form class="form-group row" action="Executa" method="post" id="formCadastra">
            <label>Nome: </label><input type="text" name="nome"><br/><br/>
            <label>User Name: </label><input type="text" name="userName"><br/><br/>
            <label>Senha Default: </label><input type="password" name="senha"><br/><br/>
            <label>CPF: </label><input type="text" name="cpf"><br/><br/>
            <input type="hidden" name="tarefa" value="CadastrarAlunoContratante">
            <input class="btn-default" type="submit" value="Cadastrar">
        </form>
    </body>
</html>
