<%-- 
    Document   : ProfessorTurmaSucesso
    Created on : 01/07/2016, 11:04:09
    Author     : Luiz Felipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="/templates/header.jsp"/>
    <body>
        <jsp:include page="/templates/nav_secretaria.jsp"></jsp:include>
        <div class="container">
            <div class="alert alert-success col-md-6">
                <p>Definição de professor para a turma realizado com <strong>sucesso!</strong>
                    <button class="btn btn-xs btn-success pull-right" type="submit" form="formSucesso"> 
                        Ok 
                    </button>
                </p>
            </div>
            <form action="Executa" id="formSucesso" method="post">
                <input type="hidden" name="tarefa" value="TurmaServlet">
                <input type="hidden" name="metodo" value="view">
                <input type="hidden" name="idTurma" value="${turma.id}">
            </form>
        </div>
    </body>
</html>
