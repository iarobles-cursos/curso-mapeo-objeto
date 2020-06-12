/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.entidades;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "datos_usuarios")
public class DatosUsuario {

    @Id
    @SequenceGenerator(name = "datosUsuarioIdSecuencia", sequenceName = "datos_usuarios_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "datosUsuarioIdSecuencia")
    @Column(name = "id")
    private Integer id;

    @Column(name = "biografia")
    private String biografia;

    @Column(name = "fecha_registro")
    private Date fechaRegistro;

    //@OneToOne(mappedBy = "datosUsuario", cascade={CascadeType.PERSIST})
    @OneToOne(mappedBy = "datosUsuario", cascade = {CascadeType.REMOVE})
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "{id:" + this.id + ", biografia:" + this.biografia + "}";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

}
