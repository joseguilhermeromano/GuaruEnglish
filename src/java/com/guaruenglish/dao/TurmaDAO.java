/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.dao;

import com.guaruenglish.model.Turma;
import com.guaruenglish.util.JPAutil;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.RollbackException;

/**
 *
 * @author rafin
 */
public class TurmaDAO {

    EntityManager entityManager = new JPAutil().getEntityManager();

    public void cadastrarTurma(Turma turma) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(turma);
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (RollbackException e) {
            System.out.println("erro:" + e);
        }
    }

    public Turma buscaTurmaPorIdModulo(int id_modulo) {
        try {
            Query query = entityManager.createQuery("SELECT t From Turma t WHERE t.id_modulo'" + id_modulo + "'");
            Turma turma = (Turma) query.getResultList();
            return turma;
        } catch (NoResultException e) {
            return null;
        }
    }

    public Turma buscaTurmaPorIdProfessor(int id_professor) {
        try {
            Query query = entityManager.createQuery("SELECT c From Parcela c WHERE c.id_modulo'" + id_professor + "'");
            Turma turma = (Turma) query.getResultList();
            return turma;
        } catch (NoResultException e) {
            return null;
        }
    }

    public boolean alteraTurma(Turma turma) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(turma);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return true;
    }
}
