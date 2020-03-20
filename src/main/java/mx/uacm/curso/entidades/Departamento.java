package mx.uacm.curso.entidades;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity(name = "departamentos")
public class Departamento {

    @Id
    @SequenceGenerator(name = "departamentoIdSecuencia", sequenceName = "departamento_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "departamentoIdSecuencia")
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;
    
    @ManyToMany
    @JoinTable(
            name="departamentos_usuarios",
            //join columns se llena del nombre de la columna en la tabla intermedia
            //que sirve para relacionar a la entidad dueña con dicha tabla (intermedia)
            joinColumns = @JoinColumn(name="departamento_id"),
            //inverse join columns se llena del nombre de la columna en la tabla intermedia
            //que relaciona a la entidad QUE NO ES DUEÑA con la tabla intermedia
            inverseJoinColumns = @JoinColumn(name="usuario_id")
    )
    private List<Usuario> usuarios;

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
