/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.uacm.curso.entidades.Articulo;
import mx.uacm.curso.entidades.Usuario;


public class IntroJPA {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog-pruebas");
        EntityManager em = emf.createEntityManager();        
        
        //buscamos el articulo cuya columna id=1
        Articulo a = em.find(Articulo.class,1);
        System.out.println("titulo:" + a.getTitulo());
        
        //buscamos el usuario cuyo id es 1
        Usuario u = em.find(Usuario.class,1);
        System.out.println("nombre:" + u.getNombre());
        
        //para poder modificar la base de datos, necesitamos iniciar una transaccion
        em.getTransaction().begin();//inicia la transaccion
        
        Articulo a2=new Articulo();
        a2.setTitulo("titulo nuevo");
        a2.setContenido("contenido nuevo");
        a2.setFechaCreacion(new Date());
        em.merge(a2);                
        
        em.getTransaction().commit(); //termina transaccion
        
        
    }
}
