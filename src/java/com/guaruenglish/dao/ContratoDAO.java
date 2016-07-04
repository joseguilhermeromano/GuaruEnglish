/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.dao;

import com.guaruenglish.model.Aluno;
import com.guaruenglish.model.Contrato;
import com.guaruenglish.model.Turma;
import com.guaruenglish.util.JPAutil;
import java.util.List;
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

    public boolean cadastrarContrato(Contrato contrato) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(contrato);
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        } catch (Exception e) {
            System.out.println("erro:" + e);
            return false;
        }
    }

    public  List<Contrato> buscaContratoPorIdAluno(int id_aluno) {
        try {
            Query query = entityManager.createQuery("SELECT c From Contrato c WHERE c.id_aluno='" + id_aluno + "'");
            List<Contrato> contrato =query.getResultList();
            return contrato;
        } catch (NoResultException e) {
            return null;
        }
    }

    public boolean alteraContrato(Contrato contrato) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(contrato);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return true;
    }
    
    public List<Contrato> buscaContratos() {
        try {
            Query query = entityManager.createQuery("FROM Contrato c");
            List<Contrato> contratos = query.getResultList();
            return contratos;
        } catch(Exception e) {
            return null;
        }
    }
    
    public Contrato buscaContrato(int id) {
        try {
            Query query = entityManager.createQuery
        ("SELECT c FROM Contrato c WHERE c.id='"+id+"'");
            Contrato contrato = (Contrato) query.getSingleResult();
            return contrato;
        } catch(Exception e) {
            return null;
        }
    }
    
    
}
