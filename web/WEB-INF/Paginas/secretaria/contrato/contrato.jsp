<%-- 
    Document   : contrato
    Created on : 03/07/2016, 22:04:17
    Author     : Luiz Felipe
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="/templates/header.jsp"/>
    <body>
        <jsp:include page="/templates/nav_secretaria.jsp"></jsp:include>
        <div class="container">
            <h1 class="page-header">Detalhes do Contrato:</h1>
            <h1>Contrato:</h1>
            <p>
                <b>Contratante:</b> ${contrato.aluno.nome} 
                <br><b>Matricula do contratante:</b> ${contrato.aluno.matricula}
                <br><b>CPF: ${contrato.aluno.cpf}</b>
            </p>
            <p>
                <b>Código do contrato:</b> ${contrato.id}
                <br><b>Valor do contrato:</b> ${contrato.valor}
                <br><b>Data:</b> ${contrato.data}
                <br><b>Módulo Contratado:</b> ${contrato.modulo.descricao}
                <br><b>Valor do Módulo: </b> ${contrato.modulo.preco}
                <br><b>Duração:</b> ${contrato.modulo.duracao}
                
            </p>
            <h3>Parcelas:</h3>
            <table class="table">
                <tr>
                    <th class="text-center">Código</th>
                    <th class="text-center">Número</th>
                    <th class="text-center">Status</th>
                    <th class="text-center">Data</th>
                    <th class="text-center">Valor</th>
                    <th class="text-center">Ação</th>
                </tr>
                <c:forEach items="${contrato.parcelas}" var="parcela" >
                    <tr class="text-center">
                        <td>${parcela.id}</td>
                        <td>${parcela.numParcela}</td>
                        <c:if test="${parcela.status eq 1}"><td>Pago</td></c:if>
                        <c:if test="${parcela.status eq 0}"><td>Não paga</td></c:if>
                        <td><fmt:formatDate pattern="dd/MM/yyy" value="${parcela.dataPagamento}"/></td>
                        <td>${parcela.valor}</td>
                        <td>
                            <button type="submit" form="darBaixa" 
                                    <c:if test="${parcela.status eq 1}"> disabled="disabled"</c:if> 
                                    name="idParcela" value="${parcela.id}" 
                                    class="btn btn-success">
                                Dar baixa
                            </button>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <form action="Executa" id="darBaixa" method="post">
                <input type="hidden" name="tarefa" value="ParcelaServlet">
                <input type="hidden" name="metodo" value="darBaixaParcela">
            </form>
        </div>
    </body>
</html>
