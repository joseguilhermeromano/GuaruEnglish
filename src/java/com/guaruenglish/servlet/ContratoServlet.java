/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.servlet;

import com.guaruenglish.model.Contrato;
import com.guaruenglish.model.Parcela;
import com.guaruenglish.service.ContratoService;
import com.guaruenglish.service.ParcelaService;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luiz Felipe
 */
public class ContratoServlet implements Tarefa {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("contratos", new ContratoService().listaContratos());
        return "WEB-INF/Paginas/secretaria/contrato/listaContratos.jsp";
    }
    
    public String view(HttpServletRequest req, HttpServletResponse resp) {
        int idContrato = Integer.parseInt(req.getParameter("idContrato"));
        Contrato contrato = new ContratoService().exibeContrato(idContrato);
        req.setAttribute("contrato", contrato);
        return "WEB-INF/Paginas/secretaria/contrato/contrato.jsp";
        
    }
    

    @Override
    public Map perfil() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
