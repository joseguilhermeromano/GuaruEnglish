/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.servlet;

import com.guaruenglish.model.Aluno;
import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luiz Felipe
 */
public class FinalizarContrato implements Tarefa {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        Aluno aluno = (Aluno) req.getSession().getAttribute("alunoContratante");
        if(aluno.getMatricula() == null) {
            aluno.geraMatricula(new Date());
        }
        
        
        
    }

    @Override
    public Map perfil() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
