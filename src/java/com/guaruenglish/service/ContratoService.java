/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.service;

import com.guaruenglish.dao.ContratoDAO;
import com.guaruenglish.dao.ParcelaDAO;
import com.guaruenglish.model.Contrato;
import java.util.List;

/**
 *
 * @author Luiz Felipe
 */
public class ContratoService {
 
    public List<Contrato> listaContratos() {
        return new ContratoDAO().buscaContratos();
    }
    
    public Contrato exibeContrato(int id) {
        Contrato contrato = new ContratoDAO().buscaContrato(id);
        return contrato;
    }
}
