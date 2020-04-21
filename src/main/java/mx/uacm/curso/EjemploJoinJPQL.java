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
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import mx.uacm.curso.entidades.Articulo;

/**
 *
 * @author iarobles
 */
public class EjemploJoinJPQL {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog-pruebas-memoria");
        EntityManager em = emf.createEntityManager();

        TypedQuery<Tuple> consulta = em.createQuery("SELECT a.titulo AS titulo, c.comentario AS comentario FROM Articulo a INNER JOIN a.comentarios c", Tuple.class);
        List<Tuple> renglones = consulta.getResultList();
        for (Tuple renglon : renglones) {
            System.out.println("titulo:" + renglon.get("titulo") + ", comentario:" + renglon.get("comentario"));
        }

        TypedQuery<Tuple> consulta2 = em.createQuery("SELECT a.titulo AS titulo, c.nombre AS nombre FROM Articulo a INNER JOIN a.categorias c", Tuple.class);
        List<Tuple> renglones2 = consulta2.getResultList();
        for (Tuple renglon : renglones2) {
            System.out.println("titulo:" + renglon.get("titulo") + ", nombre:" + renglon.get("nombre"));
        }
    }

}
