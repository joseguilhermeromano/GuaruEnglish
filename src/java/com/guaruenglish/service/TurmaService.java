/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.service;

import com.guaruenglish.dao.TurmaDAO;
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
    
    public Turma consultaTurma(int id) {
        return new TurmaDAO().buscaTurma(id);
    }
    
    
}
