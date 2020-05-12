/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.spring.impl;

import mx.uacm.curso.spring.Regresion;

/**
 *
 * @author iarobles
 */
public class RegresionImpl implements Regresion {
    
    
    public RegresionImpl(){
        System.out.println("creando instancia de RegresionImpl");
    }

    public double[] valoresRegresionLineal(double[] x, double[] y) {
        //supuestamente calculamos la regresion lineal:
        System.out.println("calculando regresion lineal");

        double[] valores = {1.5, 2, 2.5, 3, 3.5};
        
        return valores;
    }

}
