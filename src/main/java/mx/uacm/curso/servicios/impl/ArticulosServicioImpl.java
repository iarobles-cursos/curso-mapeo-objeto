/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.servicios.impl;

import mx.uacm.curso.daos.ArticuloDAO;
import mx.uacm.curso.daos.DatosArticuloDAO;
import mx.uacm.curso.entidades.Articulo;
import mx.uacm.curso.entidades.DatosArticulo;
import mx.uacm.curso.spring.EjemploRollbackExcepcion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author iarobles
 */
@Component("articulosServicio")
@Transactional(timeout=3, rollbackFor = {EjemploRollbackExcepcion.class}) //indicamos que se debe activar el rollback con esta exepcion (checked)
public class ArticulosServicioImpl implements ArticulosServicio {

    @Autowired
    private ArticuloDAO articuloDAO;

    @Autowired
    private DatosArticuloDAO datosArticuloDAO;

    @Override
    public Articulo guardarArticuloConDatos(Articulo articulo, DatosArticulo datos) throws EjemploRollbackExcepcion {

        System.out.println("guardando datos articulo");
        //guardamos sus datos adicionales
        DatosArticulo datosGuardados = datosArticuloDAO.guardar(datos);
        
        //simulamos que ocurrio una excepcion del tipo runtime
        //if(1<2){ throw new RuntimeException("ocurrio un error! (runtime)");}
        
        //lanzamos una excepcion del tipo checked
        //if(1<2){ throw new EjemploRollbackExcepcion("ocurrio un error! (runtime)");}
        //guardamos articulo
        System.out.println("guardando articulo");
        articulo.setDatosArticulo(datosGuardados);
        Articulo articuloGuardado = articuloDAO.guardar(articulo);

        //regresamos el articulo guardado junto con sus datos guardados:        
        return articuloGuardado;
    }
}
