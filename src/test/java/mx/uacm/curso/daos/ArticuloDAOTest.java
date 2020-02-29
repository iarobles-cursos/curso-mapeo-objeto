/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.uacm.curso.entidades.Articulo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Alumno
 */
public class ArticuloDAOTest {
    
    private static EntityManager em;
    
    private static ArticuloDAO articuloDAO;
    
    //ArticuloDAOTest.inicializar();
    //junit al usar el annotation @BeforeAll necesita que
    //sea estatico el metodo
    @BeforeAll
    public static void inicializar() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog-pruebas");
        em = emf.createEntityManager();
        articuloDAO = new ArticuloDAOImpl(em);
    }
    
    @Test
    public void buscarArticuloTest(){
        
        Articulo a = articuloDAO.buscarPorId(1);
        //checamos que la variable a no sea NULL
        Assertions.assertNotNull(a);
    }

}
