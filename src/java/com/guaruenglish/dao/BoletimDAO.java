/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.dao;

import com.guaruenglish.model.Boletim;
import com.guaruenglish.util.JPAutil;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transaction;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Luiz Felipe
 */
public class BoletimDAO {

    EntityManager entityManager = new JPAutil().getEntityManager();

    public void insereBoletim(Boletim boletim) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(boletim);
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    public boolean alteraBoletim(Boletim boletim) {

        //public String update(int id,String newName){
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("UPDATE Boletim x SET x.qtdFaltas="+boletim.getQtdFaltas()+",x.conceitoParcial="+boletim.getConceitoParcial()+",x.conceitoFinal="+boletim.getConceitoFinal()+" WHERE x.id="+boletim.getId()+"");
            query.executeUpdate();
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.err.println(e);
        }
        return false;

    }

    public Boletim consultaBoletim(int idAluno, int idTurma) {
        try {
            Query query = entityManager.createQuery("SELECT b FROM Boletim b "
                    + "WHERE b.turma.id='" + idTurma + "' "
                    + "AND b.aluno.id='" + idAluno + "'");
            Boletim boletim = (Boletim) query.getSingleResult();
            return boletim;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Boletim> consultaBoletinsTurma(int idTurma) {
        try {
            Query query = entityManager.createQuery("SELECT b FROM Boletim b "
                    + "WHERE b.turma.id=" + idTurma + "");
            List<Boletim> boletins = query.getResultList();
            return boletins;
        } catch (Exception e) {
            return null;
        }
    }

}
