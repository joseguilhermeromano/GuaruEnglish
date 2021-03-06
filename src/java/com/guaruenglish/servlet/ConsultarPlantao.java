/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.servlet;

import com.guaruenglish.dao.PlantaoDuvidaDAO;
import com.guaruenglish.dao.ProfessorDAO;
import com.guaruenglish.dao.UsuarioDAO;
import com.guaruenglish.model.PlantaoDuvida;
import com.guaruenglish.model.Professor;
import com.guaruenglish.model.Usuario;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.guaruenglish.service.UsuarioService;

/**
 *
 * @author Luiz Felipe
 */
public class ConsultarPlantao implements Tarefa {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        
        
        List<PlantaoDuvida> plantao;
        HttpSession session = req.getSession();
        Usuario usr = (Usuario) session.getAttribute("usuarioLogado");
        Map map = new HashMap();
        
        int id;
        if(usr.getPerfilAcesso().equals("Secretaria")) {
            id = Integer.parseInt(req.getParameter("idProfessor"));
        } else {
            id = usr.getId();
        }
        
        
        
        if(req.getParameter("dataInicial") != null | req.getParameter("dataFinal") != null) {     
            plantao = new PlantaoDuvidaDAO().buscaPlantaoPorPeriodo(req.getParameter("dataInicial"), req.getParameter("dataFinal"),id);
        }
        else {
            return "WEB-INF/Paginas/secretaria/error.jsp";   
            
        }
        req.setAttribute("plantao", plantao);
        return ("WEB-INF/Paginas/professor/verPlantao.jsp");
        
    }

    @Override
    public Map perfil() {
       Map map = new HashMap();
       map.put("Professor",true);
       map.put("Secretaria",true);
       
       return map;
    }
    
}
