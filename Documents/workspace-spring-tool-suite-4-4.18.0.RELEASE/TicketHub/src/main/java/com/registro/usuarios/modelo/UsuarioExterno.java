package com.registro.usuarios.modelo;

import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

//import com.registro.usuarios.repositorio.UsuarioRepositorio;

@Entity
@Table(name = "usuarios_externos", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class UsuarioExterno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    private String username;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "usuarios_externos__roles", joinColumns = @JoinColumn(name = "usuario_externo_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "id"))
    private Collection<Rol> roles;
    @Column(name = "fecha_de_registro")
    private LocalDateTime fechaDeRegistro= LocalDateTime.now();

    public UsuarioExterno(Long id, String nombre, String apellido, String username, String password, Collection<Rol> roles) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public UsuarioExterno(String nombre, String apellido, String username, String password, Collection<Rol> roles) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public UsuarioExterno() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Rol> roles) {
        this.roles = roles;
    }

	public LocalDateTime getFechaDeRegistro() {
		return fechaDeRegistro;
	}

	public void setFechaDeRegistro(LocalDateTime fechaDeRegistro) {
		this.fechaDeRegistro = fechaDeRegistro;
	}


    
}
