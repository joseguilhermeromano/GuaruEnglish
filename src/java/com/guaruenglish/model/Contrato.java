/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.model;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Luiz Felipe
 * fodase
 */
@Entity
@Table(name = "contrato")
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private float desconto = (float) 0.05;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data;
    
    private float valor;
    
    @OneToMany(mappedBy = "contrato")
    private List<Parcela> parcelas = new ArrayList<Parcela>();
    
    @ManyToOne()
    @JoinColumn(name = "id_modulo", referencedColumnName = "id")
    private Modulo modulo;
    
    @ManyToOne()
    @JoinColumn(name = "id_aluno", referencedColumnName = "id_aluno")
    private Aluno aluno;
    
    public Contrato() {
        
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
     * @return the desconto
     */
    public float getDesconto() {
        return desconto;
    }

    /**
     * @param desconto the desconto to set
     */
    public void setDesconto(float desconto) {
        this.desconto = desconto;
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
     * @return the valor
     */
    public float getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(float valor) {
        this.valor = valor;
    }

    /**
     * @return the parcelas
     */
    public List<Parcela> getParcelas() {
        return parcelas;
    }

    /**
     * @param parcelas the parcelas to set
     */
    public void setParcelas(List<Parcela> parcelas) {
        this.parcelas = parcelas;
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
    
    public float calculaValorContrato(float valorTotal) {
        this.valor = valorTotal;
        this.valor -= this.valor * this.desconto;
        return this.valor;
    }
    
    public void parcelarContrato(int qtdParcelas) {
        for(int i=1 ; i<=qtdParcelas; i++) {
            Parcela parcela = new Parcela();
            parcela.setNumParcela(i);
            parcela.setValor(this.valor);
            parcela.setStatus(0);
            parcela.definirDataDePagamento(i , this.data);
            parcela.setContrato(this);
            this.parcelas.add(parcela);
        }
        
    }
    
      
    
    
}
