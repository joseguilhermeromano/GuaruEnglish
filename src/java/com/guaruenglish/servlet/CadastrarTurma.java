/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.servlet;

import com.guaruenglish.dao.CursoDAO;
import com.guaruenglish.dao.ModuloDAO;
import com.guaruenglish.model.Curso;
import com.guaruenglish.model.Modulo;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luiz Felipe
 */
public class CadastrarTurma implements Tarefa {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        String pagina = "asd";
        if(req.getParameter("idmodulo") == null) {
            pagina = acesso(req, resp);
        }
        
        return pagina;     
    }
    
    /**
     * Método para montar a 
     * pagina nos primeiros acessos
     * @param req
     * @param resp
     * @return 
     */
    private String acesso(HttpServletRequest req, HttpServletResponse resp) {
        List<Curso> cursos = new CursoDAO().consultaCursos();
        req.setAttribute("cursos", cursos);
        return "WEB-INF/Paginas/secretaria/cadastrarTurma.jsp";
    }
    
    
    
    
}
