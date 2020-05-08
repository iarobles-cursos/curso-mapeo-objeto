/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.spring.impl;

import mx.uacm.curso.spring.SanitizadorTextos;

/**
 *
 * @author iarobles
 */
public class SanitizadorTextosImpl  implements SanitizadorTextos{

    @Override
    public String sanitizarTexto(String texto) {
        System.out.println("sanitizando texto:" + texto);
        //supuestamete ya limpiamos el texto y lo regresamos limpio
        return texto;
    }

}
