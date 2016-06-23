/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Luiz Felipe
 */
@Entity
@Table(name = "curso")
public class Curso {
    @Id
    private int id;
    private String descricao;
    
    @OneToMany(mappedBy = "curso")
    private List<Modulo> modulos;
    
    public Curso() {
        
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the modulos
     */
    public List<Modulo> getModulos() {
        return modulos;
    }

    /**
     * @param modulos the modulos to set
     */
    public void setModulos(List<Modulo> modulos) {
        this.modulos = modulos;
    }
    
}
