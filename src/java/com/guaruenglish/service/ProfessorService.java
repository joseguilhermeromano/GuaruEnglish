/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.service;

import com.guaruenglish.dao.ProfessorDAO;
import com.guaruenglish.model.Professor;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luiz Felipe
 */
public class ProfessorService implements UsuarioService {

    @Override
    public boolean cadastrar(HttpServletRequest req, HttpServletResponse resp) {
        String nome = req.getParameter("nome");
        String userName = req.getParameter("userName");
        String senha = req.getParameter("senha");
        String cargo = req.getParameter("cargo");
        String especialidade = req.getParameter("especialidade");
        String nivelExperiencia = req.getParameter("experiencia");
        float cargaHoraria = Float.parseFloat(req.getParameter("cargaHoraria"));
        String cpf = req.getParameter("cpf");
        
        
        Professor professor = new Professor();
        professor.setCargaHoraria(cargaHoraria);
        professor.setCargo(cargo);
        professor.setCpf(cpf);
        professor.setNivelExperiencia(nivelExperiencia);
        professor.setNome(nome);
        professor.setPerfilAcesso(cargo);
        professor.setSenha(senha);
        Date senhaData = new Date();
        professor.setSenhaData(senhaData);
        professor.setStatusSenha(0);
        professor.setStatus(1);
        professor.setUserName(userName);
        professor.setEspecialidade(especialidade);
        
        return new ProfessorDAO().cadastrarProfessor(professor);
        
    }
    
}
