<%-- 
    Document   : pagamentoContrato
    Created on : 28/06/2016, 14:08:18
    Author     : Luiz Felipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="/templates/header.jsp"/>
    <body>
        <jsp:include page="/templates/nav_secretaria.jsp"></jsp:include>
        <h1>Pagamento: </h1>
        <p><b>Valor total do módulo: </b> ${preco}</p>
        <p><b>Valor a pagar: </b> ${valorContrato}</p>
        
        
        <label>Forma de pagamento:</label>
        <select name="qtdParcelas">
            
            <option value="1"> 1x </option>
            <option value="2"> 2x </option>
            <option value="3"> 3x </option>
            <option value="4"> 4x </option>
            <option value="5"> 5x </option>
        </select>
    </body>
</html>
