/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.servlet;

import com.guaruenglish.service.ParcelaService;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luiz Felipe
 */
public class ParcelaServlet implements Tarefa {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String darBaixaParcela(HttpServletRequest req, HttpServletResponse resp) {
       int idParcela = Integer.parseInt(req.getParameter("idParcela"));
       boolean resposta = new ParcelaService().darBaixaParcela(idParcela);
       req.setAttribute("contrato", new ParcelaService().consultaParcela(idParcela).getContrato());
       
       if(!resposta) {
           req.setAttribute("erroBaixaParcela", "Ocorreu um erro ao dar baixa na parcela");
       }
       
       return "WEB-INF/Paginas/secretaria/contrato/contrato.jsp";
    }
    
    
    
    @Override
    public Map perfil() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
