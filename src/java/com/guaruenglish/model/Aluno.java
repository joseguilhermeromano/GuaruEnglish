/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Luiz Felipe
 */
@Entity
@Table(name = "aluno")
@PrimaryKeyJoinColumn(name = "id_aluno", referencedColumnName = "id")
public class Aluno extends Usuario{
        
    @Column(unique = true)
    private String matricula;
    
    @OneToMany(mappedBy = "aluno")
    private List<Contrato> contratos;
    
    public Aluno() {
        
    }

    /**
     * @return the matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * @return the contratos
     */
    public List<Contrato> getContratos() {
        return contratos;
    }

    /**
     * @param contratos the contratos to set
     */
    public void setContratos(List<Contrato> contratos) {
        this.contratos = contratos;
    }
    
}
