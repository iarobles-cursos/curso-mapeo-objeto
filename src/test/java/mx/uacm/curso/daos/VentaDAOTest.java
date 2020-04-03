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
import mx.uacm.curso.entidades.Articulo;
import mx.uacm.curso.entidades.DatosUsuario;
import mx.uacm.curso.entidades.Usuario;
import mx.uacm.curso.entidades.Venta;
import mx.uacm.curso.entidades.VentaPK;
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
public class VentaDAOTest {

    private static EntityManager em;

    private static VentaDAO ventaDAO;

    @BeforeAll
    public static void inicializar() {
        System.out.println("inicializar");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog-pruebas-memoria");
        em = emf.createEntityManager();
        ventaDAO = new VentaDAOImpl(em);
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
    public void consistenciaLLavePrimariaTest() {
        VentaPK id1 = new VentaPK();
        id1.setOrden(1);
        id1.setCodigoBarras("001 2348");

        VentaPK id2 = new VentaPK();
        id2.setOrden(1);
        id2.setCodigoBarras("001 2348");

        VentaPK id3 = new VentaPK();
        id3.setOrden(1);
        id3.setCodigoBarras("001 2348");

        //revisamos que se cumpla la condicion de que a.equals(null)==false
        assertFalse(id1.equals(null));

        //revisamos que equals es una relacion de equivalencia
        //propiedad reflexiva
        //revisamos que id1.equals(id1) == true
        assertTrue(id1.equals(id1));

        //propiedad simetrica
        //revisamos id1.equals(id2) es true, entonces id2.equals(id1) es true
        assertTrue(id1.equals(id2));
        assertTrue(id2.equals(id1));

        //propiedad transitiva
        //si id1.equals(id2) es true y si id2.equals(id3) es true entonces
        // id1.equals(id3) tambien es true
        assertTrue(id1.equals(id2));
        assertTrue(id2.equals(id3));
        //por transitividad, se debe de cumplir:
        assertTrue(id1.equals(id3));
                
        assertEquals(id1.hashCode(),id2.hashCode());

    }

    @Test
    @Order(2)
    public void buscarVentaTest() {

        System.out.println("buscando venta");
        VentaPK id = new VentaPK();
        id.setOrden(1);
        id.setCodigoBarras("001 2348");
        Venta v = ventaDAO.buscarPorId(id);
        assertNotNull(v);
        assertEquals("Papas", v.getNombreProducto());

    }

}
