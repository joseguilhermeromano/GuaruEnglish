/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.dao;

import com.guaruenglish.model.Curso;
import com.guaruenglish.util.JPAutil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Luiz Felipe
 */
public class CursoDAO {
    
    EntityManager entityManager = new JPAutil().getEntityManager();
    
    public List<Curso> consultaCursos() {
        try {
            Query query = entityManager.createQuery("SELECT c FROM Curso c");
            List<Curso> cursos = query.getResultList();
            return cursos;
        } catch(NoResultException ex) {
            return null;
        }
    }
    
    public Curso consultaCurso(int id) {
        try {
            Query query = entityManager.createQuery
        ("SELECT c FROM Curso c WHERE c.id='"+id+"'");
            Curso curso = (Curso) query.getSingleResult();
            return curso;
        } catch(NoResultException ex) {
            return null;
        }
    }
    
}
