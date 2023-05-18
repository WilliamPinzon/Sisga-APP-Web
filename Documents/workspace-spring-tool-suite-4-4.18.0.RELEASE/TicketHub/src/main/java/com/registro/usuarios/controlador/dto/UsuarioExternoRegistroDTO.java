package com.registro.usuarios.controlador.dto;

import java.time.LocalDateTime;

import com.registro.usuarios.modelo.Facultad;

public class UsuarioExternoRegistroDTO {

	private Long id;
	private String nombre;
	private String apellido;
	private String username;
	private LocalDateTime fechaDeRegistro= LocalDateTime.now();
	private Integer cedula;
	private Facultad facultad;

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

	public UsuarioExternoRegistroDTO(Long id, String nombre, String apellido, String username, LocalDateTime fechaDeRegistro, Integer cedula, Facultad facultad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.username = username;
		this.fechaDeRegistro= LocalDateTime.now();
		this.cedula = cedula;
		this.facultad = facultad;
	}

	public UsuarioExternoRegistroDTO(String nombre, String apellido, String username, LocalDateTime fechaDeRegistro, Integer cedula, Facultad facultad) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.username = username;
		this.fechaDeRegistro= LocalDateTime.now();
		this.cedula = cedula;
		this.facultad = facultad;
	}

	public UsuarioExternoRegistroDTO(String username) {
		super();
		this.username = username;
	}

	public UsuarioExternoRegistroDTO() {

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
