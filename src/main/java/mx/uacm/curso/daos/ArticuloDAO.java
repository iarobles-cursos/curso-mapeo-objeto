/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.daos;

import java.util.Date;
import java.util.List;
import mx.uacm.curso.entidades.Articulo;

/**
 *
 * @author Alumno
 */
public interface ArticuloDAO extends GenericDAO<Articulo, Integer> {

    Long totalArticulos();

    List<Articulo> obtenArticulosPorFechaMinima(Date fechaMinima);

    Long totalArticulosSinComentarios();

    Long totalArticulosConComentarios();
    
    Long totalComentariosPorArticulo(Integer articuloId);

}
