/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.servlet;

import com.guaruenglish.dao.ModuloDAO;
import com.guaruenglish.model.Modulo;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luiz Felipe
 */
public class AtualizarModulo implements Tarefa {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        
        if(req.getParameter("idModulo") != null) {
            Modulo modulo = new ModuloDAO().buscaModulo(Integer.parseInt(req.getParameter("idModulo")));
            req.setAttribute("modulo", modulo);
            return "WEB-INF/Paginas/secretaria/curso/atualizarModulo.jsp";
        } else {
            req.setAttribute("erro", "O código do cursp é obrigatório.");
        } 
        return "WEB-INF/Paginas/secretaria/curso/atualizarModulo.jsp";
    }
    
    @Override
    public Map perfil() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
