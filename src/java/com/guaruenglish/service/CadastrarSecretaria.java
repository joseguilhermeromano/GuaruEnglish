/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.service;

import com.guaruenglish.dao.UsuarioDAO;
import com.guaruenglish.model.Usuario;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luiz Felipe
 */
public class CadastrarSecretaria implements InterfaceCadastrarUsuario {

    @Override
    public boolean cadastrar(HttpServletRequest req, HttpServletResponse resp) {
        String nome = req.getParameter("nome");
        String userName = req.getParameter("userName");
        String senha = req.getParameter("senha");
        String cargo = req.getParameter("cargo");
        String cpf = req.getParameter("cpf");
        
        Usuario secretaria = new Usuario();
        secretaria.setCargo(cargo);
        secretaria.setNome(nome);
        secretaria.setCpf(cpf);
        secretaria.setPerfilAcesso(cargo);
        secretaria.setStatus(1);
        secretaria.setSenha(senha);
        Date senhaData = new Date();
        secretaria.setSenhaData(senhaData);
        secretaria.setStatusSenha(0);
        secretaria.setUserName(userName);
        
        return new UsuarioDAO().cadastrarUsuario(secretaria);
    }
    
}
