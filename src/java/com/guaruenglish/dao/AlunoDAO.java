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
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.RollbackException;

/**
 *
 * @author Aluno
 */
public class AlunoDAO {

    EntityManager entityManager = new JPAutil().getEntityManager();

    public boolean cadastrarAluno(Aluno aluno) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(aluno);
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        } catch (RollbackException e) {
            System.out.println("erro:" + e);
            entityManager.getTransaction().rollback();
            return false;
        }
    }
    
    //busca aluno por CPF?
    public Aluno buscaAluno(int id) {
        try {
            Query query = entityManager.createQuery
                ("SELECT a From Aluno a WHERE a.id='"+id+"'");
            Aluno aluno = (Aluno) query.getSingleResult();
            return aluno;
        } catch(NoResultException e ){
            return null;
        }
    }
    
    
    public Aluno buscaAlunoPorMatricula(int matricula) {
        Aluno aluno = null;
        Query query = entityManager.createQuery("SELECT p FROM Aluno p WHERE p.matricula like '" + matricula + "'");
        aluno = (Aluno) query.getSingleResult();
        return aluno;
    }
    
    public Aluno buscaAlunoPorCPF(String cpf) {
        try {
         
            Query query = entityManager.createQuery
                ("SELECT a FROM Aluno a WHERE a.matricula a.cpf='"+cpf+"'");
            Aluno aluno = (Aluno) query.getSingleResult();
            return aluno;
        } catch(NoResultException ex) {
            return null;
        }
    }

    public boolean alteraAluno(Aluno aluno) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(aluno);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return true;
    }
}
