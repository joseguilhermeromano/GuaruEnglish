/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.dao;

import com.guaruenglish.model.Declaracao;
import com.guaruenglish.util.JPAutil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Luiz Felipe
 */
public class DeclaracaoDAO {
    EntityManager entityManager = new JPAutil().getEntityManager();
    
    public Declaracao buscaDeclaracao(int id) {
        try {
            Query query = entityManager.createQuery
        ("SELECT d FROM Declaracao d WHERE d.id='"+id+"'");
            Declaracao declaracao = (Declaracao) query.getSingleResult();
            return declaracao;
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<Declaracao> buscaDeclaracoesNaoResolvidas() {
        try {
            Query query = entityManager.createQuery
        ("SELECT d FROM Declaracao d WHERE d.status = 0");
            List<Declaracao> declaracoes = query.getResultList();
            return declaracoes;
        } catch(Exception e) {
            return null;
        }
    }
    
    public boolean inserirDeclaracao(Declaracao declaracao) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(declaracao);
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        } catch(Exception e ) {
            entityManager.getTransaction().rollback();
            return false;
        }
    }
    
    public List<Declaracao> buscaDeclaracoes() {
        try {
            Query query = entityManager.createQuery("SELECT d FROM Declaracao d");
            List<Declaracao> declaracoes = query.getResultList();
            return declaracoes;
        } catch(Exception e) {
            return null;
        }
    }
    
    
    
}
