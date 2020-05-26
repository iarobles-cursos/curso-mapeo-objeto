/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author iarobles
 */
@Controller
public class InicioControlador {
    
    // definimos que este controlador va antender la url:
    // http://localhost:8080/CONTEXT-ROOT/spring/inicio
    @RequestMapping(method = RequestMethod.GET, value="/inicio")
    public String inicio(){
        System.out.println("invocando inicio de controlador");
        
        return "inicio";
    }
    
    
}
