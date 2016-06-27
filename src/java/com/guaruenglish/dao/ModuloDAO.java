/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.dao;

import com.guaruenglish.model.Modulo;
import com.guaruenglish.util.JPAutil;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.EntityManager;
import javax.persistence.RollbackException;

/**
 *
 * @author rafin
 */
public class ModuloDAO {
    EntityManager entityManager = new JPAutil().getEntityManager();
    
    public  Modulo buscaModulo(int id) {
        try {
            Query query = entityManager.createQuery("SELECT c From Modulo c WHERE c.id='" + id + "'");
            Modulo modulo = (Modulo) query.getSingleResult();
            return modulo;
        } catch (NoResultException e) {
            return null;
        }
    }
    public  List<Modulo> buscaModuloPorCurso(int id_curso) {
        try {
            Query query = entityManager.createQuery("SELECT c From Modulo c WHERE c.id_curso='" + id_curso + "'");
            List<Modulo> modulo =query.getResultList();
            return modulo;
        } catch (NoResultException e) {
            return null;
        }
    }
    public void alteraModulo(Modulo modulo) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(modulo);
            entityManager.getTransaction().commit();
        } catch(Exception ex) {
            entityManager.getTransaction().rollback();
        }
    }
     
    public boolean inserirModulo(Modulo modulo) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(modulo);
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        } catch(RollbackException ex) {
            entityManager.getTransaction().rollback();
            return false;
        }
    }
    
    public List<Modulo> consultaModulosAtivados() {
        try {
            Query query = entityManager.createQuery("SELECT m FROM Modulo m WHERE m.status=1");
            List<Modulo> modulos = query.getResultList();
            return modulos;
        } catch(NoResultException ex) {
            return null;
        }
    }
    
}
