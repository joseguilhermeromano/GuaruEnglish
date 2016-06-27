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
public class CadastrarAluno implements InterfaceCadastrarUsuario {

    @Override
    public boolean cadastrar(HttpServletRequest req, HttpServletResponse resp) {
        String nome = req.getParameter("nome");
        String userName = req.getParameter("userName");
        String senha = req.getParameter("senha");
        String cargo = req.getParameter("cargo");
        String cpf = req.getParameter("cpf");

        Aluno aluno = new Aluno();
        aluno.setCargo(cargo);
        aluno.setNome(nome);
        aluno.setCpf(cpf);
        aluno.setPerfilAcesso(cargo);
        aluno.setStatus(1);
        aluno.setSenha(senha);
        Date senhaData = new Date();
        aluno.setSenhaData(senhaData);
        aluno.setStatusSenha(0);
        aluno.setUserName(userName);
        
        return new AlunoDAO().cadastrarAluno(aluno);
        
    }
    
}
