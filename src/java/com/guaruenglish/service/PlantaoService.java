/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.service;

import com.guaruenglish.dao.PlantaoDuvidaDAO;
import com.guaruenglish.model.PlantaoDuvida;
import com.guaruenglish.model.Professor;
import java.util.Date;

/**
 *
 * @author Luiz Felipe
 */
public class PlantaoService {
    
    public boolean inserirPlantao(Date data, float qtdHoras, Professor professor) {
        PlantaoDuvida plantao = new PlantaoDuvida();
        plantao.setData(data);
        plantao.setQtdhoras(qtdHoras);
        plantao.setProfessor(professor);
        
        if(data.compareTo(new Date()) < 0) {
            return false;
        }
        
        if(qtdHoras > professor.getCargaHorariaDisponivel()) {
            return false;
        }
        
        return new PlantaoDuvidaDAO().inserirPlantaoDuvida(plantao);
        
    }
}
