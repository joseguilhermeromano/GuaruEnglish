<%-- 
    Document   : contratoSucesso
    Created on : 29/06/2016, 10:58:15
    Author     : Luiz Felipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="/templates/header.jsp"/>
    <body>
        <jsp:include page="/templates/nav_secretaria.jsp"></jsp:include>
        <div class="container">
            <h1 class="page-header">Contrato:</h1>
            <p>
                <b>Contratante:</b> ${contrato.aluno.nome} 
                <br><b>Matricula do contratante:</b> ${contrato.aluno.matricula}
                <br><b>CPF: ${contrato.aluno.cpf}</b>
            </p>
            <p>
                <br><b>Código do contrato:</b> ${contrato.id}
                <br><b>Valor do contrato:</b> ${contrato.valor}
                <br><b>Data:</b> ${contrato.data}
                <br><b>Módulo Contratado:</b> ${contrato.modulo.descricao}
                <br><b>Valor do Módulo: </b> ${contrato.modulo.preco}
                <br><b>Duração:</b> ${contrato.modulo.duracao}
            </p>
        </div>
    </body>
</html>
