/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.model;

import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 *
 * @author Luiz Felipe
 */
@Entity
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    
    @Column(unique = true)
    private String userName;
    
    private String cargo;
    private int status;
    private String senha;
    private String perfilAcesso;
    private String cpf;
    private Date senhaData;
    private int statusSenha;
    
    public Usuario() {
        
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
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
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
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the perfilAcesso
     */
    public String getPerfilAcesso() {
        return perfilAcesso;
    }

    /**
     * @param perfilAcesso the perfilAcesso to set
     */
    public void setPerfilAcesso(String perfilAcesso) {
        this.perfilAcesso = perfilAcesso;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the senhaData
     */
    public Date getSenhaData() {
        return senhaData;
    }

    /**
     * @param senhaData the senhaData to set
     */
    public void setSenhaData(Date senhaData) {
        this.senhaData = senhaData;
    }
    
    /**
     * Atualiza a senha de usuario, a data de expiração 
     * e o status da senha.
     * @param senha 
     */
    public void atualizaSenha(String senha) {
        this.senha = senha;
        this.statusSenha = 1;
        atualizaDataSenha();
    }
    
    /**
     * Atualiza a data de expiração da senha em 5 mêses
     */
    private void atualizaDataSenha() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.senhaData);
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH)+5);
        this.senhaData = calendar.getTime();
    }
    
    
    
    /**
     * @return the statusSenha
     */
    public int getStatusSenha() {
        return statusSenha;
    }

    /**
     * @param statusSenha the statusSenha to set
     */
    public void setStatusSenha(int statusSenha) {
        this.statusSenha = statusSenha;
    }
       
}
