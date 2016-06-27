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
/**
 *
 * @author rafin
 */
public class ModuloDAO {
    EntityManager entityManager = new JPAutil().getEntityManager();
    
    public  List<Modulo> buscaModuloPorId(int id) {
        try {
            Query query = entityManager.createQuery("SELECT c From Modulo c WHERE c.id='" + id + "'");
            List<Modulo> modulo =query.getResultList();
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
    
}
