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
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import mx.uacm.curso.entidades.Articulo;

/**
 *
 * @author iarobles
 */
public class EjemploProyeccionesJPQL {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog-pruebas-memoria");
        EntityManager em = emf.createEntityManager();
        
        //ejemplo de proyecciones usando arreglos (un único resultado)
        Query consulta = em.createQuery("SELECT a.id, a.titulo FROM Articulo a WHERE a.id=1");
        Object[] renglon = (Object[]) consulta.getSingleResult();
        System.out.println("id:" + renglon[0]);
        System.out.println("titulo:" + renglon[1]);
        
        //ejemplo de proyecciones usando arreglos (listas)
        Query consulta2 = em.createQuery("SELECT a.id, a.titulo FROM Articulo a");
        List<Object[]> renglones = consulta2.getResultList();
        for(Object[] unRenglon: renglones){
            System.out.println("id:" + unRenglon[0] + ", titulo:" + unRenglon[1]);
        }

    }

}