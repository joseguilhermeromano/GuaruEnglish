/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.dao;

import com.guaruenglish.model.Professor;
import com.guaruenglish.util.JPAutil;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Luiz Felipe
 */
public class ProfessorDAO {
    
    EntityManager entityManager = new JPAutil().getEntityManager();
    
    public Professor buscaProfessor(int id) {
        
        try {
            Query query = entityManager.createQuery
                ("SELECT p FROM Professor p WHERE p.id='"+id+"'");
            Professor professor = (Professor)query.getSingleResult();
            return professor;
        } catch(NoResultException e) {
            return null;
        }
    }
    
    
}
