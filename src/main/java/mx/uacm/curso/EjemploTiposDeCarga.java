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
import mx.uacm.curso.daos.UsuarioDAO;
import mx.uacm.curso.daos.UsuarioDAOImpl;
import mx.uacm.curso.entidades.Articulo;
import mx.uacm.curso.entidades.Usuario;

/**
 *
 * @author iarobles
 */
public class EjemploTiposDeCarga {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog-pruebas-memoria");
        EntityManager em = emf.createEntityManager();
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl(em);
        
        System.out.println("inicio buscar usuario");
        //note que datos_usuarios se obtiene usando eager loading
        Usuario u = usuarioDAO.buscarPorId(1);
        System.out.println("fin buscar usuario");
        
        //note que articulos se trae usando una estrategia lazy loading
        System.out.println("obteniendo articulos");
        System.out.println("total de articulos del usuario:" + u.getArticulos().size());
        System.out.println("find de obtener articulos");
        
       
    }

}
