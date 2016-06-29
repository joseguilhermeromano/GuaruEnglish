/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.servlet;

import com.guaruenglish.dao.AlunoDAO;
import com.guaruenglish.dao.ContratoDAO;
import com.guaruenglish.dao.ParcelaDAO;
import com.guaruenglish.dao.TurmaDAO;
import com.guaruenglish.model.Aluno;
import com.guaruenglish.model.Contrato;
import com.guaruenglish.model.Parcela;
import com.guaruenglish.model.Turma;
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
            new AlunoDAO().alteraAluno(aluno);
        }
        
        Turma turma = new TurmaDAO().buscaTurma(Integer.parseInt(req.getParameter("idTurma")));
        
        Contrato contrato = new Contrato();
        contrato.setAluno(aluno);
        contrato.setModulo(turma.getModulo());
        contrato.setData(new Date());
        contrato.calculaValorContrato(turma.getModulo().getPreco());
        contrato.parcelarContrato(Integer.parseInt(req.getParameter("qtdParcelas")));
        
        if(new ContratoDAO().cadastrarContrato(contrato)) {
            req.getSession().removeAttribute("alunoContratante");
            req.setAttribute("contrato", contrato);
            
            for(Parcela p : contrato.getParcelas()) {
                new ParcelaDAO().cadastrarParcela(p);
            }
            return "WEB-INF/Paginas/secretaria/contratoSucesso.jsp";
        }
        
        return "WEB-INF/Paginas/secretaria/pagamentoContrato.jsp";
        
    }

    @Override
    public Map perfil() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
