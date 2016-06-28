/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.servlet;

import com.guaruenglish.dao.UsuarioDAO;
import com.guaruenglish.model.Usuario;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luiz Felipe
 */
public class ConsultarUsuarios implements Tarefa {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        List<Usuario> usuarios;
        if(req.getParameter("cpf") != null | req.getParameter("nome") != null) {     
            usuarios = new UsuarioDAO().consultarUsuarios(req.getParameter("nome"),req.getParameter("cpf"));
        }
        else {
            usuarios = new UsuarioDAO().consultarUsuarios();    
        }
        req.setAttribute("usuarios", usuarios);
        return "WEB-INF/Paginas/secretaria/consultarUsuarios.jsp";
    }

    @Override
    public Map perfil() {
       Map map = new HashMap();
       map.put("Secretaria",true);
       
       return map;
    }
}
