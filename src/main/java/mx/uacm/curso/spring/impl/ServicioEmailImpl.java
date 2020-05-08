/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.spring.impl;

import javax.inject.Inject;
import javax.inject.Named;
import mx.uacm.curso.spring.FiltroSpam;
import mx.uacm.curso.spring.ServicioEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author iarobles
 */
//@Component("servicioEmail")
@Named("servicioEmail")
public class ServicioEmailImpl implements ServicioEmail{
    
    @Inject //@Autowired
    @Named("filtroSpam")//@Qualifier("filtroSpam")
    private FiltroSpam filtro;

    public FiltroSpam getFiltro() {
        return filtro;
    }

    public void setFiltro(FiltroSpam filtro) {
        this.filtro = filtro;
    }

    public void procesarEmail(Integer id) {
        
        System.out.println("procesando email");

        //imaginemos que se obtuvo texto de emails de la base
        //y que se van a evaluar para determinar si son spam
        //por la herramienta de filtros de spam:
        String textoEmail = "email texto 1";
        if (filtro.posibleSpam(textoEmail)) {
            System.out.println("es spam!");
        } else {
            System.out.println("todo bien con el correo!");
        }

    }

}
