/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.guaruenglish.servlet;

import com.guaruenglish.model.Boletim;
import com.guaruenglish.service.BoletimService;
import com.guaruenglish.util.JPAutil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rafin
 */
@WebServlet(name = "BoletimServlet", urlPatterns = {"/BoletimServlet"})
public class BoletimServlet implements Tarefa {
    EntityManager entityManager = new JPAutil().getEntityManager();

    

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public String consultaBoletinsTurma(HttpServletRequest req, HttpServletResponse resp) {
        int idTurma = Integer.parseInt(req.getParameter("idTurma"));
        List<Boletim> boletim = new BoletimService().consultaBoletinsTurma(idTurma);
        //session.setAttribute("tdefinirBoletimurma", turma);
        req.setAttribute("boletim", boletim);    
        return "WEB-INF/Paginas/professor/definirBoletim.jsp";
    }
    
    public String alteraBoletim(HttpServletRequest req,
    HttpServletResponse res){
       String[] parcial = req.getParameterValues("parcial");
       String[] notasfinais = req.getParameterValues("final");
       String[] faltas = req.getParameterValues("faltas");  
       String[] id = req.getParameterValues("id");
       Boletim boletim = new Boletim();
       
       for(int i = 0; i < parcial.length; i++){
           int idBoletim = Integer.parseInt(id[i]);
           int faltasC = Integer.parseInt(faltas[i]);
           float parcialD = Float.parseFloat(parcial[i]);
           float finalD = Float.parseFloat(notasfinais[i]);
           
           boletim.setId(idBoletim);
           boletim.setConceitoParcial(parcialD);
           boletim.setConceitoFinal(finalD);
           boletim.setQtdFaltas(faltasC);
           new BoletimService().alteraBoletim(boletim);
           //MyEntity e2 = em.find(MyEntity.class, idEntidade);
           
           
       }
       return "WEB-INF/Paginas/professor/definirBoletim.jsp";
    }
    
    
    @Override
     public Map perfil() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
