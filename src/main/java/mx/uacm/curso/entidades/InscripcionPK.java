package mx.uacm.curso.entidades;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author iarobles
 */
@Embeddable
public class InscripcionPK implements Serializable {

    @Column(name = "matricula")
    private String matricula;

    @Column(name = "curso")
    private String curso;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

}
