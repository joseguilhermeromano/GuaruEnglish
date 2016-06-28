/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.servlet;

import com.guaruenglish.dao.TurmaDAO;
import com.guaruenglish.model.Contrato;
import com.guaruenglish.model.Turma;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luiz Felipe
 */
public class PagamentoContrato implements Tarefa {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        
        Turma turma = new TurmaDAO().buscaTurma(Integer.parseInt(req.getParameter("idTurma")));
        req.setAttribute("turma", turma);
        req.setAttribute("valorContrato", new Contrato().calculaValorContrato(turma.getModulo().getPreco()));
        
        
        return "WEB-INF/Paginas/secretaria/pagamentoContrato.jsp";
        
        
        
    }

    @Override
    public Map perfil() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
