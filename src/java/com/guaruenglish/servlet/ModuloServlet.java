/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.servlet;

import com.guaruenglish.model.Modulo;
import com.guaruenglish.model.Turma;
import com.guaruenglish.service.ModuloService;
import com.guaruenglish.service.TurmaService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aluno
 */
public class ModuloServlet implements Tarefa{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map perfil() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public String view(HttpServletRequest req, HttpServletResponse resp) {
        int idModulo = Integer.parseInt(req.getParameter("idModulo"));
        Modulo modulo = new ModuloService().buscaModulo(idModulo);
        req.setAttribute("modulo", modulo);
        return "WEB-INF/Paginas/secretaria/curso/modulo.jsp";
    }
   
   
}
