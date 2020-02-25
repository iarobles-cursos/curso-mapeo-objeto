/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.daos;

import mx.uacm.curso.entidades.Usuario;

/**
 *
 * @author Alumno
 */
public interface UsuarioDAO {
        
    //IMPLEMENTAMOS LOS METODOS CRUD
    public Usuario buscarPorId(Integer id);
    
    public Usuario guardar(Usuario a);
    
    public void remover(Usuario a);
}
