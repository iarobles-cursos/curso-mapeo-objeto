/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.servicios.impl;

import mx.uacm.curso.entidades.Articulo;
import mx.uacm.curso.entidades.DatosArticulo;
import mx.uacm.curso.spring.EjemploRollbackExcepcion;

/**
 *
 * @author iarobles
 */
public interface ArticulosServicio {

    Articulo guardarArticuloConDatos(Articulo articulo, DatosArticulo datos) throws EjemploRollbackExcepcion;
    
}
