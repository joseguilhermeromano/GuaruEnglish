<%-- 
    Document   : definirProfessorTurma
    Created on : 30/06/2016, 23:41:40
    Author     : Luiz Felipe
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="/templates/header.jsp"/>
    <body>
        <jsp:include page="/templates/nav_secretaria.jsp"></jsp:include>
        <div class="container">
            <h1 class="page-header">Detalhes da Turma:</h1>
            <p>
                <b>Curso:</b> ${turma.modulo.curso.descricao}
                <b>Módulo:</b> ${turma.modulo.descricao}
                <br><b>Nivel</b> ${turma.modulo.curso.descricao}
                <br><b>Descricao:</b> ${turma.modulo.curso.descricao}
                <br><b>Nível do módulo:</b> 
                <c:if test="${turma.modulo.nivel eq 1}">Básico</c:if>
                <c:if test="${turma.modulo.nivel eq 2}">Médio</c:if>
                <c:if test="${turma.modulo.nivel eq 3}">Avançado</c:if>
            </p>

            <h2>Escolha o professor para turma:</h2>

            <div class="col-md-6">
                <select form="associarProfessor" name="idProfessor" class="form-control">
                    <c:forEach var="professor" items="${professores}">
                        <option value="${professor.id}"> 
                            Professor: ${professor.nome} - 
                            Nível de Experiencia: ${professor.nivelExperiencia}
                        </option>
                    </c:forEach>
                </select>
            </div>

            <form action="Executa" method="post" id="associarProfessor">
                <button class="btn btn-primary">Associar Professor a Turma!</button>
                <input type="hidden" name="tarefa" value="TurmaServlet">
                <input type="hidden" name="metodo" value="associarProfessorTurma">
                <input type="hidden" name="idTurma" value="${turma.id}">
            </form>
        </div>
    </body>
</html>
