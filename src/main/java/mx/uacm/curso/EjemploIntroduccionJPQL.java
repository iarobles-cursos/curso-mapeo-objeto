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
public class EjemploIntroduccionJPQL {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog-pruebas-memoria");
        EntityManager em = emf.createEntityManager();

        //EJEMPLO CONSULTAS JPQL
        //ejemplo de consulta usando un TypedQuery
        TypedQuery<Articulo> consulta = em.createQuery("SELECT a FROM Articulo a WHERE a.id=1", Articulo.class);
        Articulo a = consulta.getSingleResult();//getSingleResult se usa cuando la consulta
        //solo puede regresar un resultado.        
        System.out.println("articulo cuyo id es 1:" + a);

        //ejemplo de consulta de una propiedad especifica de la entidad
        TypedQuery<String> consulta2 = em.createQuery("SELECT a.titulo FROM Articulo a WHERE a.id=1", String.class);
        String cadena = consulta2.getSingleResult();//getSingleResult se usa cuando la consulta
        //solo puede regresar un resultado.
        System.out.println("titulo del articulo cuyo id es 1:" + cadena);
        
        
        //ejemplo de consulta que nos regresa muchos resultados (string)
        TypedQuery<String> consulta3 = em.createQuery("SELECT a.titulo FROM Articulo a",String.class);
        List<String> titulos = consulta3.getResultList(); //hacemos la consulta y regresamos los resultados
        System.out.println("titulos:" + titulos);
        
        //ejemplo de consulta que nos regresa muchos resultados (entidades)
        TypedQuery<Articulo> consulta4 = em.createQuery("SELECT a FROM Articulo a",Articulo.class);
        Articulo articulos = consulta4.getSingleResult(); //hacemos la consulta y regresamos los resultados
        System.out.println("articulos:" + articulos);
        

    }

}
