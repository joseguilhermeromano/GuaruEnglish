/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.dao;

import com.guaruenglish.model.Aluno;
import com.guaruenglish.util.JPAutil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.RollbackException;

/**
 *
 * @author Aluno
 */
public class AlunoDAO {
     EntityManager entityManager = new JPAutil().getEntityManager();
    public void cadastrarAluno(Aluno aluno) {
        try {
            entityManager.setProperty(null, aluno.getCargo());
            entityManager.getTransaction().begin();
            entityManager.persist(aluno);
            entityManager.getTransaction().commit();
            entityManager.close();
        }catch(RollbackException e) {
            System.out.println("erro:"+e);
        }
    }
    public Aluno buscaAluno(int matricula) {
            Aluno aluno = null;
            Query query = entityManager.createQuery
                ("SELECT p FROM Aluno p WHERE p.matricula like '"+matricula+"'");
            aluno = (Aluno) query.getSingleResult();
            return aluno;     
    }
    
    public boolean AlteraAluno(Aluno aluno){
        /*
        Aluno alunoaux = entityManager.find(Aluno.class, aluno.getId());
        try {
            entityManager.getTransaction().begin();
            aluno.
        } catch (Exception e) {
        } 
        */
        return true; 
    }
}
