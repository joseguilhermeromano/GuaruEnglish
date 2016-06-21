/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.model;

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
@Table(name = "boletim")
public class Boletim {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int qtdFaltas;
    private float conceitoParcial;
    private float conceitoFinal;
    
    @ManyToOne
    @JoinColumn(name = "id_aluno", referencedColumnName = "id")
    private Aluno aluno;
    
    @ManyToOne
    @JoinColumn(name = "id_turma", referencedColumnName = "id")
    private Turma turma;
    
    public Boletim() {
        
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
     * @return the qtdFaltas
     */
    public int getQtdFaltas() {
        return qtdFaltas;
    }

    /**
     * @param qtdFaltas the qtdFaltas to set
     */
    public void setQtdFaltas(int qtdFaltas) {
        this.qtdFaltas = qtdFaltas;
    }

    /**
     * @return the conceitoParcial
     */
    public float getConceitoParcial() {
        return conceitoParcial;
    }

    /**
     * @param conceitoParcial the conceitoParcial to set
     */
    public void setConceitoParcial(float conceitoParcial) {
        this.conceitoParcial = conceitoParcial;
    }

    /**
     * @return the conceitoFinal
     */
    public float getConceitoFinal() {
        return conceitoFinal;
    }

    /**
     * @param conceitoFinal the conceitoFinal to set
     */
    public void setConceitoFinal(float conceitoFinal) {
        this.conceitoFinal = conceitoFinal;
    }

    /**
     * @return the aluno
     */
    public Aluno getAluno() {
        return aluno;
    }

    /**
     * @param aluno the aluno to set
     */
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    /**
     * @return the turma
     */
    public Turma getTurma() {
        return turma;
    }

    /**
     * @param turma the turma to set
     */
    public void setTurma(Turma turma) {
        this.turma = turma;
    }
    
    
}
