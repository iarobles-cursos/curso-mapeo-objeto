/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.spring.impl;

import mx.uacm.curso.spring.FiltroSpam;

/**
 *
 * @author iarobles
 */
public class FiltroSpamImpl2 implements FiltroSpam{ //segunda implementación de filtro para spam

    @Override
    public boolean posibleSpam(String textoEmail) {
        System.out.println("filtro de spam (segunda implementacion) analizando texto:" + textoEmail);        
        return true;
    }

}
