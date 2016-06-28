/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.servlet;

import com.guaruenglish.dao.CursoDAO;
import com.guaruenglish.dao.ModuloDAO;
import com.guaruenglish.dao.TurmaDAO;
import com.guaruenglish.model.Curso;
import com.guaruenglish.model.Modulo;
import com.guaruenglish.model.Turma;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luiz Felipe
 */
public class ContratarModulo implements Tarefa{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        
        List<Curso> cursos = new CursoDAO().consultaCursos();
        req.setAttribute("cursos", cursos);
        
        if(req.getParameter("idCurso") != null) {
            Curso curso = new CursoDAO().consultaCurso(Integer.parseInt(req.getParameter("idCurso")));
            req.setAttribute("curso", curso);
            req.setAttribute("modulos", curso.getModulos());
        }
        
        if(req.getParameter("idModulo") != null) {
            Modulo modulo = new ModuloDAO().buscaModulo(Integer.parseInt(req.getParameter("idModulo")));
            req.setAttribute("modulos", modulo);
            req.setAttribute("turmas", modulo.getTurmas());
        }
        
        if(req.getParameter("idTurma") != null) {
            Turma turma = new TurmaDAO().buscaTurma(Integer.parseInt("idTurma"));
            req.setAttribute("turma", turma);
            return "WEB-INF/Paginas/secretaria/pagamentoContrato.jsp";
        }
        
        return "WEB-INF/Paginas/secretaria/contratarModulo.jsp";
    }

    @Override
    public Map perfil() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
