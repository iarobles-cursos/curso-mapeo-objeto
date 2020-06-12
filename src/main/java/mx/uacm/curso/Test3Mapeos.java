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
public class Test3Mapeos {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog-pruebas-deshacer-crear");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        test5(em);
        em.getTransaction().commit();

    }

    private static void test1(EntityManager em) {
        //categoria (dueña) guarda articulos asociados
        Articulo a = em.find(Articulo.class, 1);
        a.setTitulo("titulo articulo test");

        Categoria c = new Categoria();
        c.setNombre("test categoria");

        List<Articulo> articulos = new ArrayList<>();
        articulos.add(a);

        c.setArticulos(articulos);

        em.merge(c);
    }

    private static void test2(EntityManager em) {
        //categoria (dueña) guarda articulos asociados nuevos (debe ocurrir error)
        Articulo a = new Articulo();
        a.setTitulo("titulo articulo");

        Categoria c = new Categoria();
        c.setNombre("test categoria");

        List<Articulo> articulos = new ArrayList<>();
        articulos.add(a);
        c.setArticulos(articulos);

        em.merge(c);
    }

    private static void test3(EntityManager em) {
        //articulo (no dueña) nueva se guarda y se intenta guardar categorias 
        Articulo a = new Articulo();
        a.setTitulo("titulo articulo");

        Categoria c = new Categoria();
        c.setNombre("test categoria");

        List<Articulo> articulos = new ArrayList<>();
        articulos.add(a);
        c.setArticulos(articulos);

        List<Categoria> categorias = new ArrayList<Categoria>();
        categorias.add(c);

        a.setCategorias(categorias);

        em.merge(a);
    }

    private static void test4(EntityManager em) {

        Articulo a = new Articulo();
        a.setTitulo("test");

        List<Articulo> articulos = new ArrayList<>();
        articulos.add(a);

        Categoria c1 = new Categoria();
        c1.setNombre("cat1");
        c1.setArticulos(articulos);

        Categoria c2 = new Categoria();
        c2.setNombre("cat2");
        c2.setArticulos(articulos);

        List<Categoria> categorias = new ArrayList<>();
        categorias.add(c1);
        categorias.add(c2);
        a.setCategorias(categorias);

        System.out.println("tests");
        em.merge(a);
    }

    private static void test5(EntityManager em) {

        Articulo a = new Articulo();
        a.setTitulo("test");

        List<Articulo> articulos = new ArrayList<>();
        articulos.add(a);

        Categoria c1 = new Categoria();
        c1.setNombre("cat1");
        c1.setArticulos(articulos);

        System.out.println("testsss");
        em.merge(c1);
    }
}
