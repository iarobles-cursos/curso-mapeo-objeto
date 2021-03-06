/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.curso.entidades;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 */
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "sec_usu", sequenceName = "usuarios_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "sec_usu", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "nombre")
    private String nombre;

    //relacionamos la entidad Usuario
    // con la entidad DatosUsuario
    //@OneToOne(cascade = {CascadeType.PERSIST})
    @OneToOne
    @JoinColumn(name = "datos_autor_id")
    private DatosUsuario datosUsuario;

    //se debe de tener mucho cuidado con la propiedad fetch y la estregia eager loading.
    @OneToMany(mappedBy = "usuario", cascade = {CascadeType.PERSIST})
    @OrderBy("fechaCreacion DESC")
    private List<Articulo> articulos;

    @ManyToMany(mappedBy = "usuarios")
    private List<Departamento> departamentos;

    @ElementCollection
    @CollectionTable(
            name = "telefonos",
            joinColumns = @JoinColumn(name = "usuario_id")
    )
    @Column(name = "telefono")
    private List<String> telefonos;

    @ElementCollection
    @CollectionTable(
            name = "emails_adicionales",
            joinColumns = @JoinColumn(name = "usuario_id")
    )
    @Column(name = "email")
    private List<String> emailsAdicionales;

    public List<String> getEmailsAdicionales() {
        return emailsAdicionales;
    }

    public void setEmailsAdicionales(List<String> emailsAdicionales) {
        this.emailsAdicionales = emailsAdicionales;
    }

    public List<String> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<String> telefonos) {
        this.telefonos = telefonos;
    }

    @Override
    public String toString() {
        return "{id:" + this.id + ", nombre:" + this.nombre + ", email:" + this.email + "}";
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    public List<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(List<Articulo> articulos) {
        this.articulos = articulos;
    }

    public DatosUsuario getDatosUsuario() {
        return datosUsuario;
    }

    public void setDatosUsuario(DatosUsuario datosUsuario) {
        this.datosUsuario = datosUsuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
