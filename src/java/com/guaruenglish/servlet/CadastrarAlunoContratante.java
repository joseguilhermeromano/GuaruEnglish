/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.servlet;

import com.guaruenglish.service.CadastrarAluno;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luiz Felipe
 */
public class CadastrarAlunoContratante implements Tarefa {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        CadastrarAluno novoAluno = new CadastrarAluno();
        if(novoAluno.cadastrar(req, resp)){
            return "WEB-INF/Paginas/secretaria/contrarModulo.jsp";
        } else {
            return "WEB-INF/Paginas/secretaria/cadastrarAlunoContratante";
        }
        
    }

    @Override
    public Map perfil() {
       Map map = new HashMap();
       map.put("Secretaria",true);
       
       return map;
    }
    
}
