/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.service;

import com.guaruenglish.dao.AlunoDAO;
import com.guaruenglish.model.Aluno;
import java.util.Date;
import javafx.scene.chart.PieChart.Data;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luiz Felipe
 */
public class AlunoService implements UsuarioService {

    @Override
    public boolean cadastrar(HttpServletRequest req, HttpServletResponse resp) {
        String nome = req.getParameter("nome");
        String userName = req.getParameter("userName");
        String senha = req.getParameter("senha");
        String perfilAcesso = req.getParameter("perfilAcesso");
        String cpf = req.getParameter("cpf");

        Aluno aluno = new Aluno();
        aluno.setCargo(null);
        aluno.setNome(nome);
        aluno.setCpf(cpf);
        aluno.setPerfilAcesso(perfilAcesso);
        aluno.setStatus(0);
        aluno.setSenha(senha);
        Date senhaData = new Date();
        aluno.setSenhaData(senhaData);
        aluno.setStatusSenha(0);
        aluno.setUserName(userName);
        
        return new AlunoDAO().cadastrarAluno(aluno);
        
    }
    
}
