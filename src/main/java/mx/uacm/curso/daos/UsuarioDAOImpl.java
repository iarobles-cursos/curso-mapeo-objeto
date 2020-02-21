/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.daos;

import javax.persistence.EntityManager;
import mx.uacm.curso.entidades.Articulo;
import mx.uacm.curso.entidades.Usuario;

/**
 *
 * @author Alumno
 */
public class UsuarioDAOImpl implements UsuarioDAO{
    
    private EntityManager em;
    
    public UsuarioDAOImpl(EntityManager em){
        this.em = em;
    }

    @Override
    public Usuario buscarPorId(Integer id) {
        return this.em.find(Usuario.class, id);
    }

    @Override
    public Usuario guardar(Usuario a) {
        return this.em.merge(a);
    }

    @Override
    public void remover(Usuario a) {
        this.em.remove(a);
    }    
    
}
