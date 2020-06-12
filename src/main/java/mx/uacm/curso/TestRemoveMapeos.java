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
import mx.uacm.curso.entidades.Articulo;
import mx.uacm.curso.entidades.Categoria;
import mx.uacm.curso.entidades.DatosUsuario;
import mx.uacm.curso.entidades.Usuario;

/**
 *
 * @author iarobles
 */
public class TestRemoveMapeos {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog-pruebas-deshacer-crear");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        test2(em);
        em.getTransaction().commit();

    }

    private static void test1(EntityManager em) {
        //remover entidad dueña
        Categoria c = em.find(Categoria.class, 4);
        System.out.println("nombre:" + c.getNombre());

        em.remove(c);
    }

    private static void test2(EntityManager em) {
        //remover entidad no dueña
        Articulo a = em.find(Articulo.class, 4);
        for (Categoria c : a.getCategorias()) {
            int index = c.getArticulos().indexOf(a);
            if (index != -1) {
                c.getArticulos().remove(index);
                em.flush();
                System.out.println("### removiendo articulo en categoria:" + c.getNombre());
            }
        }



//
//        Categoria c = em.createQuery("SELECT c FROM Categoria c JOIN c.articulos a WHERE a.id=4", Categoria.class).getSingleResult();
//        List<Articulo> articulos = c.getArticulos();
//        System.out.println("articulos:" + c.getArticulos().size());
//        Articulo a = articulos.get(1);
//        
//        a.getCategorias().remove(c);
//        c.getArticulos().remove(a);



//        Articulo a = em.find(Articulo.class, 4);
//        Categoria c = em.find(Categoria.class, 4);
//        a.getCategorias().remove(c);
//        //c.getArticulos().remove(a);
    }

}
