/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.controladores;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import mx.uacm.curso.daos.ArticuloDAO;
import mx.uacm.curso.entidades.Articulo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author iarobles
 */
@Controller
public class InicioControlador {
    
    @Autowired
    private ArticuloDAO articuloDAO;
    
    
    // definimos que este controlador va antender la url:
    // http://localhost:8080/CONTEXT-ROOT/spring/inicio
    @RequestMapping(method = RequestMethod.GET, value="/inicio")
    public String inicio(Model modelo){
        System.out.println("invocando inicio de controlador");
        
        //simulamos que obtuvimos un mensaje personalizado desde la base
        String mensajePersonalizado = "hola, este es el inicio";
        modelo.addAttribute("mensaje", mensajePersonalizado);
        
        /*
        List<Articulo> listaArticulos = new ArrayList<>();
        Articulo a1 = new Articulo();
        a1.setTitulo("titulo 1");
        a1.setContenido("contenido 1");
        listaArticulos.add(a1);
        
        Articulo a2 = new Articulo();
        a2.setTitulo("titulo 2");
        a2.setContenido("contenido 2");
        listaArticulos.add(a2);
         */
        GregorianCalendar cal = new GregorianCalendar(1960,0,1);
        Date fechaMinima = cal.getTime();
        
        List<Articulo> listaArticulos = articuloDAO.obtenArticulosPorFechaMinima(fechaMinima);
        
        modelo.addAttribute("articulos", listaArticulos);
        
        return "inicio";
    }
    
    
    
    
}
