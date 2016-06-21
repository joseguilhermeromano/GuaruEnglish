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
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Luiz Felipe
 */
@Entity
@Table(name = "professor")
@PrimaryKeyJoinColumn(name = "id_professor", referencedColumnName = "id")
public class Professor extends Usuario {
    
    private float cargaHoraria;
    private float cargaHoririaDisponivel;
    private String especialidade;
    private String nivelExperiencia;
    
    @OneToMany(mappedBy = "professor")
    private List<Turma> turmas;
    private List<PlantaoDuvida> plantoes;
    
    
    public Professor() {
        
    }

    /**
     * @return the cargaHoraria
     */
    public float getCargaHoraria() {
        return cargaHoraria;
    }

    /**
     * @param cargaHoraria the cargaHoraria to set
     */
    public void setCargaHoraria(float cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    /**
     * @return the cargaHoririaDisponivel
     */
    public float getCargaHoririaDisponivel() {
        return cargaHoririaDisponivel;
    }

    /**
     * @param cargaHoririaDisponivel the cargaHoririaDisponivel to set
     */
    public void setCargaHoririaDisponivel(float cargaHoririaDisponivel) {
        this.cargaHoririaDisponivel = cargaHoririaDisponivel;
    }

    /**
     * @return the especialidade
     */
    public String getEspecialidade() {
        return especialidade;
    }

    /**
     * @param especialidade the especialidade to set
     */
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    /**
     * @return the nivelExperiencia
     */
    public String getNivelExperiencia() {
        return nivelExperiencia;
    }

    /**
     * @param nivelExperiencia the nivelExperiencia to set
     */
    public void setNivelExperiencia(String nivelExperiencia) {
        this.nivelExperiencia = nivelExperiencia;
    }

    /**
     * @return the turmas
     */
    public List<Turma> getTurmas() {
        return turmas;
    }

    /**
     * @param turmas the turmas to set
     */
    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    /**
     * @return the plantoes
     */
    public List<PlantaoDuvida> getPlantoes() {
        return plantoes;
    }

    /**
     * @param plantoes the plantoes to set
     */
    public void setPlantoes(List<PlantaoDuvida> plantoes) {
        this.plantoes = plantoes;
    }
    
    
}
