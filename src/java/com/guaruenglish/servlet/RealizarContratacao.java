/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.servlet;

import com.guaruenglish.dao.AlunoDAO;
import com.guaruenglish.model.Aluno;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luiz Felipe
 */
public class RealizarContratacao implements Tarefa {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        //caso a opção escolhida na view for buscar aluno.
        if(req.getParameter("cpf") != null) {
            Aluno aluno = new AlunoDAO().buscaAlunoPorCPF(req.getParameter("cpf"));
            if(aluno != null) {
                req.setAttribute("aluno", aluno);
                return "WEB-INF/Paginas/secretaria/confirmaDados.jsp";
            } else {
                req.setAttribute("erro", "usuario não encontrado");
                return "WEB-INF/Paginas/secretaria/realizarContratacao.jsp";
            }   
        }
        
        //caso o usuário escolha a opção para cadastrar novo aluno contratante na view
        return "WEB-INF/Paginas/secretaria/cadastrarAlunoContratante.jsp";
    }

    @Override
    public Map perfil() {
       Map map = new HashMap();
       map.put("Secretaria",true);
       
       return map;
    }
    
}
