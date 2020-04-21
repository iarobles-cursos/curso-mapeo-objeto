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
public class ArticuloDTO {
    
    private Integer id;
    
    private String titulo;
    
    public ArticuloDTO(){
    }
    
    public ArticuloDTO(Integer id, String titulo){
        this.id = id;
        this.titulo=titulo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    
    
}
