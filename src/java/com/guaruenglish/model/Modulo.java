/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.model;

import java.util.List;

/**
 *
 * @author Luiz Felipe
 */
public class Modulo {
    
    private int id;
    private String descricao;
    private String conteudoBasico;
    private String publicoAlvo;
    private int status;
    private int nivel;
    private float preco;
    private int duracao;
    
    private Curso curso;
    private List<Turma> turmas;
    
    public Modulo() {
        
    }
    
}
