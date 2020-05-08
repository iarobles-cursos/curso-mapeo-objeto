/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.spring.impl;

/**
 *
 * @author iarobles
 */
public class ServicioEmailImpl {

    FiltroSpamImpl filtro;

    public void procesarEmail(Integer id) {

        //imaginemos que se obtuvo texto de emails de la base
        //y que se van a evaluar para determinar si son spam
        //por la herramienta de filtros de spam:
        String textoEmail = "email texto 1";
        if(filtro.posibleSpam(textoEmail)){
            System.out.println("es spam!");
        } else {
            System.out.println("todo bien con el correo!");
        }

    }

}
