/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.servlet;

import com.guaruenglish.dao.AlunoDAO;
import com.guaruenglish.service.AlunoService;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Luiz Felipe
 */
public class CadastrarAlunoContratante implements Tarefa {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        AlunoService novoAluno = new AlunoService();
        if(novoAluno.cadastrar(req, resp)) {
            
            HttpSession session = req.getSession(true);
            session.setAttribute("alunoContratante", new AlunoDAO().consultaUltimoAlunoCadastrado());
            return "WEB-INF/Paginas/secretaria/contratarModulo.jsp";
        } else {
            return "WEB-INF/Paginas/secretaria/cadastrarAlunoContratante.jsp";
        }
    }

    @Override
    public Map perfil() {
       Map map = new HashMap();
       map.put("Secretaria",true);
       
       return map;
    }
    
}
