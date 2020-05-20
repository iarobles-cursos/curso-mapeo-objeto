/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.spring;

import mx.uacm.curso.daos.ArticuloDAO;
import mx.uacm.curso.entidades.Articulo;
import mx.uacm.curso.entidades.DatosArticulo;
import mx.uacm.curso.servicios.impl.ArticulosServicio;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author iarobles
 */
public class EjemploPropiedadesTransacciones {
    
    public static void main(String[] args) throws EjemploRollbackExcepcion{
        //creamos contenedor de spring (application context)
        ApplicationContext contexto = new ClassPathXmlApplicationContext("spring-context.xml");
        ArticulosServicio articulosServicio = contexto.getBean("articulosServicio", ArticulosServicio.class);
        
        //creamos articulo de prueba
        Articulo articulo = new Articulo();
        articulo.setTitulo("titulo articulo (propiedades transacciones)");
        //creamos datos articulo de prueba
        DatosArticulo datos = new DatosArticulo();
        datos.setObservaciones("observaciones (propiedades transacciones)");
        
        articulosServicio.guardarArticuloConDatos(articulo, datos);
        
    }
    
}
