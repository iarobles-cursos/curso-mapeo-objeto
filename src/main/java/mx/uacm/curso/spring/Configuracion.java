/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.spring;

import mx.uacm.curso.spring.impl.EstadisticasServicioImpl;
import mx.uacm.curso.spring.impl.RegresionImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author iarobles
 */
@Configuration
//la siguiente linea es equivalente en xml a:<context:component-scan base-package="mx.uacm.curso.spring.impl"/>            
@ComponentScan(basePackages = {"mx.uacm.curso.spring.impl"})
public class Configuracion {
    
    //el siguiente codigo es equivalente a la configuracion de xml:
    //<bean id="regresion" class="mx.uacm.curso.spring.impl.RegresionImpl"></bean>        
    @Bean("regresion")
    public RegresionImpl obtenRegresion(){
        return new RegresionImpl();
    }
    
    //el siguiente codigo es equivalente a la configuracion de xml:
    //<bean id="estadisticasServicio" class="mx.uacm.curso.spring.impl.EstadisticasServicioImpl">        
    //    <property name="regresion" ref="regresion"/>
    //</bean>        
    @Bean("estadisticasServicio")
    public EstadisticasServicioImpl obtenEstadisticaServicio(){
        EstadisticasServicioImpl servicio = new EstadisticasServicioImpl();
        servicio.setRegresion(obtenRegresion());
        return servicio;
    }    

}
