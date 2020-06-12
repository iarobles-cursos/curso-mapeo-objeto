/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.uacm.curso.entidades.Articulo;
import mx.uacm.curso.entidades.DatosUsuario;
import mx.uacm.curso.entidades.Usuario;

/**
 *
 * @author iarobles
 */
public class TestMapeos {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog-pruebas-deshacer-crear");
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog-pruebas");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
//
//        DatosUsuario datosUsuario = new DatosUsuario();
//        datosUsuario.setBiografia("biografia tesf fs");
//        em.persist(datosUsuario);
//
//        Usuario u = new Usuario();
//        u.setNombre("usuario pruebas");
//        em.persist(u);
//
//        u.setDatosUsuario(datosUsuario);


        em.remove(em.find(DatosUsuario.class, 4));

        em.getTransaction().commit();

    }
}
