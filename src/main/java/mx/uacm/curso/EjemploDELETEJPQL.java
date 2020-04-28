/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso;

import java.util.Date;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author iarobles
 */
public class EjemploDELETEJPQL {

    public static void main(String[] args) {

        //Para usar la base de datos en memoria, descomente la siguiente linea:
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog-pruebas-memoria");
        //Para borrar y volver a crear la base de datos "de verdad":
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog-pruebas-deshacer-crear");        
        EntityManager em = emf.createEntityManager();
        
        //EJEMPLO DELETE con consulta parametrizada
        em.getTransaction().begin();//inicio de la transaccion
        
        Date fechaMax =  (new GregorianCalendar(2020,0,1)).getTime();
        Query consulta = em.createQuery("DELETE Comentario c WHERE c.fechaCreacion<:fechaMax");
        consulta.setParameter("fechaMax", fechaMax);
        int totalRenglonesModificados = consulta.executeUpdate();

        em.getTransaction().commit();//final de la transadccion               
        
        
        //EJEMPLO DELETE CON SUBCONSULTAS Y FUNCIONES DE AGREGADO
        em.getTransaction().begin();//inicio de la transaccion
        
        
        Query consulta2 = em.createQuery("DELETE Venta v WHERE v.id.orden IN(SELECT v.id.orden FROM Venta v GROUP BY v.id.orden HAVING SUM(v.cantidad)<=3)");       
        totalRenglonesModificados = consulta2.executeUpdate();
        System.out.println("renglones modificados (ventas):" + totalRenglonesModificados);        

        em.getTransaction().commit();//final de la transadccion               


    }

}
