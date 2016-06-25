/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.dao;

import com.guaruenglish.model.Parcela;
import com.guaruenglish.util.JPAutil;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.RollbackException;

/**
 *
 * @author rafin
 */
public class ParcelaDAO {

    EntityManager entityManager = new JPAutil().getEntityManager();

    public void cadastrarParcela(Parcela parcela) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(parcela);
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (RollbackException e) {
            System.out.println("erro:" + e);
        }
    }

    public Parcela buscaParcelaIdContrato(int id_contrato) {
        try {
            Query query = entityManager.createQuery("SELECT c From Parcela c WHERE c.id_contrato'" + id_contrato + "'");
            Parcela parcela = (Parcela) query.getResultList();
            return parcela;
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public boolean alteraParcela(Parcela parcela) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(parcela);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return true;
    }
}
