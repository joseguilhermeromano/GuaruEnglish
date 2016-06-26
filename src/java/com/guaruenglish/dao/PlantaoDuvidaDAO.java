/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.dao;

import com.guaruenglish.model.PlantaoDuvida;
import com.guaruenglish.model.Usuario;
import com.guaruenglish.util.JPAutil;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.RollbackException;

/**
 *
 * @author rafin
 */
public class PlantaoDuvidaDAO {
    EntityManager entityManager = new JPAutil().getEntityManager();
    
    public List<PlantaoDuvida> buscaPlantaoPorPeriodo(Date dataInicial, Date dataFinal,String userName ) {
        try {
            Query query = entityManager.createQuery
                ("SELECT u From PlantãoDuvida u WHERE u.userName='"+userName+"' and u.data BETWEEN date("+dataInicial+") AND "
                        + "date("+dataFinal+")  ");
            List<PlantaoDuvida> plantao = query.getResultList();
            return plantao;
        } catch(NoResultException e ){
            return null;
        }
        
    }
    
    public void alteraPlantaoDuvida(PlantaoDuvida plantao) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(plantao);
            entityManager.getTransaction().commit();
        } catch(Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
     public boolean cadastrarPlantaoDuvida(PlantaoDuvida plantao) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(plantao);
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        } catch(RollbackException ex) {
            entityManager.getTransaction().rollback();
            return false;
        }
    }
    
}
