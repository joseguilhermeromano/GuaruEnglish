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
        
        //Falta Colocar a condição para verficar se o professor pode lecionar essa turma.
        // para isso é melhor trocar o nivel de experiencia do professor para int
        
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
    
    
    private Object TurmaDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
