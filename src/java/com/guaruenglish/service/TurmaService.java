/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.service;

import com.guaruenglish.dao.ProfessorDAO;
import com.guaruenglish.dao.TurmaDAO;
import com.guaruenglish.model.Professor;
import com.guaruenglish.model.Turma;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Luiz Felipe
 */
public class TurmaService {
    
    
    public List<Turma> consultarTurmasSemProfessor() {
        return new TurmaDAO().buscarTurmasAtivadasSemProfessor();
    }
    
    
    public boolean associaProfessorTurma(int idProfessor, int idTurma) {
        if(idProfessor == 0 || idTurma == 0)
            return false;
        
        Professor professor = new ProfessorDAO().buscaProfessor(idProfessor);
        Turma turma = new TurmaDAO().buscaTurma(idTurma);
        
        //professor sem carga horaria disponivel
        if(professor.getCargaHorariaDisponivel() == 0)
            return false;
        
        //professor não possui nivel de experiência para ministrar modulos avançados
        if(turma.getModulo().getNivel() == 3 && professor.getNivelExperiencia() < 3) {
            return false;
        }
        
        professor.calculaHorarioDisponivel(turma.getQtdAulas());
        new ProfessorDAO().alteraProfessor(professor);
        
        turma.setProfessor(professor);
        boolean resposta = new TurmaDAO().alteraTurma(turma);
        
        return resposta;    
        
    }
    
    public Turma consultaTurma(int id) {
        return new TurmaDAO().buscaTurma(id);
    }
    
    public List<Turma> listaTurmas() {
        return new TurmaDAO().buscaTurmas();
    }
    
    public boolean atualizar(int idTurma, Date dataInicio, Date dataFim, String periodo) {
        if(dataFim.compareTo(dataInicio) <= 0) {
            return false;
        }
        
        TurmaDAO turmaDao = new TurmaDAO();
        
        Turma turma = turmaDao.buscaTurma(idTurma);
        turma.setDataFim(dataFim);
        turma.setDataInicio(dataInicio);
        turma.setPeriodo(periodo);
        
        return turmaDao.alteraTurma(turma);
 
    }

    
    
}
