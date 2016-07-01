<%-- 
    Document   : nav_secretaria
    Created on : 25/06/2016, 15:58:06
    Author     : Luiz Felipe
--%>
<!--jsp:include page="/templates/header.jsp"/-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <ul class="nav navbar-nav">
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">Cursos
                    <span class="caret"></span>
                </a>
                <ul class="dropdown-menu">

                    <li class="dropdown">
                        <a href="<c:url value="Executa">
                               <c:param name="tarefa" value="CadastrarModulo">               
                               </c:param>
                            </c:url>">Cadastrar Módulos
                        </a>
                    </li>

                    <li class="dropdown">
                        <a href="<c:url value="Executa">
                            <c:param name="tarefa" value="ConsultaModulos">
                            </c:param></c:url>">Consultar Modulos
                        </a>
                    </li>
                    <li class="dropdown">
                        <a href="<c:url value="Executa">
                               <c:param name="tarefa" value="RouteAcessa"></c:param>
                               <c:param name="action" value="atualizarModulo"></c:param>
                            </c:url>">Atualizar Módulo 
                        </a>
                    </li>
                    

                    <li class="dropdown">
                        <a href="<c:url value="Executa">
                            <c:param name="tarefa" value="CadastrarTurma">
                            </c:param></c:url>">Cadastrar Turmas
                            </a>
                    </li>

                    <li class="dropdown">
                        <a href="<c:url value="Executa">
                            <c:param name="tarefa" value="consultarTurmas">
                            </c:param></c:url>">Consultar Turmas
                        </a>
                    </li>
                    <li class="dropdown">
                        <a href="<c:url value="Executa">
                            <c:param name="tarefa" value="consultarTurmas">
                            </c:param></c:url>">Definir Professor para Turma
                        </a>
                    </li>
                    
                </ul>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Usuarios
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li class="dropdown" class="dropdown">
                            <li>
                                <a href="<c:url value="Acessa">
                                   <c:param name="tarefa" value="RouteAcessa"></c:param>
                                   <c:param name="action" value="cadastrarUsuario"></c:param>
                                   </c:url>">Cadastra Usuário
                                </a>
                            </li>

                            <li><a href="<c:url value="Acessa">
                               <c:param name="tarefa" value="RouteAcessa"></c:param>
                               <c:param name="action" value="cadastrarUsuario"></c:param>
                           </c:url>">Cadastra Usuário</a></li>

                    <li><a href="<c:url value="Executa">
                               <c:param name="tarefa" value="ConsultarUsuarios"></c:param>
                           </c:url>">Consultar Usuários</a></li>
                    </ul>
                </li>

            <li><a href="<c:url value="Executa">
                       <c:param name="tarefa" value="RealizarContratacao"></c:param>
                   </c:url>">
                    Realizar Contratação</a></li>
            <li><a href="<c:url value="Executa">
                       <c:param name="tarefa" value="Logoff"></c:param>
                   </c:url>">Logoff</a></li>

        </ul>
        </li>  
        </ul>
    </div>      
</nav>
