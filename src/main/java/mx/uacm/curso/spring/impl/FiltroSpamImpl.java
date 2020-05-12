/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.spring.impl;

import mx.uacm.curso.spring.FiltroSpam;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author iarobles
 */
@Component("filtroSpam") // es equivalente en xml <bean id="filtroSpam" class="mx.uacm.curso.spring.impl.FiltroSpamImpl">
@Scope("prototype") //es equivalente en xml a poner en la etiqueta <bean>, el atributo scope="prototype"
public class FiltroSpamImpl implements FiltroSpam{

    public FiltroSpamImpl() {
        System.out.println("creando filtro spam (implementacion 1)");
    }  
    

    @Override
    public boolean posibleSpam(String textoEmail) {
        System.out.println("filtro de spam analizando texto:" + textoEmail);        
        return true;
    }

}
