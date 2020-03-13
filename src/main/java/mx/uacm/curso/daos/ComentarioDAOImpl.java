/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.daos;

import javax.persistence.EntityManager;
import mx.uacm.curso.entidades.Comentario;

public class ComentarioDAOImpl extends GenericDAOImpl<Comentario, Integer> implements ComentarioDAO {

    public ComentarioDAOImpl(EntityManager em) {
        super(em, Comentario.class);
    }

}
