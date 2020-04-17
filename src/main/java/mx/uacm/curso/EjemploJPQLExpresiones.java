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
import javax.persistence.TypedQuery;
import mx.uacm.curso.daos.UsuarioDAO;
import mx.uacm.curso.daos.UsuarioDAOImpl;
import mx.uacm.curso.entidades.Usuario;
import mx.uacm.curso.entidades.Venta;

/**
 *
 * @author iarobles
 */
public class EjemploJPQLExpresiones {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog-pruebas-memoria");
        EntityManager em = emf.createEntityManager();

        //ejemplo de uso LIKE   
        // el simbolo % significa cualquier secuencia de letras
        TypedQuery<Usuario> consulta = em.createQuery("SELECT u FROM Usuario u WHERE u.email LIKE '%email.com'", Usuario.class);
        List<Usuario> usuarios = consulta.getResultList();
        System.out.println("usuarios:" + usuarios);

        //ejemplo LIKE con _
        // el simbolo _ es para una letra arbitraria
        TypedQuery<Usuario> consulta2 = em.createQuery("SELECT u FROM Usuario u WHERE u.email LIKE '_u%email.com'", Usuario.class);
        List<Usuario> usuarios2 = consulta2.getResultList();
        System.out.println("usuarios:" + usuarios2);

        //ejemplo de uso de like en consulta parametrizada
        TypedQuery<Usuario> consulta3 = em.createQuery("SELECT u FROM Usuario u WHERE u.email LIKE :patron", Usuario.class);
        consulta3.setParameter("patron", "_u%email.com");
        List<Usuario> usuarios3 = consulta3.getResultList();
        System.out.println("usuarios 3:" + usuarios3);

        //ejemplo BETWEEN
        TypedQuery<Venta> consulta4 = em.createQuery("SELECT u FROM Venta u WHERE u.cantidad BETWEEN 2 AND 100", Venta.class);
        List<Venta> ventas = consulta4.getResultList();
        System.out.println("ventas:" + ventas);

        TypedQuery<Venta> consulta5 = em.createQuery("SELECT u FROM Venta u WHERE u.cantidad BETWEEN :minVal AND :maxVal", Venta.class);
        consulta5.setParameter("minVal", 2);
        consulta5.setParameter("maxVal", 100);
        List<Venta> ventas2 = consulta5.getResultList();
        System.out.println("ventas 2:" + ventas2);

        //ejemplo de IN
        TypedQuery<Venta> consulta6 = em.createQuery("SELECT u FROM Venta u WHERE u.cantidad IN(2,3,5,7)", Venta.class);
        List<Venta> ventas3 = consulta6.getResultList();
        System.out.println("ventas 3:" + ventas3);

        TypedQuery<Venta> consulta7 = em.createQuery("SELECT u FROM Venta u WHERE u.cantidad IN(:valores)", Venta.class);
        List<Integer> valores = new ArrayList<>();
        valores.add(2);
        valores.add(3);
        valores.add(5);
        valores.add(7);
        consulta7.setParameter("valores",valores);
        List<Venta> ventas4 = consulta7.getResultList();
        System.out.println("ventas 4:" + ventas4);
        
        //ejemplo para IS NULL
        em.getTransaction().begin();
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl(em);
        Usuario u = new Usuario();        
        u.setNombre("Paco");
        u.setEmail("paco@mail.com");
        usuarioDAO.guardar(u);
        
        TypedQuery<Usuario> consulta8 = em.createQuery("SELECT u FROM Usuario u WHERE u.datosUsuario IS NULL",Usuario.class);
        List<Usuario> usuariosSinDatosUsuario = consulta8.getResultList();
        System.out.println("usuarios sin datos:" + usuariosSinDatosUsuario);        
        em.getTransaction().commit();
        
        //ejemplo para IS EMPTY
        TypedQuery<Usuario> consulta9 = em.createQuery("SELECT u FROM Usuario u WHERE u.emailsAdicionales IS EMPTY",Usuario.class);
        List<Usuario> usuariosSinEmailsAdicionales = consulta9.getResultList();
        System.out.println("usarios sin emails adicionales:" + usuariosSinEmailsAdicionales);
                

    }

}
