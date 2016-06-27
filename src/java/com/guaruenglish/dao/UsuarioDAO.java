/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.dao;

import com.guaruenglish.model.Usuario;
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
public class UsuarioDAO {
    
    EntityManager entityManager = new JPAutil().getEntityManager();
    
    public Usuario buscaUsuario(String userName) {
        try {
            Query query = entityManager.createQuery
                ("SELECT u From Usuario u WHERE u.userName='"+userName+"'");
            Usuario usuario = (Usuario) query.getSingleResult();
            return usuario;
        } catch(NoResultException e ){
            return null;
        }
        
    }
    
    public void alteraUsuario(Usuario usuario) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(usuario);
            entityManager.getTransaction().commit();
        } catch(Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public Usuario buscaUsuarioId(int id) {
        
        Query query = entityManager.createQuery
            ("SELECT u From Usuario u WHERE u.id='"+id+"'");
        Usuario usuario = (Usuario) query.getSingleResult();
        return usuario;
    }
    
    public boolean cadastrarUsuario(Usuario usuario) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(usuario);
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        } catch(RollbackException ex) {
            entityManager.getTransaction().rollback();
            return false;
        }
    }
    
    public List<Usuario> consultarUsuarios() {
        try {
            Query query = entityManager.createQuery("SELECT u FROM Usuario u");
            List<Usuario> usuarios = query.getResultList();
            return usuarios;
        } catch(NoResultException e) {
            return null;
        }
    }
    
    public List<Usuario> consultarUsuarios(String nome, String cpf) {
        try {
            Query query = entityManager.createQuery
        ("SELECT u FROM Ususario u WHERE u.nome='"+nome+"' or u.cpf='"+cpf+"'");
            List<Usuario> usuarios = query.getResultList();
            return usuarios;
        } catch(NoResultException e) {
            return null;
        }
    }
        
    
}
