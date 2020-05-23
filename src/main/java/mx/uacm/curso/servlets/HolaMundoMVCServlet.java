/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author iarobles
 */
public class HolaMundoMVCServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String mensaje="hola mundo 2!"; //simulamos que el mensaje lo obtuvimos del modelo
        
        req.setAttribute("msg", mensaje);//pasamos informacion a la vista
        
        RequestDispatcher despachador = req.getRequestDispatcher("/jsp/hola.jsp");
        despachador.forward(req, resp);        
    }
    
    
    
}
