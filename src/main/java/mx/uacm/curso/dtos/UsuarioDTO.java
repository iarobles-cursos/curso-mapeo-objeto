/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.dtos;

/**
 *
 * @author iarobles
 */
public class UsuarioDTO {

    private Integer id;

    private String nombre;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Integer id, String nombre) {
        this.id=id;
        this.nombre=nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
