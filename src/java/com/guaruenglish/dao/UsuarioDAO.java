/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.dao;

import com.guaruenglish.model.Usuario;
import com.guaruenglish.util.JPAutil;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Luiz Felipe
 */
public class UsuarioDAO {
    
    EntityManager enitityManager = new JPAutil().getEntityManager();
    
    public Usuario buscaUsuario(String userName) {
        try {
            Query query = enitityManager.createQuery
                ("SELECT u From Usuario u WHERE u.userName='"+userName+"'");
            Usuario usuario = (Usuario) query.getSingleResult();
            return usuario;
        } catch(NoResultException e ){
            return null;
        }
        
    }
    
    public Usuario buscaUsuario(int id) {
        
        Query query = enitityManager.createQuery
            ("SELECT u From Usuario WHERE u.id='"+id+"'");
        Usuario usuario = (Usuario) query.getSingleResult();
        return usuario;
    }
    
    
}
