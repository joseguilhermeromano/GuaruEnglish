<%-- 
    Document   : cadastrarUsuario
    Created on : 25/06/2016, 16:13:41
    Author     : Luiz Felipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="/templates/header.jsp"/>
    <body>
        <jsp:include page="/templates/nav_secretaria.jsp"></jsp:include>
        <h1>Cadastrar Usuário</h1>
        
        <form action="Executa" method="post" id="formCadastra">
            <label>Nome:</label> <input type="text" name="nome"><br/><br/>
            <label>User Name:</label> <input type="text" name="userName"><br/><br/>
            <label>Senha Default:</label> <input type="password" name="senha"><br/><br/>
            <label>CPF: </label> <input type="text" name="cpf"><br/><br/>
            <label>Cargo:</label> <input type="text" name="cargo">
            <input type="hidden" name="tarefa" value="CadastrarUsuario">
        </form><br>
        <label>Perfil de Acesso:</label>
        <select id="perfilAcesso" name="perfilAcesso" form="formCadastra" onchange="mostra()">
            <option value="Secretaria">Secretária</option>
            <option value="Professor">Professor</option>
            <option value="Aluno">Aluno</option>
        </select><br/><br/>
        
        <div id="formProfessor" style="display: none;">
            <label>Especialidade do Professor:</label>
            <input type="text" name="especialidade" form="formCadastra"><br/><br/>
            <label>Nível de experiênia:</label><br/>
            <input type="radio" name="experiencia" value="baixo" form="formCadastra">baixo<br/>
            <input type="radio" name="experiencia" value="médio" form="formCadastra">médio<br/>
            <input type="radio" name="experiencia" value="avançado" form="formCadastra">avançado<br/>
            <label>Carga Horária: </label><input type="text" name="cargaHoraria" form="formCadastra">
        </div>
        <br/>
        <button form="formCadastra" type="submit">Cadastrar</button>
        
        <script type="text/javascript">
	function mostra() {
            var selectValue = document.getElementById("perfilAcesso");
            var perfilAcesso = selectValue.options[ selectValue.selectedIndex ].value;
            if (perfilAcesso === 'Professor') {
                document.getElementById('formProfessor').style.display = "block";
            }
            else {
                document.getElementById('formProfessor').style.display = 'none';
            }
	}
        </script>
    </body>
</html>
