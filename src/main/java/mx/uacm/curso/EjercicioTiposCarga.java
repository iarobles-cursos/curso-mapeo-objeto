/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.uacm.curso.daos.ArticuloDAOImpl;
import mx.uacm.curso.entidades.Articulo;

/**
 *
 * @author iarobles
 */
public class EjercicioTiposCarga {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog-pruebas-memoria");
        EntityManager em = emf.createEntityManager(); 
        ArticuloDAOImpl articuloDAO = new ArticuloDAOImpl(em);
        System.out.println("inicio consulta articulo");
        Articulo a = articuloDAO.buscarPorId(1);
        System.out.println("fin consulta articulo");
        
        System.out.println("total de categorias del articulo:" + a.getCategorias().size());
        
    }
}
