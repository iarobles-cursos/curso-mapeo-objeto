/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso;

import java.util.ArrayList;
import java.util.List;
import mx.uacm.curso.entidades.Articulo;
import mx.uacm.curso.entidades.Usuario;

/**
 *
 * @author iarobles
 */
public class EjemploToString {
    
    public static void main(String[] args) {
        
        Articulo a = new Articulo();
        a.setId(4);
        a.setTitulo("titulo articulo prueba");
        
        System.out.println("articulo:" + a);
        
        System.out.println("codigo hash de articulo:" + a.hashCode());
        
        Articulo a2= new Articulo();
        a2.setId(5);
        a2.setTitulo("titulo otro articulo de prueba");
        
        //asi se declaraban listas en java 1.5
        //List<Articulo> articulos = new ArrayList<Articulo>();
        
        //desde la version 1.7 de Java, se declaran listas de manera implicita
        List<Articulo> articulos = new ArrayList<>();
        articulos.add(a);
        articulos.add(a2);
        
        System.out.println("lista articulos:" + articulos);
        
        
        Usuario u = new Usuario();
        u.setId(7);
        u.setNombre("bart simpson");
        u.setEmail("bart@mail.com");
        
        System.out.println("usuario:" + u);
        
        
    }
    
}
