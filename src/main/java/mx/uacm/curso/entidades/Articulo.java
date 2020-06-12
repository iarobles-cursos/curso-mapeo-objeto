/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.entidades;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 */
//@Entity(name="BlogArticulo")
@Entity(name = "Articulo")
@Table(name = "articulos")
public class Articulo {

    @Id
    //el annotation @SequenceGenerator le a JPA el nombre de la secuencia generadora de la base de datos
    @SequenceGenerator(name = "sec_art", sequenceName = "articulo_id_seq", allocationSize = 1)
    //el annotation @GeneratedValue, le indica a JPA que tipo de estrategia generadora vamos a usar
    //en este caso le estamos indicando que vamos a usar una estrategia del tipo secuencia (GenerationType.SEQUENCE)
    @GeneratedValue(generator = "sec_art", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "contenido")
    private String contenido;

    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    //EJERCICIO
    //MAPEAR Articulo con DatosArticulo
    @OneToOne
    @JoinColumn(name = "datos_articulo_id")
    private DatosArticulo datosArticulo;

    //como articulo no es entidad dueña
    //mappedBy se llena del nombre de la propiedad
    //         que en la entidad dueña se usa para mapear
    //         esta entidad
    @OneToMany(mappedBy = "articulo")
    @OrderBy("fechaCreacion DESC")
    private List<Comentario> comentarios;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    //tener mucho cuidado si se pone la operacion en cascada REMOVE
    //sol ejercicio: habilitamos estrategia de carga eager en las categorias del articulo
    //articulo es la entidad que no es dueña (entidad fuerte)
    //@ManyToMany(mappedBy = "articulos", cascade = {CascadeType.MERGE})
    @ManyToMany(mappedBy = "articulos")
    private List<Categoria> categorias;

    @Override
    public String toString() {
        return "{" + "id:" + this.id + ", titulo:" + this.titulo + ", fecha:" + this.fechaCreacion + "}";
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public DatosArticulo getDatosArticulo() {
        return datosArticulo;
    }

    public void setDatosArticulo(DatosArticulo datosArticulo) {
        this.datosArticulo = datosArticulo;
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

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

}
