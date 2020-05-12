/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.spring;

import mx.uacm.curso.spring.impl.RegresionImpl;

/**
 *
 * @author iarobles
 */
public class RegresionFabrica {
    
    private static Regresion regresion = new RegresionImpl();

    public static Regresion obtenRegresion() {
        //return new RegresionImpl(); //regresamos siempre una implementacion nueva de implementacion 1
        return regresion;//regresamos un singleton (1 sola instancia por la implementacion)
    }

}
