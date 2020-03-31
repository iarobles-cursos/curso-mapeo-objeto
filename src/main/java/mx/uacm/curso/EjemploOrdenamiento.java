/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.uacm.curso.daos.UsuarioDAO;
import mx.uacm.curso.daos.UsuarioDAOImpl;
import mx.uacm.curso.entidades.Usuario;

/**
 *
 * @author iarobles
 */
public class EjemploOrdenamiento {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog-pruebas-memoria");
        EntityManager em = emf.createEntityManager();
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl(em);
        
        Usuario u = usuarioDAO.buscarPorId(1);
        System.out.println("lista de articulos del usuario:" + u.getArticulos());
    }

}
