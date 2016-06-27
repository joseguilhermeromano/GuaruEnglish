/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Luiz Felipe
 */
@Entity
@Table(name = "plantaoDuvida")
public class PlantaoDuvida {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date data;
    private float qtdhoras;
    
    @ManyToOne
    @JoinColumn(name = "id_professor")
    private Professor professor;
    
    public PlantaoDuvida() {
        
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
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the qtdhoras
     */
    public float getQtdhoras() {
        return qtdhoras;
    }

    /**
     * @param qtdhoras the qtdhoras to set
     */
    public void setQtdhoras(float qtdhoras) {
        this.qtdhoras = qtdhoras;
    }

    /**
     * @return the professor
     */
    public Professor getProfessor() {
        return professor;
    }

    /**
     * @param professor the professor to set
     */
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
    
}
