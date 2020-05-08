/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.spring;

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
        //ApplicationContext contexto = new ClassPathXmlApplicationContext("spring-context.xml");
        ApplicationContext contexto  = new AnnotationConfigApplicationContext(Configuracion.class);
        ServicioEmail servicioEmail = contexto.getBean("servicioEmail",ServicioEmail.class);
        servicioEmail.procesarEmail(1);                
        
        EstadisticasServicio estadisticasServicio = contexto.getBean("estadisticasServicio", EstadisticasServicio.class);
        estadisticasServicio.generarReporte();
        
    }
    
}
