/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.daos;

import javax.persistence.EntityManager;
import mx.uacm.curso.entidades.DatosArticulo;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("datosArticuloDAO")
@Transactional //habilitamos transacciones para cada metodo de este dao
public class DatosArticuloDAOImpl extends GenericDAOImpl<DatosArticulo, Integer> implements DatosArticuloDAO {

    public DatosArticuloDAOImpl(EntityManager em) {
        super(em, DatosArticulo.class);
    }
}
