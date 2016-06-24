/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.servlet;

import com.guaruenglish.model.Aluno;
import com.guaruenglish.model.Professor;
import com.guaruenglish.dao.AlunoDAO;
import com.guaruenglish.dao.ProfessorDAO;
import com.guaruenglish.dao.UsuarioDAO;
import com.guaruenglish.model.Usuario;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            PAGINA_PERFIL.put("aluno", "alunoHome.jsp");
            PAGINA_PERFIL.put("secretaria", "secretariaHome.jsp");
            PAGINA_PERFIL.put("professor", "professorHome.jsp");
        }
    
    
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        
        String userName = req.getParameter("userName").toLowerCase();
        String senha = req.getParameter("senha");
        
        Usuario usuario = new UsuarioDAO().buscaUsuario(userName);
        
        if(usuario != null) {
            if(usuario.getSenha().equals(senha)) {
                try {
                    Class<?> user = Class.forName(usuario.getCargo());
                    user = (Class<?>) mapaDao(usuario).get(usuario.getCargo());
                    
                    HttpSession session = req.getSession();
                    session.setAttribute("usuarioLogado", user);
                    
                    return PAGINA_PERFIL.get(usuario.getCargo());
                    
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return "index.jsp";
    }
    
    private Map mapaDao(Usuario usuario) {
        Map mapaDao = new HashMap();
        mapaDao.put("secretaria", new UsuarioDAO().buscaUsuario(usuario.getId()));
        mapaDao.put("aluno", new AlunoDAO().buscaAluno(usuario.getId()));
        mapaDao.put("professor", new ProfessorDAO().buscaProfessor(usuario.getId()));
        return mapaDao;
    }
    
    
     
    
    
    
}
