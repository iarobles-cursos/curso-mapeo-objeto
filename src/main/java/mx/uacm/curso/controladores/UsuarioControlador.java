/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.controladores;

import java.util.List;
import mx.uacm.curso.daos.UsuarioDAO;
import mx.uacm.curso.entidades.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author iarobles
 */
@Controller
public class UsuarioControlador {
    
    @Autowired
    private UsuarioDAO usuarioDAO;
    
    @RequestMapping(value="/usuarios")
    public String mostrarUsuarios(Model modelo){
        
        System.out.println("invocando controlador de usuarios");
        
        List<Usuario> listaUsuarios = usuarioDAO.obtenerTodos();
        modelo.addAttribute("usuarios", listaUsuarios);
        
        return "usuarios";        
    }
    
}
