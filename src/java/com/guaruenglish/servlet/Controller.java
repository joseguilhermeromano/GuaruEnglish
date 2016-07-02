/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Luiz Felipe
 */
public class Controller extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String tarefa = req.getParameter("tarefa");
                
        tarefa = "com.guaruenglish.servlet." + tarefa;
        String nomeMetodo = (req.getParameter("metodo") == null) ? "executa" : req.getParameter("metodo");
        System.out.println("nome método:" + nomeMetodo);
        try {
            Class<?> tipo = Class.forName(tarefa);
            Tarefa instancia = (Tarefa) tipo.newInstance();
            
            Method metodo = tipo.getDeclaredMethod(nomeMetodo, HttpServletRequest.class, HttpServletResponse.class);
            String pagina = (String) metodo.invoke(instancia, req,resp);
            System.out.println("Pagina: " + pagina);
            
            RequestDispatcher requestDispatcher = req.getRequestDispatcher(pagina);
            requestDispatcher.forward(req, resp);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
