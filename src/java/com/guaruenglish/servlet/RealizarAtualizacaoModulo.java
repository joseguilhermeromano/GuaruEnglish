/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.servlet;

import com.guaruenglish.dao.ModuloDAO;
import com.guaruenglish.model.Modulo;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luiz Felipe
 */
public class RealizarAtualizacaoModulo implements Tarefa {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        int idModulo = Integer.parseInt(req.getParameter("idModulo"));
        String descricao = req.getParameter("descricao");
        String conteudoBasico = req.getParameter("conteudoBasico");
        String publicoAlvo = req.getParameter("publicoAlvo");
        int status = (req.getParameter("status") == null) ? 0 : Integer.parseInt(req.getParameter("status"));
        int nivel = Integer.parseInt(req.getParameter("nivel"));
        float preco = Float.parseFloat(req.getParameter("preco"));
        int duracao = Integer.parseInt(req.getParameter("duracao"));
       
        Modulo modulo = new ModuloDAO().buscaModulo(idModulo);
        
        modulo.setConteudoBasico(conteudoBasico);
        modulo.setDescricao(descricao);
        modulo.setDuracao(duracao);
        modulo.setNivel(nivel);
        modulo.setPreco(preco);
        modulo.setPublicoAlvo(publicoAlvo);
        modulo.setStatus(status);
        
        boolean resultado = new ModuloDAO().alteraModulo(modulo);
        if(resultado) {
            return "WEB-INF/Paginas/secretaria/curso/atualizarModuloSucesso.jsp";
        } else {
            req.setAttribute("erro", "não foi possivel atualizar o módulo");
            return "WEB-INF/Paginas/secretaria/curso/atualizarModulo.jsp";
        }
    }

    @Override
    public Map perfil() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
