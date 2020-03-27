/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.uacm.curso.daos.ArticuloDAO;
import mx.uacm.curso.daos.ArticuloDAOImpl;
import mx.uacm.curso.entidades.Articulo;
import mx.uacm.curso.entidades.Categoria;
import mx.uacm.curso.entidades.Comentario;

/**
 *
 * @author iarobles
 */
public class EjemploCascadeManyToManyMerge {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog-pruebas-deshacer-crear");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        //guardarCategoria(em);
        guardarArticulo(em);
        
        em.getTransaction().commit();

    }
    
    public static void guardarCategoria(EntityManager em){
        
        Categoria c= new Categoria();
        c.setNombre("testing");
        
        Articulo a = new Articulo();
        a.setTitulo("titulo articulo prueba (muchos a muchos)");
        
        List<Articulo> articulos = new ArrayList<Articulo>();
        articulos.add(a);
        
        c.setArticulos(articulos);
        //guardamos usando Categoria que es la entidad dueña de la relación
        em.merge(c);
    }
    
    public static void guardarArticulo(EntityManager em){
        //partimos de una entidad que no es dueña
        Articulo a = new Articulo();
        a.setTitulo("titulo articulo prueba");
        
        Categoria c = new Categoria();
        c.setNombre("prueba categoria");
        //asociamos la categoria con un articulo
        List<Articulo> articulos = new ArrayList<Articulo>();
        articulos.add(a);
        c.setArticulos(articulos);
        
        List<Categoria> categorias = new ArrayList<Categoria>();
        categorias.add(c);
        
        a.setCategorias(categorias);
        //guardamos partiendo de una entidad que no es dueña
        em.merge(a);
    }
    
    

}
