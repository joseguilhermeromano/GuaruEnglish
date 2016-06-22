/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.dao;

import com.guaruenglish.model.Aluno;
import com.guaruenglish.util.JPAutil;
import javax.persistence.EntityManager;
import javax.persistence.RollbackException;

/**
 *
 * @author Aluno
 */
public class AlunoDAO {
     EntityManager entityManager = new JPAutil().getEntityManager();
    public void cadastrarAluno(Aluno aluno) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(aluno);
            entityManager.getTransaction().commit();
            entityManager.close();
        }catch(RollbackException e) {
            System.out.println("erro:"+e);
        }
    }
    
}
