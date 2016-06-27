/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.dao;

import com.guaruenglish.model.Modulo;
import com.guaruenglish.util.JPAutil;
import javax.persistence.EntityManager;
import javax.persistence.RollbackException;

/**
 *
 * @author rafin
 */
public class ModuloDAO {
    
    EntityManager entityManager = new JPAutil().getEntityManager();
    
    public boolean inserirModulo(Modulo modulo) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(modulo);
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        } catch(RollbackException ex) {
            entityManager.getTransaction().rollback();
            return false;
        }
    }
    
    
}
