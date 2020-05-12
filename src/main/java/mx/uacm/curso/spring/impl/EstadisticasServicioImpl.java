/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.spring.impl;

import java.util.Arrays;
import mx.uacm.curso.spring.EstadisticasServicio;
import mx.uacm.curso.spring.Regresion;
import mx.uacm.curso.spring.RegresionFabrica;

/**
 *
 * @author iarobles
 */
public class EstadisticasServicioImpl implements EstadisticasServicio {
    
    //podemos usar una fabrica para asignar la implementacion
    //private Regresion regresion = RegresionFabrica.obtenRegresion();
    private Regresion regresion;

    @Override
    public String generarReporte() {
        
        System.out.println("generando reporte...");
        //simulamos que obtuvimos datos numericos de la base:
        double x[] = {1, 2, 3, 4, 5};
        double y[] = {1.3, 1.9, 2.3, 2.9, 3.4};                
        double z[] = regresion.valoresRegresionLineal(x, y);

        //armamos el "reporte"
        String reporte = "x:" + Arrays.asList(x) + "y:" + Arrays.asList(y) + ", regresion lineal:" + Arrays.asList(z);

        return reporte;
    }

    public void setRegresion(Regresion regresion) {
        this.regresion = regresion;
    }

    public Regresion getRegresion() {
        return regresion;
    }        

}
