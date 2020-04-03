/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author iarobles
 */
@Embeddable
public class VentaPK implements Serializable {

    @Column(name = "orden")
    private Integer orden;

    @Column(name = "codigo_barras")
    private String codigoBarras;

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof VentaPK)) {
            return false;
        }
        VentaPK id1 = this;
        VentaPK id2 = (VentaPK) obj;

        return Objects.equals(id1.getOrden(), id2.getOrden()) && Objects.equals(id1.getCodigoBarras(), id2.getCodigoBarras());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getOrden(),this.getCodigoBarras());
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

}
