/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import mx.uacm.curso.daos.ArticuloDAO;
import mx.uacm.curso.daos.ArticuloDAOImpl;
import mx.uacm.curso.entidades.Articulo;

/**
 *
 * @author iarobles
 */
public class EjemploCache {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog-pruebas-memoria");
        EntityManager em = emf.createEntityManager();

//        TypedQuery<Articulo> consulta = em.createQuery("SELECT a FROM Articulo a JOIN FETCH a.comentarios c JOIN FETCH a.categorias ca",Articulo.class);
//        List<Articulo> articulos = consulta.getResultList();
//        for(Articulo a:articulos){
//            System.out.println("comentarios:" + a.getComentarios());
//        }
//        
//        
        Long suma = em.createQuery("SELECT SUM(v.cantidad) FROM Venta v WHERE v.id.orden=1", Long.class).getSingleResult();
        System.out.println("suma:" + suma);

        System.out.println(em.createQuery("SELECT v.id.orden FROM Venta v GROUP BY v.id.orden HAVING SUM(v.cantidad)>:suma",Integer.class).setParameter("suma", suma).getResultList());

        if (2 > 1) {
            return;
        }

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
