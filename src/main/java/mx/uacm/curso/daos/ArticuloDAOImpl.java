/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.daos;

import javax.persistence.EntityManager;
import mx.uacm.curso.entidades.Articulo;

/**
 *
 * @author Alumno
 */
public class ArticuloDAOImpl implements ArticuloDAO{
    
    private EntityManager em;
    
    public ArticuloDAOImpl(EntityManager em){
        this.em = em;
    }

    @Override
    public Articulo buscarPorId(Integer id) {
        return this.em.find(Articulo.class, id);
    }

    @Override
    public Articulo guardar(Articulo a) {
        return this.em.merge(a);
    }

    @Override
    public void remover(Articulo a) {
        this.em.remove(a);
    }    
    
}
