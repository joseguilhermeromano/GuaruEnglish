/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Luiz Felipe
 */
@Entity
@Table(name = "parcela")
public class Parcela {
    @Id
    private int id;
    private int status;
    private Date dataPagamento;
    private float valor;
    private int numParcela;
    private String mesParcela;
    
    @ManyToOne
    @JoinColumn(name = "id_contrato", referencedColumnName = "id")
    private Contrato contrato;
    
    public Parcela() {
        
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
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
     * @return the dataPagamento
     */
    public Date getDataPagamento() {
        return dataPagamento;
    }

    /**
     * @param dataPagamento the dataPagamento to set
     */
    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
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
     * @return the numParcela
     */
    public int getNumParcela() {
        return numParcela;
    }

    /**
     * @param numParcela the numParcela to set
     */
    public void setNumParcela(int numParcela) {
        this.numParcela = numParcela;
    }

    /**
     * @return the mesParcela
     */
    public String getMesParcela() {
        return mesParcela;
    }

    /**
     * @param mesParcela the mesParcela to set
     */
    public void setMesParcela(String mesParcela) {
        this.mesParcela = mesParcela;
    }

    /**
     * @return the contrato
     */
    public Contrato getContrato() {
        return contrato;
    }

    /**
     * @param contrato the contrato to set
     */
    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }
    
}
