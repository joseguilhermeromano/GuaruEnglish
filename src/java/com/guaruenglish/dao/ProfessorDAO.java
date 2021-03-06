/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.dao;

import com.guaruenglish.model.Professor;
import com.guaruenglish.util.JPAutil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.RollbackException;

/**
 *
 * @author Luiz Felipe
 */
public class ProfessorDAO {
    
    EntityManager entityManager = new JPAutil().getEntityManager();
    
    public Professor buscaProfessor(int id) {
        
        try {
            Query query = entityManager.createQuery
                ("SELECT p FROM Professor p WHERE p.id='"+id+"'");
            Professor professor = (Professor)query.getSingleResult();
            return professor;
        } catch(NoResultException e) {
            return null;
        }
    }

    public boolean alteraProfessor(Professor professor) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(professor);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return true;
    }
    
    public boolean cadastrarProfessor(Professor professor) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(professor);
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        } catch(RollbackException e) {
            entityManager.getTransaction().rollback();
            return false;
        }
    }
    
    public List<Professor> buscaProfessores() {
        try {
            Query query = entityManager.createQuery("SELECT p FROM Professor p");
            List<Professor> professores = query.getResultList();
            return professores;
        } catch(Exception e) {
            return null;
        }
    }
    
    public List<Professor> buscaProfessoresHorarioDisponivel() {
        try {
            Query query = entityManager.createQuery
        ("SELECT p FROM Professor p WHERE p.cargaHorariaDisponivel != 0");
            List<Professor> professores = query.getResultList();
            return professores;
        } catch(Exception e) {
            return null;
        }
    }
    
    
}
