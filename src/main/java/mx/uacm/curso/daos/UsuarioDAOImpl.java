/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.daos;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import mx.uacm.curso.entidades.Articulo;
import mx.uacm.curso.entidades.Usuario;

/**
 *
 * @author Alumno
 */
public class UsuarioDAOImpl extends GenericDAOImpl<Usuario,Integer> implements UsuarioDAO{
    
    public UsuarioDAOImpl(EntityManager em) {
        super(em, Usuario.class);
    }

    @Override
    public List<Usuario> obtenerTodos() {
        TypedQuery<Usuario> consulta = em.createQuery("SELECT u FROM Usuario u",Usuario.class);
        return consulta.getResultList();
    }

    @Override
    public Usuario obtenUsuarioPorEmailYPassword(String email, String password) {
        TypedQuery<Usuario> consulta = em.createQuery("SELECT u FROM Usuario u WHERE u.email=:email AND u.password=:password",Usuario.class);
        consulta.setParameter("email",email);
        consulta.setParameter("password",password);
        return consulta.getSingleResult();
    }
    
}
