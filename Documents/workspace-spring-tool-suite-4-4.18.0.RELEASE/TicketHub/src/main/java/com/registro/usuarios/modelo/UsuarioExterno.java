package com.registro.usuarios.modelo;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @Column(name = "fecha_de_registro")
    private LocalDateTime fechaDeRegistro= LocalDateTime.now();
    private Integer cedula;
    
    @Column(name = "facultad")
    @Enumerated(EnumType.STRING)
    private Facultad facultad;



    public UsuarioExterno(Long id, String nombre, String apellido, String username, Integer cedula,Facultad Facultad) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.username = username;
        this.cedula = cedula;
        this.facultad = Facultad;
    }

    public UsuarioExterno(String nombre, String apellido, String username, Integer cedula,Facultad Facultad) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.username = username;
        this.cedula = cedula;
        this.facultad = Facultad;
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

	public Integer getCedula() {
		return cedula;
	}

	public void setCedula(Integer cedula) {
		this.cedula = cedula;
	}

	public LocalDateTime getFechaDeRegistro() {
		return fechaDeRegistro;
	}

	public void setFechaDeRegistro(LocalDateTime fechaDeRegistro) {
		this.fechaDeRegistro = fechaDeRegistro;
	}

	public Facultad getFacultad() {
		return facultad;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}
	
	
	    
}
