/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.servlet;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luiz Felipe
 */
public class Logoff implements Tarefa {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        req.getSession().removeAttribute("usuarioLogado");
        req.getSession().invalidate();
        return "index.jsp";
    }

    @Override
   public Map perfil() {
       Map map = new HashMap();
       map.put("Aluno",true);
       map.put("Professor",true);
       map.put("Secretaria",true);
       
       return map;
    }
}
