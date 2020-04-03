/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.daos;

import javax.persistence.EntityManager;
import mx.uacm.curso.entidades.Venta;
import mx.uacm.curso.entidades.VentaPK;

/**
 *
 * @author iarobles
 */
public class VentaDAOImpl extends GenericDAOImpl<Venta,VentaPK> implements VentaDAO{ 
    
    public VentaDAOImpl(EntityManager em) {
        super(em, Venta.class);
    }
    
}
