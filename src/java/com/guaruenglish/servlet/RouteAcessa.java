/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaruenglish.servlet;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luiz Felipe
 */    
public class RouteAcessa implements Tarefa {

    private final static Map<String, String> PAGINA = new HashMap();

    static {
        PAGINA.put("cadastrarUsuario", "WEB-INF/Paginas/secretaria/cadastrarUsuario.jsp");
        PAGINA.put("Secretaria", "WEB-INF/Paginas/secretariaHome.jsp");
        PAGINA.put("atualizarModulo", "WEB-INF/Paginas/secretaria/curso/atualizarModulo.jsp");
        PAGINA.put("verPlantao", "WEB-INF/Paginas/professor/verPlantao.jsp");
        PAGINA.put("boletim", "WEB-INF/Paginas/professor/definirBoletim.jsp");
    }

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        String pagina = PAGINA.get(req.getParameter("action"));
        if (pagina != null) {
            return pagina;
        }
        return "index.jsp";
    }

    @Override
    public Map perfil() {
        
        return null;
    }

}
