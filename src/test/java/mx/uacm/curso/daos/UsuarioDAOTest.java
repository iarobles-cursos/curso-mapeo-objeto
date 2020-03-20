/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.daos;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.uacm.curso.entidades.DatosUsuario;
import mx.uacm.curso.entidades.Usuario;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
//usamos un static import para importar todos
//los metodos estaticos de la clase Assertions
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UsuarioDAOTest {

    private static EntityManager em;

    private static UsuarioDAO usuarioDAO;

    @BeforeAll
    public static void inicializar() {
        System.out.println("inicializar");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog-pruebas-memoria");
        em = emf.createEntityManager();
        usuarioDAO = new UsuarioDAOImpl(em);
    }

    @BeforeEach
    public void antesDeCadaTest() {
        System.out.println("antes del test");
        em.getTransaction().begin(); //iniciamos transaccion
    }

    @AfterEach
    public void despuesDeCadaTest() {
        System.out.println("despues del test");
        em.getTransaction().rollback();
    }

    @AfterAll
    //ejecuta despues de todos los tests
    public static void terminar() {
        System.out.println("terminar");
    }

    @Test
    @Order(1)
    public void buscarUsuarioTest() {

        System.out.println("buscar usuario por id");
        Usuario u = usuarioDAO.buscarPorId(1);
        //checamos que la variable a no sea NULL
        assertNotNull(u);
        //revisamos que el id del objeto sea el correcto
        //primer argumento = el valor esperado
        //segundo argumento = el valor real
        assertEquals(1, u.getId());
        
        assertNotNull(u.getDatosUsuario());
        
        System.out.println("biografia:" + u.getDatosUsuario().getBiografia());
        
        //verificamos que el mapeo de usuario a departamentos funciona
        assertNotNull(u.getDepartamentos());
        assertEquals(3,u.getDepartamentos().size());

    }

}
