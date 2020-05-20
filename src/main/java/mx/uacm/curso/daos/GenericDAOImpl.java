/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Alumno
 */
@Transactional
public abstract class GenericDAOImpl<T, PK> implements GenericDAO<T,PK> {
    
    @PersistenceContext
    protected EntityManager em;
    
    private Class<T> clase;
    
    
    public GenericDAOImpl(EntityManager em, Class<T> clase){
        this.em = em;
        this.clase = clase;
    }

    
    public T buscarPorId(PK id) {
        return this.em.find(this.clase, id);
    }

    //@Transactional(propagation = Propagation.NEVER)    
    public T guardar(T a) {
        return this.em.merge(a);
    }
    
    public void remover(T a) {
        this.em.remove(a);
    }
}
