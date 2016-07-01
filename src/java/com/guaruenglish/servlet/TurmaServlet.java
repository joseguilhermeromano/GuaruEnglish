/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.servlet;

import com.guaruenglish.dao.ProfessorDAO;
import com.guaruenglish.model.Professor;
import com.guaruenglish.model.Turma;
import com.guaruenglish.service.TurmaService;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luiz Felipe
 */
public class TurmaServlet implements Tarefa {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        return "";
    }
    
    public String exibeTurmasSemProfessor(HttpServletRequest req, HttpServletResponse resp) {
        List<Turma> turmas = new TurmaService().consultarTurmasSemProfessor();
        req.setAttribute("turmas", turmas);
        return "WEB-INF/Paginas/secretaria/curso/turmaSemProfessor.jsp";
    }
    
    public String definirProfessorParaTurma(HttpServletRequest req, HttpServletResponse resp) {
        int idTurma = Integer.parseInt(req.getParameter("idTurma"));
        Turma turma = new TurmaService().consultaTurma(idTurma);
        // estou usando professor dao pois não há ainda professor service
        List<Professor> professores = new ProfessorDAO().buscaProfessores();
        req.setAttribute("turma", turma);
        req.setAttribute("professores", professores);
        
        return "WEB-INF/Paginas/secretaria/curso/definirProfessorTurma.jsp";
    }
    
    
    @Override
    public Map perfil() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
