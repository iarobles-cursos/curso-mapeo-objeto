/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.uacm.curso.daos.ArticuloDAO;
import mx.uacm.curso.daos.ArticuloDAOImpl;
import mx.uacm.curso.entidades.Articulo;
import mx.uacm.curso.entidades.Categoria;
import mx.uacm.curso.entidades.Comentario;

/**
 *
 * @author iarobles
 */
public class EjemploCascadeRemove {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog-pruebas-deshacer-crear");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        ArticuloDAO articuloDAO = new ArticuloDAOImpl(em);
        Articulo a = articuloDAO.buscarPorId(3);
        
        em.remove(a);
                
        em.getTransaction().commit();

    }

}
