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

/**
 *
 * @author iarobles
 */
public class EjemploCache {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog-pruebas-memoria");
        EntityManager em = emf.createEntityManager();

        ArticuloDAO articuloDAO = new ArticuloDAOImpl(em);
        System.out.println("ANTES DE BUSCAR ARTICULO");
        articuloDAO.buscarPorId(1);
        System.out.println("DESPUES DE BUSCAR ARTICULO");

        System.out.println("ANTES DE BUSCAR ARTICULO (SEGUNDA VEZ)");
        articuloDAO.buscarPorId(1);
        System.out.println("DESPUES DE BUSCAR ARTICULO (SEGUNDA VEZ)");

        //creamos un segundo entity manager
        EntityManager em2 = emf.createEntityManager();
        //creamos un segundo dao asociado al segundo entity manager
        ArticuloDAO articuloDAO2 = new ArticuloDAOImpl(em2);

        System.out.println("ANTES DE BUSCAR ARTICULO (ENTITY MANAGER 2)");
        articuloDAO2.buscarPorId(1);
        System.out.println("DESPUES DE BUSCAR ARTICULO (ENTITY MANAGER 2)");

        System.out.println("ANTES DE BUSCAR ARTICULO (ENTITY MANAGER 2, SEGUNDA VEZ)");
        articuloDAO2.buscarPorId(1);
        System.out.println("DESPUES DE BUSCAR ARTICULO (ENTITY MANAGER 2, SEGUNDA VEZ)");

    }

}
