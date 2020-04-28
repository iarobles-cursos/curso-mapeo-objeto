/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author iarobles
 */
public class EjemploUPDATEJPQL {

    public static void main(String[] args) {

        //Para usar la base de datos en memoria, descomente la siguiente linea:
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog-pruebas-memoria");
        //Para usar la base de datos "de verdad".
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog-pruebas");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();//inicio de la transaccion
        
        Query consulta = em.createQuery("UPDATE DatosArticulo d SET d.observaciones='nueva observacion 1' WHERE d.id=(SELECT e.id FROM DatosArticulo e WHERE e.articulo.id=1)");
        int totalRenglonesActualizados = consulta.executeUpdate();
        
        System.out.println("renglones actualizados:" + totalRenglonesActualizados);
        
        em.getTransaction().commit();//final de la transadccion
                

    }

}
