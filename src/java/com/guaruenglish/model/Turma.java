/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.model;

import java.util.Calendar;
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
 *///turma 
@Entity
@Table(name = "turma")
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date dataInicio;
    private Date dataFim;
    private int qtdAulas;
    private String periodo;
    private int status;
    
    @ManyToOne()
    @JoinColumn(name = "id_professor")
    private Professor professor;
    
    @ManyToOne()
    @JoinColumn(name = "id_modulo", referencedColumnName = "id")
    private Modulo modulo;
    
    public Turma() {
        
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
     * @return the dataInicio
     */
    public Date getDataInicio() {
        return dataInicio;
    }

    /**
     * @param dataInicio the dataInicio to set
     */
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    /**
     * @return the dataFim
     */
    public Date getDataFim() {
        return dataFim;
    }

    /**
     * @param dataFim the dataFim to set
     */
    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    /**
     * @return the qtdAulas
     */
    public int getQtdAulas() {
        return qtdAulas;
    }

    /**
     * @param qtdAulas the qtdAulas to set
     */
    public void setQtdAulas(int qtdAulas) {
        this.qtdAulas = qtdAulas;
    }

    /**
     * @return the periodo
     */
    public String getPeriodo() {
        return periodo;
    }

    /**
     * @param periodo the periodo to set
     */
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the modulo
     */
    public Modulo getModulo() {
        return modulo;
    }

    /**
     * @param modulo the modulo to set
     */
    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
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
    
    
    public void calculaQtdAulasSemanas() {
        Calendar calendarI = Calendar.getInstance();
        calendarI.setTime(this.dataInicio);
        Calendar calendarF = Calendar.getInstance();
        calendarF.setTime(this.dataFim);
        //quantidade aproximada de semanas
        int qtdSemanas = (calendarF.get(Calendar.MONTH) - calendarI.get(Calendar.MONTH))*4;
        this.qtdAulas = this.modulo.getDuracao()/qtdSemanas;
    }
        
    
    
}
