/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.daos;

import javax.persistence.EntityManager;
import mx.uacm.curso.entidades.DatosUsuario;

public class DatosUsuarioDAOImpl extends GenericDAOImpl<DatosUsuario, Integer> implements DatosUsuarioDAO{

    public DatosUsuarioDAOImpl(EntityManager em) {
        super(em, DatosUsuario.class);
    }

}
