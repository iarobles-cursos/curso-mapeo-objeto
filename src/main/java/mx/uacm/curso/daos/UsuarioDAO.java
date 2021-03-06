/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.daos;

import java.util.List;
import mx.uacm.curso.dtos.UsuarioDTO;
import mx.uacm.curso.entidades.Usuario;

/**
 *
 * @author Alumno
 */
public interface UsuarioDAO extends GenericDAO<Usuario, Integer> {
    //LOS METODOS DE ESTA INTEFAZ LOS HEREDA DE GENERIC DAO

    public List<Usuario> obtenerTodos();

    public Usuario obtenUsuarioPorEmailYPassword(String email, String password);

    public UsuarioDTO obtenNombreYEmail(Integer id);
}
