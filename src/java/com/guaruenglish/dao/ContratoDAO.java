/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.dao;

import com.guaruenglish.model.Aluno;
import com.guaruenglish.model.Contrato;
import com.guaruenglish.util.JPAutil;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.RollbackException;

/**
 *
 * @author rafin
 */
public class ContratoDAO {

    EntityManager entityManager = new JPAutil().getEntityManager();

    public void cadastrarContrato(Contrato contrato) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(contrato);
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (RollbackException e) {
            System.out.println("erro:" + e);
        }
    }

    public Contrato buscaContratoPorIdAluno(int id_aluno) {
        try {
            Query query = entityManager.createQuery("SELECT c From Contrato c WHERE c.id_aluno='" + id_aluno + "'");
            Contrato contrato = (Contrato) query.getResultList();
            return contrato;
        } catch (NoResultException e) {
            return null;
        }
    }

    public boolean alteraContrato(Aluno aluno) {
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
