/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.daos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.uacm.curso.entidades.Articulo;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
//usamos un static import para importar todos
//los metodos estaticos de la clase Assertions
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 *
 * @author Alumno
 */
//configuramos junit para ordenar usando annotations
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//ordenamos la ejecucion de los tests por orden alfabetico
//@TestMethodOrder(MethodOrderer.Alphanumeric.class)
//ordenamos de manera aleatoria
//@TestMethodOrder(MethodOrderer.Random.class)
public class ArticuloDAOTest {

    private static EntityManager em;

    private static ArticuloDAO articuloDAO;

    //ArticuloDAOTest.inicializar();
    //junit al usar el annotation @BeforeAll necesita que
    //sea estatico el metodo
    @BeforeAll
    public static void inicializar() {
        System.out.println("inicializar");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog-pruebas-memoria");
        em = emf.createEntityManager();
        articuloDAO = new ArticuloDAOImpl(em);
    }

    @BeforeEach //este annotation no puede estar en metodos estaticos
    public  void antesDeCadaTest() {
        System.out.println("antes del test");
        em.getTransaction().begin(); //iniciamos transaccion
    }

    @AfterEach
    public  void despuesDeCadaTest() {
        System.out.println("despues del test");
        em.getTransaction().rollback();
    }

    @AfterAll
    //ejecuta despues de todos los tests
    public static void terminar() {
        //rollback es para deshacer todos los cambios
        //dentro de la transaccion
        System.out.println("terminar");
    }

    @Test
    @Order(1)
    public void buscarArticuloTest() {

        System.out.println("buscar por articulo");
        Articulo a = articuloDAO.buscarPorId(1);
        //checamos que la variable a no sea NULL
        assertNotNull(a);
        //revisamos que el id del objeto sea el correcto
        //primer argumento = el valor esperado
        //segundo argumento = el valor real
        assertEquals(1, a.getId());
        
        
        //AGREGAR TEST PARA VERIFICAR QUE SE OBTIENE DatosArticulo
        
        //revisamos que haya 2 comentarios
        assertEquals(2,a.getComentarios().size());
        
     
    }

    @Test
    @Order(2)
    public void aguardarArticuloTest() {
        System.out.println("guardar articulo test");
        Articulo a = new Articulo();
        a.setContenido("contenido test");
        a.setTitulo("titulo test");
        a.setFechaCreacion(new Date());

        Articulo a2 = articuloDAO.guardar(a);
        //verificamos que el articulo se guardo
        //revisamos que no sea null
        assertNotNull(a2);
        //revisamos que tenga un id
        assertNotNull(a2.getId());
        //revisamos que el contenido se guardo bien
        assertEquals(a.getContenido(), a2.getContenido());
        assertEquals(a.getTitulo(), a2.getTitulo());
        assertEquals(a.getFechaCreacion(), a2.getFechaCreacion());
    }

    @Test
    //@Disabled("deshabilitado hasta que se corriga el bug 5-510")
    @Order(3)
    public void removerArticuloTest() {
        System.out.println("remover articulo test");
        //verifique que funciona el remover con el renglon
        //que insertaron en la base        
        //el renglon 3 siempre se genera en la base de datos
        //en memoria ram
        Articulo a = articuloDAO.buscarPorId(3);
        articuloDAO.remover(a);
        Articulo a2 = articuloDAO.buscarPorId(3);
        //revisamos que el articulo se haya borrado
        assertNull(a2);
        
    }
    
    @Test
    @Order(4)
    public void totalArticulosTest(){
        Long totalArticulos = articuloDAO.totalArticulos();
        assertEquals(3,totalArticulos);
    }
    
    @Test
    @Order(5)
    public void obtenArticulosPorFechaMinimaTest(){
        //26 de Octubre de 1985
        // en GregorianCalendar, el mes esta basado en indice cero
        GregorianCalendar cal = new GregorianCalendar(1985,9,26);
        Date fechaMinima = cal.getTime();
        
        //desde java 1.8 como alternativa a Date, existe el objeto LocalDate
        LocalDate fecha = LocalDate.of(1985,10,26);
        fechaMinima = Date.from(fecha.atStartOfDay(ZoneId.systemDefault()).toInstant());               
        
        List<Articulo> articulos = articuloDAO.obtenArticulosPorFechaMinima(fechaMinima);
        System.out.println("articulos:" + articulos);
        assertEquals(3,articulos.size());
        
        //2013-10-24
        cal = new GregorianCalendar(2013,9,24);
        fechaMinima = cal.getTime();
        articulos = articuloDAO.obtenArticulosPorFechaMinima(fechaMinima);
        System.out.println("articulos:" + articulos);
        assertEquals(2,articulos.size());
        
        
    }

}
