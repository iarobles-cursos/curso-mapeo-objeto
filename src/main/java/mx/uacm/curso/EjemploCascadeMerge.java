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
public class EjemploCascadeMerge {

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
        //el merge no cambia el estado de las entidadades de las que depende
        //articulo
        //a2 SI esta en estado administardo.
        Articulo a2 = em.merge(a);
        //la lista de comentarios en a2, sus entidades tambien estan en estado
        //administrado
        
        //la entidad comentario en la variable c, NO esta en estado administrado
        c.setComentario("siempre no, mejor otro comentario");
        
        int indiceUltimoComentario = a2.getComentarios().size() - 1;
        Comentario c2 = a2.getComentarios().get(indiceUltimoComentario);
        
        c2.setComentario("mejor otro comentario (administrado)");
        
        em.getTransaction().commit();

    }

}
