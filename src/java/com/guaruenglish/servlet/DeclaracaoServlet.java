/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.servlet;

import com.guaruenglish.model.Declaracao;
import com.guaruenglish.service.DeclaracaoService;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luiz Felipe
 */
public class DeclaracaoServlet implements Tarefa{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String declaracoesNaoAnalisadas(HttpServletRequest req, HttpServletResponse resp) {
        List<Declaracao> declaracoes = 
                new DeclaracaoService().consultaDeclaracoesNaoResolvidas();
        
        if(declaracoes != null) {
            req.setAttribute("declaracoes", declaracoes);
        } else {
            req.setAttribute("declaracaoNull", 
                    "Não há declarações para serem emitidas");
        }
        
        return "WEB-INF/Paginas/declaracao/listaDeclaracaoNaoResolvidas.jsp";
    }
    
    
    
    
    
    @Override
    public Map perfil() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
