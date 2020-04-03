package mx.uacm.curso.entidades;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author iarobles
 */
@Entity
@Table(name = "inscripciones")
public class Inscripcion {

    @EmbeddedId
    private InscripcionPK id;

    @Column(name = "fecha_inscripcion")
    private Date fechaInscripcion;

    public InscripcionPK getId() {
        return id;
    }

    public void setId(InscripcionPK id) {
        this.id = id;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

}
