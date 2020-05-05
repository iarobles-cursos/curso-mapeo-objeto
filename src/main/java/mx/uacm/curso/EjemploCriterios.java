/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso;

import java.io.*;
import java.util.*;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import mx.uacm.curso.dtos.ArticuloDTO;
import mx.uacm.curso.entidades.Articulo;
import mx.uacm.curso.entidades.Venta;

/**
 *
 * @author iarobles
 */
public class EjemploCriterios {

    public static void main(String[] args) throws IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog-pruebas-memoria");
        EntityManager em = emf.createEntityManager();

        //SELECT v FROM Venta v WHERE v.id.orden=1
        boolean incluirWhere = false;
        CriteriaBuilder constructor = em.getCriteriaBuilder();
        CriteriaQuery<Venta> criterio = constructor.createQuery(Venta.class);
        Root<Venta> v = criterio.from(Venta.class);
        criterio.select(v);
        if (incluirWhere) {
            //criterio.where(constructor.equal(v.get("id").get("orden"), 1));
            //WHERE v.id.orden>1
            criterio.where(constructor.greaterThan(v.get("id").<Integer>get("orden"), 1));
        }

        TypedQuery<Venta> consulta = em.createQuery(criterio);
        List<Venta> ventas = consulta.getResultList();

        for (Venta venta : ventas) {
            System.out.println("producto:" + venta.getNombreProducto());
        }

        //ejemplo 3
        //SELECT v.nombreProducto FROM Venta v       
        CriteriaQuery<String> criterio2 = constructor.createQuery(String.class);
        Root<Venta> v2 = criterio2.from(Venta.class);
        criterio2.select(v2.<String>get("nombreProducto"));

        TypedQuery<String> consulta2 = em.createQuery(criterio2);
        List<String> nombreProductos = consulta2.getResultList();
        System.out.println("productos:" + nombreProductos);

        //EJEMPLO 3
        //SELECT new com.proyecto.ArticuloDTO(a.id, a.titulo) FROM Articulo a 
        CriteriaQuery<ArticuloDTO> criterio3 = constructor.createQuery(ArticuloDTO.class);
        Root<Articulo> a = criterio3.from(Articulo.class);
        criterio3.select(constructor.construct(ArticuloDTO.class,a.get("id"),a.get("titulo")));
        
        TypedQuery<ArticuloDTO> consulta3 = em.createQuery(criterio3);
        List<ArticuloDTO> articulosdtos = consulta3.getResultList();
        for(ArticuloDTO ad : articulosdtos){
            System.out.println("titulo:" + ad.getTitulo());
        }

    }

}
