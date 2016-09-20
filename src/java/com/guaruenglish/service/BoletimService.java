/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.guaruenglish.service;

import com.guaruenglish.dao.BoletimDAO;
import com.guaruenglish.model.Boletim;
import java.io.IOException;
import java.io.PrintWriter;
import static java.util.Collections.list;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rafin
 */
@WebServlet(name = "BoletimService", urlPatterns = {"/BoletimService"})
public class BoletimService extends HttpServlet {

   

   public List<Boletim> consultaBoletinsTurma(int idTurma ){
       return new BoletimDAO().consultaBoletinsTurma(idTurma);
   }
   
   public boolean alteraBoletim(Boletim boletim){
       return new BoletimDAO().alteraBoletim(boletim);        
    }
   public List<Boletim> consultaBoletinsAluno(int idAluno){
        return new BoletimDAO().consultaBoletinsAluno(idAluno);
    }
   
}
