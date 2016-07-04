/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.servlet;

import com.guaruenglish.dao.CursoDAO;
import com.guaruenglish.dao.ModuloDAO;
import com.guaruenglish.dao.TurmaDAO;
import com.guaruenglish.model.Curso;
import com.guaruenglish.model.Modulo;
import com.guaruenglish.model.Turma;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luiz Felipe
 */
public class CadastrarTurma implements Tarefa {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        String pagina = "WEB-INF/Paginas/secretaria/cadastrarTurma.jsp";
        List<Curso> cursos = new CursoDAO().consultaCursos();
        req.setAttribute("cursos", cursos);
        
        if(req.getParameter("modulo") != null) {
            try {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                Date dataInicio = df.parse(req.getParameter("dataInicio"));
                Date dataFim = df.parse(req.getParameter("dataFim"));
                String periodo = req.getParameter("periodo");
                int idModulo = Integer.parseInt(req.getParameter("modulo"));
                
                
                
                if(dataInicio.compareTo(dataFim) >= 0 || dataInicio.compareTo(new Date()) < 0){
                    return "WEB-INF/Paginas/secretaria/cadastrarTurma.jsp";
                }
                
                Turma turma = new Turma();
                turma.setModulo(new ModuloDAO().buscaModulo(idModulo));
                turma.setDataFim(dataFim);
                turma.setDataInicio(dataInicio);
                turma.setPeriodo(periodo);
                turma.setStatus(1);
                turma.calculaQtdAulasSemanas();
                
                if(new TurmaDAO().cadastrarTurma(turma)) {
                    req.setAttribute("turma", turma);
                    pagina = "WEB-INF/Paginas/secretaria/cadastraTurmaSucesso.jsp";
                }
            } catch (ParseException ex) {
                Logger.getLogger(CadastrarTurma.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        return pagina;     
    }
    
    /**
     * Método para montar a 
     * pagina nos primeiros acessos
     * @param req
     * @param resp
     * @return 
     */
    private String acesso(HttpServletRequest req, HttpServletResponse resp) {
        return "WEB-INF/Paginas/secretaria/cadastrarTurma.jsp";
    }

    @Override
    public Map perfil() {
        Map map = new HashMap();
       map.put("Secretaria",true);
       
       return map;
    }
    
    
    
    
}
