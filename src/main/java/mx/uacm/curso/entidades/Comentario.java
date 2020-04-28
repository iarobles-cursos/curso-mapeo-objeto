package mx.uacm.curso.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="comentarios")
public class Comentario {

    @Id
    @SequenceGenerator(name = "comentarioIdSecuencia", sequenceName = "comentario_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comentarioIdSecuencia")
    @Column(name = "id")
    private Integer id;

    @Column(name = "comentario")
    private String comentario;

    @Column(name = "comentarista")
    private String comentarista;

    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    //muchos comentarios, se corresponden con 1 articulo
    //por eso es muchos a uno 
    @ManyToOne
    @JoinColumn(name = "articulo_id")
    private Articulo articulo;

    @Override
    public String toString() {
        return "{" + "id:" + this.id + ", comentario:" + this.comentario + ", fechaCreacion:" + this.fechaCreacion +"}";
    }
    
    

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getComentarista() {
        return comentarista;
    }

    public void setComentarista(String comentarista) {
        this.comentarista = comentarista;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

}
