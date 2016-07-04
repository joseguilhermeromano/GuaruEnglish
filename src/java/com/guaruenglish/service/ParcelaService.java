/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.service;

import com.guaruenglish.dao.ParcelaDAO;
import com.guaruenglish.model.Parcela;
import java.util.List;

/**
 *
 * @author Luiz Felipe
 */
public class ParcelaService {
    
    public List<Parcela> consultaParcelasContrato(int idContrato) {
        return new ParcelaDAO().buscaParcelaIdContrato(idContrato);
    }
    
    public Parcela consultaParcela(int id) {
        return new ParcelaDAO().buscaParcela(id);
    }
    
    public boolean darBaixaParcela(int id) {
        ParcelaDAO parcelaDao = new ParcelaDAO();
        Parcela parela = parcelaDao.buscaParcela(id);
        parela.setStatus(1);
        return parcelaDao.alteraParcela(parela);
        
    }
    
}
