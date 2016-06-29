<%-- 
    Document   : cadastrarAluno
    Created on : 27/06/2016, 17:53:47
    Author     : Luiz Felipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="/templates/header.jsp"/>
<body>
    <div class="row">
        <div class=col-md-4>
            <h1>Cadastro do aluno:</h1>
            <form action="Executa" method="post" id="formCadastra">
                <fieldset class="form-group">
                    <label for="Nome completo:" >Fulano Silva </label>
                    <input type="text:" name="nome"  class="form-control"  id="formGroupExampleInput" placeholder="Fulano Silva exemplo"> 
                    <label for="Usuario:" >Usuario </label>
                    <input type="text:" name="userName" class="form-control"  id="formGroupExampleInput" placeholder="fulano">
                    <label for="Senha:" >Senha: </label>
                    <input type="password" name="senha"  class="form-control"  id="formGroupExampleInput" placeholder="*******">
                    <label for="CPF:" >CPF: </label>
                    <input type="text" name="cpf"  class="form-control"  id="formGroupExampleInput" placeholder="442135325">
                </fieldset>  
                <input type="hidden" name="tarefa" value="CadastrarAlunoContratante">
                <input class="btn-default" type="submit" value="Cadastrar">

            </form>
        </div>
    </div>    
</body>
</html>
