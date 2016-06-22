/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Luiz Felipe
 */
public class JPAutil {
    private static EntityManagerFactory entityManagerFactory = 
            Persistence.createEntityManagerFactory("guaruenglish");
    
    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
    
    
}
