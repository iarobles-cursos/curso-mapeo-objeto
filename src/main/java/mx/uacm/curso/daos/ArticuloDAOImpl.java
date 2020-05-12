/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.daos;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import mx.uacm.curso.entidades.Articulo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Alumno
 */
@Component("articuloDAO")
public class ArticuloDAOImpl extends GenericDAOImpl<Articulo, Integer> implements ArticuloDAO{
    
    @Autowired
    public ArticuloDAOImpl(EntityManager em) {
        //invocamos al constructor del padre
        super(em, Articulo.class);
    }

    @Override
    public Long totalArticulos() {
        TypedQuery<Long> consulta = em.createQuery("SELECT COUNT(a) FROM Articulo a",Long.class);
        return consulta.getSingleResult();
    }

    @Override
    public List<Articulo> obtenArticulosPorFechaMinima(Date fechaMinima) {
        //ejemplo de consulta parametrizada con parametros por posición
//        TypedQuery<Articulo> consulta = em.createQuery("SELECT a FROM Articulo a WHERE a.fechaCreacion>=?1",Articulo.class);
//        consulta.setParameter(1, fechaMinima);
//        List<Articulo> articulos = consulta.getResultList();
        
        //chaining
        //return consulta.setParameter(1,fechaMinima).getResultList();
        

        //ejemplo de consulta parametrizada con parametros por nombre
        TypedQuery<Articulo> consulta = em.createQuery("SELECT a FROM Articulo a WHERE a.fechaCreacion>=:fecha",Articulo.class);
        consulta.setParameter("fecha", fechaMinima);
        List<Articulo> articulos = consulta.getResultList();        
        
        return articulos;        
    }

    @Override
    public Long totalArticulosSinComentarios() {
        
        TypedQuery<Long> consulta = em.createQuery("SELECT COUNT(a) FROM Articulo a WHERE a.comentarios IS EMPTY",Long.class);
        return consulta.getSingleResult();        
    }

    @Override
    public Long totalArticulosConComentarios() {        
        
        TypedQuery<Long> consulta = em.createQuery("SELECT COUNT(a) FROM Articulo a WHERE a.comentarios IS NOT EMPTY",Long.class);
        return consulta.getSingleResult();        
    }

    @Override
    public Long totalComentariosPorArticulo(Integer articuloId) {
        TypedQuery<Long> consulta = em.createQuery("SELECT COUNT(c) FROM Articulo a INNER JOIN a.comentarios c WHERE a.id=:id", Long.class);
        consulta.setParameter("id", articuloId);
        return consulta.getSingleResult();
    }
}
