/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.servlet;

import com.guaruenglish.model.Professor;
import com.guaruenglish.service.PlantaoService;
import com.guaruenglish.service.ProfessorService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luiz Felipe
 */
public class PlantaoServlet implements Tarefa {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public String professorPlantao(HttpServletRequest req, 
            HttpServletResponse resp) {
        req.setAttribute("professores", new ProfessorService().
                consultaProfessorHorarioDisponivel());
        
        return "WEB-INF/Paginas/plantao/professoresPlantao.jsp";
    }
    
    
    public String definirPlantao(HttpServletRequest req, 
            HttpServletResponse resp) {
        int idProfessor = Integer.parseInt(req.getParameter("idProfessor"));
        req.setAttribute("professor", 
                new ProfessorService().consultaProfessor(idProfessor));
        
        return "WEB-INF/Paginas/plantao/definirPlantao.jsp";
        
        
    }
    
    public String inserirPlantao(HttpServletRequest req, 
            HttpServletResponse resp) throws ParseException {
        Date data = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("data"));
        float qtdHoras  = Float.parseFloat(req.getParameter("qtdHoras"));
        int idProfessor = Integer.parseInt(req.getParameter("idProfessor"));
        Professor professor = new ProfessorService().consultaProfessor(idProfessor);
        
        boolean resposta = new PlantaoService().inserirPlantao(data, qtdHoras, professor);
        if(resposta) {
            return "WEB-INF/Paginas/plantao/plantaoSucesso.jsp";
        } else {
            req.setAttribute("erro", "Ocorreu um erro ao definir o plantão de duvidas");
            return this.definirPlantao(req, resp);
        }
        
    }
    

    @Override
    public Map perfil() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
