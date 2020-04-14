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
public class EjemploFuncionesAgregadoJPQL {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog-pruebas-memoria");
        EntityManager em = emf.createEntityManager();
        
        //ejemplo de funcion de agregado SUM
        TypedQuery<Long> consulta = em.createQuery("SELECT SUM(v.cantidad) FROM Venta v", Long.class);
        Long cantidadProductosVendidos = consulta.getSingleResult();
        System.out.println("total de productos vendidos:" + cantidadProductosVendidos);
        
        //ejemplo de funcion de agregado COUNT
        TypedQuery<Long> consulta2 = em.createQuery("SELECT COUNT(v) FROM Venta v", Long.class);
        Long totalRenglones = consulta2.getSingleResult();
        System.out.println("total de renglones de la tabla ventas:" + totalRenglones);
        
        //ejemplo de funcion de agregado AVG
        TypedQuery<Double> consulta3 = em.createQuery("SELECT AVG(v.cantidad) FROM Venta v", Double.class);
        Double promedio = consulta3.getSingleResult();
        System.out.println("promedio de columna cantidad:" + promedio);
        
        //ejemplo de funcion de agregado MAX
        TypedQuery<Integer> consulta4 = em.createQuery("SELECT MAX(v.cantidad) FROM Venta v", Integer.class);
        Integer cantidadMaxima = consulta4.getSingleResult();
        System.out.println("cantidad maxima:" + cantidadMaxima);

    }

}
