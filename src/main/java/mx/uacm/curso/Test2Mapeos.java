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
import mx.uacm.curso.entidades.DatosUsuario;
import mx.uacm.curso.entidades.Usuario;

/**
 *
 * @author iarobles
 */
public class Test2Mapeos {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog-pruebas-deshacer-crear");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Usuario u = new Usuario();
        u.setNombre("usuario pruebas");        

        Articulo a = new Articulo();
        a.setTitulo("test");
        a.setUsuario(u);        

        List<Articulo> articulos = new ArrayList<>();
        articulos.add(a);
        
        u.setArticulos(articulos);
        
        em.persist(u);
        //Usuario u2 = em.find(Usuario.class, u.getId());

        //System.out.println("u2.getArticulos().size():" + u2.getArticulos().size() + ", u.getArticulos().size():" + u.getArticulos().size() + ", IIGUALES:" + (u2.getArticulos().size() == u.getArticulos().size()));
        em.getTransaction().commit();

    }
}
