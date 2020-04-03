package mx.uacm.curso.entidades;

import java.io.Serializable;
import java.util.Objects;
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

    @Override
    public boolean equals(Object obj) {
        //sobrescribimos este metodo para asegurar consistencia en las llaves compuestas
        if (!(obj instanceof InscripcionPK)) { //si es null o si no es una instancia de InscripcionPK
            return false;
        }

        InscripcionPK id2 = (InscripcionPK) obj;
        InscripcionPK id1 = this;
        
        //revisar id1.matricula y id2.matricula no sean null y que id1.matricula==id2.matricula
        //revisar id1.curso y id2.curso no sean null y que id1.curso==id2.curso
        return Objects.equals(id1.getMatricula(), id2.getMatricula()) && Objects.equals(id1.getCurso(), id2.getCurso());
    }

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
