/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.spring;

import mx.uacm.curso.daos.ArticuloDAO;
import mx.uacm.curso.entidades.Articulo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author iarobles
 */
public class EjemploSpring {
    
    public static void main(String[] args) {
        //creamo contenedor de spring (application context)
        ApplicationContext contexto = new ClassPathXmlApplicationContext("spring-context.xml");
        //ApplicationContext contexto  = new AnnotationConfigApplicationContext(Configuracion.class);
        ServicioEmail servicioEmail = contexto.getBean("servicioEmail",ServicioEmail.class);
        servicioEmail.procesarEmail(1);                
        
        EstadisticasServicio estadisticasServicio = contexto.getBean("estadisticasServicio", EstadisticasServicio.class);
        estadisticasServicio.generarReporte();
        
        
        System.out.println("---- solicitando bean regresion (primera vez) ----");
        Regresion regresion = contexto.getBean("regresion", Regresion.class);
        System.out.println("---- solicitud de bean regresion terminada (primera vez) ----");
        
        
        System.out.println("---- solicitando bean regresion (segunda vez) ----");
        regresion = contexto.getBean("regresion", Regresion.class);
        System.out.println("---- solicitud de bean regresion terminada (segunda vez) ----");
        
        
        System.out.println("---- solicitando bean filtroSpam (primera vez) ----");
        FiltroSpam filtro = contexto.getBean("filtroSpam", FiltroSpam.class);
        System.out.println("---- solicitud de bean filtroSpam terminada (primera vez) ----");
        
        System.out.println("---- solicitando bean filtroSpam (segunda vez) ----");
        filtro = contexto.getBean("filtroSpam", FiltroSpam.class);
        System.out.println("---- solicitud de bean filtroSpam terminada (segunda vez) ----");
        
        
        System.out.println("obteniendo dao:");
        ArticuloDAO articuloDAO = contexto.getBean("articuloDAO", ArticuloDAO.class);
        Articulo a = articuloDAO.buscarPorId(1);
        System.out.println("titulo articulo:" + a.getTitulo());
        
    }
    
}
