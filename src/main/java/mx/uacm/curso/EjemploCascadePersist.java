/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.uacm.curso.daos.ArticuloDAO;
import mx.uacm.curso.daos.ArticuloDAOImpl;
import mx.uacm.curso.entidades.Articulo;
import mx.uacm.curso.entidades.Comentario;

/**
 *
 * @author iarobles
 */
public class EjemploCascadePersist {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog-pruebas-deshacer-crear");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        ArticuloDAO articuloDAO = new ArticuloDAOImpl(em);
        Articulo a = articuloDAO.buscarPorId(1);
        
        //el mapeo de jpa, permite actualizar información de las entidades
        //relacionadas con la entidad que se consulta
        for (Comentario comentario : a.getComentarios()) {
            comentario.setComentario(comentario.getComentario() + " actualizado");
        }
        
        //AGREGAMOS COMENTARIO por medio de la lista comentarios
        Comentario c = new Comentario();
        c.setComentario("nuevo comentario");
        c.setArticulo(a);
        
        a.getComentarios().add(c);
        //guardamos cambios en la base
        //recordemos que persist, la entidad que recibe la pone en estado 
        //administardo
        em.persist(a);
        //al guardar la entidad con un persist y la opcion de cascade=PERSIST,
        //tambien propaga la operacion persist a las entidades asociadas
        
        //cuando cascade=PERSIST, este comentario se pone en estado administrado
        c.setComentario("siempre no, mejor otro comentario");
  
        
        em.getTransaction().commit();

    }

}
