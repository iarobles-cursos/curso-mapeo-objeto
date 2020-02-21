/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.daos;

import mx.uacm.curso.entidades.Articulo;

/**
 *
 * @author Alumno
 */
public interface ArticuloDAO {
    
    //IMPLEMENTAMOS LOS METODOS CRUD
    public Articulo buscarPorId(Integer id);
    
    public Articulo guardar(Articulo a);
    
    public void remover(Articulo a);
    
}
