/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.uacm.curso.daos.ArticuloDAO;
import mx.uacm.curso.daos.ArticuloDAOImpl;
import mx.uacm.curso.entidades.Articulo;

/**
 *
 * @author Alumno
 */
public class EjemploDAO {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog-pruebas");
        EntityManager em = emf.createEntityManager();
        
        //INVOCAMOS AL DAO
        ArticuloDAO aDAO = new ArticuloDAOImpl(em);
        
        //CREAR
        em.getTransaction().begin();
        
        Articulo a = new Articulo();
        a.setTitulo("nuevo titulo (dao)");        
        aDAO.guardar(a);
        
        em.getTransaction().commit();

    }

}
