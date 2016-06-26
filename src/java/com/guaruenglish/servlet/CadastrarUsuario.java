/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.servlet;

import com.guaruenglish.service.InterfaceCadastrarUsuario;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luiz Felipe
 */
public class CadastrarUsuario implements Tarefa {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        
        String tipoUsuario = req.getParameter("cargo");
        tipoUsuario = "com.guaruenglish.service.Cadastrar" + tipoUsuario;
        
        try {
            Class<?> tipo = Class.forName(tipoUsuario);
            InterfaceCadastrarUsuario instacia = (InterfaceCadastrarUsuario) tipo.newInstance();
            instacia.cadastrar(req, resp);
        } catch(ClassNotFoundException e ) {
        } catch (InstantiationException ex) {
            Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return "WEB-INF/Paginas/secretaria/cadastrarUsuario.jsp";
        
    }
    
}
