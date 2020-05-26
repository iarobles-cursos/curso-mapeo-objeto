/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author iarobles
 */
public class EjemploServletContextListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //se ejecuta cuando va ser destruida la aplicación
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //se ejecuta cuando va ser iniciada la aplicación
        System.out.println("###################################");
        ServletContext sc = sce.getServletContext();
        String valorParametro = sc.getInitParameter("archivoConfiguracion");
        System.out.println("aplicacion lista, nombre archivo de configuracion:" + valorParametro);
        System.out.println("###################################");
    }

}
