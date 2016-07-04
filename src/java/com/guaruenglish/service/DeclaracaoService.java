/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.service;

import com.guaruenglish.dao.DeclaracaoDAO;
import com.guaruenglish.model.Declaracao;
import java.util.List;

/**
 *
 * @author Luiz Felipe
 */
public class DeclaracaoService {
    
    public List<Declaracao> consultaDeclaracoesNaoResolvidas() {
        List<Declaracao> declaracoes =  new DeclaracaoDAO().buscaDeclaracoesNaoResolvidas();
        if(declaracoes == null) System.out.print("é null");
        return declaracoes;
    }
}
