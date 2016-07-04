<%-- 
    Document   : declaracao
    Created on : 04/07/2016, 11:27:24
    Author     : Luiz Felipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="/templates/header.jsp"/>
    <body>
        <jsp:include page="/templates/nav_secretaria.jsp"></jsp:include>
        <div class="container">
            <h1 class="container">
                Solicitação de declaração de matrícula:
            </h1>
            <p>
                <b>Código do contrato:</b> ${declacaracao.contrato.id}
                <b>Aluno:</b> ${declaracao.contrato.aluno.nome}
                <b>Matrícula:</b> ${declaracao.contrato.aluno.matricula}
                
                <b>Status:</b> ${declaracao.status}s
            </p>
            
            <div class="btn-group">
                <button class="btn btn-success">Emitir</button>
            </div>
            
        </div>    
    </body>
</html>
