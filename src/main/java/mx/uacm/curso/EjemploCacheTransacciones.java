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
 * @author iarobles
 */
public class EjemploCacheTransacciones {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog-pruebas-memoria");
        EntityManager em = emf.createEntityManager();

        ArticuloDAO articuloDAO = new ArticuloDAOImpl(em);

        em.getTransaction().begin();

        Articulo a = articuloDAO.buscarPorId(1);
        //a.setContenido("nuevo contenido articulo");
        
        System.out.println("REMOVIENDO ARTICULO");
        articuloDAO.remover(a);
        //em.flush(); //sincronizamos los cambios del cache con la base de datos
                    //no significa que los cambios se guarden de manera definitiva
        
        System.out.println("BUSCANDO ARTICULO:" + articuloDAO.buscarPorId(1));

        System.out.println("INVOCANDO COMMIT");
        //em.getTransaction().commit();//guarda los cambios de manera permanente en la base datos
        //em.getTransaction().rollback();
        
        
//        try {
//            System.out.println("INVOCANDO COMMIT");
//            em.getTransaction().commit();//guarda los cambios de manera permanente en la base datos
//        } catch (Exception e) { //si ocurre un excepcion, deshacemos los cambios
//            e.printStackTrace();//imprimimos el error
//            em.getTransaction().rollback(); //deshacemos los cambios
//        }
    }

}
