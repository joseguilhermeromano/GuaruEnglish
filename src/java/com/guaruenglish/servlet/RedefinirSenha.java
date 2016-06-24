/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.servlet;

import com.guaruenglish.model.Usuario;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luiz Felipe
 */
public class RedefinirSenha implements Tarefa {
    private final static Map<String,String> PAGINA_PERFIL = new HashMap();
        static {
            PAGINA_PERFIL.put("Aluno", "WEB-INF/Paginas/alunoHome.jsp");
            PAGINA_PERFIL.put("Secretaria", "WEB-INF/Paginas/secretariaHome.jsp");
            PAGINA_PERFIL.put("Professor", "WEB-INF/Paginas/professorHome.jsp");
        }
    
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        
        String senha = req.getParameter("senha");
        String senhaConfirmada = req.getParameter("confirmar");
        
        if(senha.equals(senhaConfirmada)) {
            Usuario usuario = (Usuario)req.getSession().getAttribute("usuarioLoado");
            usuario.setSenha(senha);
            usuario.setStatusSenha(1);
            PAGINA_PERFIL.get(usuario.getPerfilAcesso());
        }
        
        req.setAttribute("error", "As senhas não correspondem");
        return "WEB-INF/Paginas/redefinirSenha.jsp";
        
    }
    
}
