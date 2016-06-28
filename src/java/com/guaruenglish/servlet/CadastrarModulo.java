/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.servlet;

import com.guaruenglish.dao.CursoDAO;
import com.guaruenglish.dao.ModuloDAO;
import com.guaruenglish.model.Curso;
import com.guaruenglish.model.Modulo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luiz Felipe
 */
public class CadastrarModulo implements Tarefa {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        String pagina;
        if (req.getParameter("curso") != null) {

            String descricao = req.getParameter("descricao");
            String conteudoBasico = req.getParameter("conteudoBasico");
            String publicoAlvo = req.getParameter("publicoAlvo");
            int status = (req.getParameter("status") == null) ? 0 : Integer.parseInt(req.getParameter("status"));
            int nivel = Integer.parseInt(req.getParameter("nivel"));
            float preco = Float.parseFloat(req.getParameter("preco"));
            int duracao = Integer.parseInt(req.getParameter("duracao"));
            int id_curso = Integer.parseInt(req.getParameter("curso"));

            Curso curso = new CursoDAO().consultaCurso(id_curso);
            Modulo modulo = new Modulo();
            modulo.setConteudoBasico(conteudoBasico);
            modulo.setCurso(curso);
            modulo.setDescricao(descricao);
            modulo.setDuracao(duracao);
            modulo.setNivel(nivel);
            modulo.setPreco(preco);
            modulo.setPublicoAlvo(publicoAlvo);
            modulo.setStatus(status);

            boolean resposta = new ModuloDAO().inserirModulo(modulo);
            if (resposta) {
                pagina = "WEB-INF/Paginas/secretaria/cadastrarModuloSucesso.jsp";
            } else {
                pagina = "WEB-INF/Paginas/secretaria/cadastrarModulo.jsp";
            }
        } else {
            List<Curso> cursos = new CursoDAO().consultaCursos();
            req.setAttribute("cursos", cursos);
            pagina = "WEB-INF/Paginas/secretaria/cadastrarModulo.jsp";
        }
        return pagina;
    }

    @Override
    public Map perfil() {
        Map map = new HashMap();
        map.put("Secretaria", true);

        return map;
    }

}
