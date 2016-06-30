<%-- 
    Document   : contratoSucesso
    Created on : 29/06/2016, 10:58:15
    Author     : Luiz Felipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <body>
        <h1>Contrato:</h1>
        <p>
            <b>Contratante:</b> ${contrato.aluno.nome} 
            <b>Matricula do contratante:</b> ${contrato.aluno.matricula}
            <b>CPF: ${contrato.aluno.cpf}</b>
        </p>
        <p>
            <b>Código do contrato:</b> ${contrato.id}
            <b>Valor do contrato:</b> ${contrato.valor}
            <b>Data:</b> ${contrato.data}
            <b>Módulo Contratado:</b> ${contrato.modulo.descricao}
            <b>Valor do Módulo: </b> ${contrato.modulo.preco}
            <b>Duração:</b> ${contrato.modulo.duracao}
            <b></b>
        </p>
    </body>
</html>
