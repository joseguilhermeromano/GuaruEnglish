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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        List<Turma> turmas = new TurmaService().listaTurmas();
        req.setAttribute("turmas", turmas);
        return "WEB-INF/Paginas/secretaria/curso/listaTurmas.jsp";
    }
    
    public String exibeTurmasSemProfessor(HttpServletRequest req, HttpServletResponse resp) {
        List<Turma> turmas = new TurmaService().consultarTurmasSemProfessor();
        req.setAttribute("turmas", turmas);
        return "WEB-INF/Paginas/secretaria/curso/turmaSemProfessor.jsp";     
    }
    
    public String definirProfessorParaTurma(HttpServletRequest req, HttpServletResponse resp) {
        int idTurma = Integer.parseInt(req.getParameter("idTurma"));
        
        Turma turma = new TurmaService().consultaTurma(idTurma);
        //estou usando professor dao pois não há ainda professor service
        List<Professor> professores = new ProfessorDAO().buscaProfessores();
        req.setAttribute("turma", turma);
        req.setAttribute("professores", professores);
        
        return "WEB-INF/Paginas/secretaria/curso/definirProfessorTurma.jsp";
    }
    
    public String associarProfessorTurma(HttpServletRequest req, HttpServletResponse resp) {
        int idProfessor = Integer.parseInt(req.getParameter("idProfessor"));
        int idTurma = Integer.parseInt(req.getParameter("idTurma"));
        
        boolean resposta = new TurmaService().associaProfessorTurma(idProfessor, idTurma);
        if(resposta) {
            req.setAttribute("turma", new TurmaService().consultaTurma(idTurma));
            return "WEB-INF/Paginas/secretaria/curso/professorTurmaSucesso.jsp";
        } else {
            req.setAttribute("falhaAssociarProfessor", "Ocorreu um erro na "
                    + "tentativa de definir um professor para a turma."
                    + "<br>Verifique se o professor possui nivel de experiência adequado");
            return this.definirProfessorParaTurma(req, resp);
        }
    }
    
    public String view(HttpServletRequest req, HttpServletResponse resp) {
        int idTurma = Integer.parseInt(req.getParameter("idTurma"));
        Turma turma = new TurmaService().consultaTurma(idTurma);
        req.setAttribute("turma", turma);
        return "WEB-INF/Paginas/secretaria/curso/turma.jsp";
    }
    
    
    public String editar(HttpServletRequest req, HttpServletResponse resp) {
        int idTurma = Integer.parseInt(req.getParameter("idTurma"));
        Turma turma = new TurmaService().consultaTurma(idTurma);
        if(turma != null) {
            req.setAttribute("turma", turma);
        }
        return "WEB-INF/Paginas/secretaria/curso/editarTurma.jsp";
    }
    
    
    public String atualizar(HttpServletRequest req, HttpServletResponse resp) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        int idTurma = Integer.parseInt(req.getParameter("idTurma"));
        Date dataInicio =  df.parse(req.getParameter("dataInicio"));
        Date dataFim = df.parse(req.getParameter("dataFim"));
        String periodo = req.getParameter("periodo");
        
        boolean resposta = new TurmaService().atualizar(idTurma,dataInicio,dataFim, periodo);
        if(resposta) {
           return this.view(req, resp);
        }
        else {
            req.setAttribute("erroAtualizar", "Não foi possivel atualizar a turma.\n"
                    + "Verifique se a data de inicio não ultrapassa a data de fim.");
            return this.editar(req, resp);
        }
    }
    
    
    @Override
    public Map perfil() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
