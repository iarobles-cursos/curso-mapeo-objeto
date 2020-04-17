/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.entidades;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author iarobles
 */
@Entity
@Table(name = "ventas")
public class Venta {

    @EmbeddedId
    private VentaPK id;

    @Column(name = "nombre_producto")
    private String nombreProducto;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Override
    public String toString() {
        return "{id:" + this.id + ", nombre producto:" + this.nombreProducto +", cantidad:" + this.cantidad + "}";
    }
    
    

    public VentaPK getId() {
        return id;
    }

    public void setId(VentaPK id) {
        this.id = id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

}
