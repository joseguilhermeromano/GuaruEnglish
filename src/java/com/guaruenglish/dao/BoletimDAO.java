/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.dao;

import com.guaruenglish.model.Boletim;
import com.guaruenglish.util.JPAutil;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Luiz Felipe
 */
public class BoletimDAO {
    
    EntityManager entityManager = new JPAutil().getEntityManager();
    
    public void insereBoletim(Boletim boletim) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(boletim);
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch(Exception e) {
            entityManager.getTransaction().rollback();
        }
    }
    
    public Boletim consultaBoletim(int idAluno, int idTurma) {
        try {
            Query query = entityManager.createQuery("SELECT b FROM Boletim b "
                    + "WHERE b.turma.id='"+idTurma+"' "
                    + "AND b.aluno.id='"+idAluno+"'");
            Boletim boletim = (Boletim) query.getSingleResult();
            return boletim;
        } catch(Exception e) {
            return null;
        }
    }
    
    public List<Boletim> consultaBoletimTurma(int ) {
        
    }
    
}
