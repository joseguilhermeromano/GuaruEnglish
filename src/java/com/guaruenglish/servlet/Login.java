/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.servlet;

import com.guaruenglish.dao.UsuarioDAO;
import com.guaruenglish.model.Usuario;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Luiz Felipe
 */
public class Login implements Tarefa {
    
    private final static Map<String,String> PAGINA_PERFIL = new HashMap();
        static {
            PAGINA_PERFIL.put("Aluno", "WEB-INF/Paginas/alunoHome.jsp");
            PAGINA_PERFIL.put("Secretaria", "WEB-INF/Paginas/secretariaHome.jsp");
            PAGINA_PERFIL.put("Professor", "WEB-INF/Paginas/professorHome.jsp");
        }
    
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        
        String userName = req.getParameter("userName").toLowerCase();
        String senha = req.getParameter("senha");
        
        Usuario usuario = new UsuarioDAO().buscaUsuario(userName);
        
        if(usuario != null && usuario.getSenha().equals(senha)) {
            
            HttpSession session = req.getSession();
            session.setAttribute("usuarioLogado", usuario);
            
            if(senhaExpirada(usuario) | usuario.getStatusSenha() == 0) {
                return "WEB-INF/Paginas/redefinirSenha.jsp";
            }
     
            return PAGINA_PERFIL.get(usuario.getCargo());
        }
        return "index.jsp";
    }
    
    /**
     * Verifica se a senha do usuario esta vencida
     * @param usuario
     * @return 
     */
    private boolean senhaExpirada(Usuario usuario) {
        Date date = new Date();
        return date.compareTo(usuario.getSenhaData()) >= 0;
    }
}
