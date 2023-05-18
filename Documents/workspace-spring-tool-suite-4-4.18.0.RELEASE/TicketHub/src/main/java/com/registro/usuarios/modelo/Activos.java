package com.registro.usuarios.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

//import com.registro.usuarios.repositorio.UsuarioRepositorio;

@Entity
@Table(name = "activos")
public class Activos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Integer cedulaEstudiante;
    private String nombreEstudiante;
    private String apellidoEstudiante;
    
    @Column(name = "username_estudiante")
    private String usernameEstudiante;
    private String facultadEstudiante;
    
    private String descripcionEquipo;
    private String categoriaEquipo;
    private String referenciaEquipo;
    private String serialEquipo;
    
    @Column(name = "estado")
    private Boolean estado = true;
    
    
	public Activos(Long id, Integer cedulaEstudiante, String nombreEstudiante, String apellidoEstudiante,
			String usernameEstudiante, String facultadEstudiante, String descripcionEquipo, String categoriaEquipo, String referenciaEquipo,
			String serialEquipo, Boolean estado) {
		super();
		this.id = id;
		this.cedulaEstudiante = cedulaEstudiante;
		this.nombreEstudiante = nombreEstudiante;
		this.apellidoEstudiante = apellidoEstudiante;
		this.usernameEstudiante = usernameEstudiante;
		this.facultadEstudiante = facultadEstudiante;
		this.descripcionEquipo = descripcionEquipo;
		this.categoriaEquipo = categoriaEquipo;
		this.referenciaEquipo = referenciaEquipo;
		this.serialEquipo = serialEquipo;
		this.estado = estado;
	}


	public Activos(Integer cedulaEstudiante, String nombreEstudiante, String apellidoEstudiante,
			String usernameEstudiante, String facultadEstudiante, String descripcionEquipo, String categoriaEquipo, String referenciaEquipo,
			String serialEquipo, Boolean estado) {
		super();
		this.cedulaEstudiante = cedulaEstudiante;
		this.nombreEstudiante = nombreEstudiante;
		this.apellidoEstudiante = apellidoEstudiante;
		this.usernameEstudiante = usernameEstudiante;
		this.facultadEstudiante = facultadEstudiante;
		this.descripcionEquipo = descripcionEquipo;
		this.categoriaEquipo = categoriaEquipo;
		this.referenciaEquipo = referenciaEquipo;
		this.serialEquipo = serialEquipo;
		this.estado = estado;
	}

	public Activos() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Integer getCedulaEstudiante() {
		return cedulaEstudiante;
	}


	public void setCedulaEstudiante(Integer cedulaEstudiante) {
		this.cedulaEstudiante = cedulaEstudiante;
	}


	public String getNombreEstudiante() {
		return nombreEstudiante;
	}


	public void setNombreEstudiante(String nombreEstudiante) {
		this.nombreEstudiante = nombreEstudiante;
	}


	public String getApellidoEstudiante() {
		return apellidoEstudiante;
	}


	public void setApellidoEstudiante(String apellidoEstudiante) {
		this.apellidoEstudiante = apellidoEstudiante;
	}


	public String getUsernameEstudiante() {
		return usernameEstudiante;
	}


	public void setUsernameEstudiante(String usernameEstudiante) {
		this.usernameEstudiante = usernameEstudiante;
	}

	public String getFacultadEstudiante() {
		return facultadEstudiante;
	}


	public void setFacultadEstudiante(String facultadEstudiante) {
		this.facultadEstudiante = facultadEstudiante;
	}


	public String getDescripcionEquipo() {
		return descripcionEquipo;
	}


	public void setDescripcionEquipo(String descripcionEquipo) {
		this.descripcionEquipo = descripcionEquipo;
	}


	public String getCategoriaEquipo() {
		return categoriaEquipo;
	}


	public void setCategoriaEquipo(String categoriaEquipo) {
		this.categoriaEquipo = categoriaEquipo;
	}


	public String getReferenciaEquipo() {
		return referenciaEquipo;
	}


	public void setReferenciaEquipo(String referenciaEquipo) {
		this.referenciaEquipo = referenciaEquipo;
	}


	public String getSerialEquipo() {
		return serialEquipo;
	}


	public void setSerialEquipo(String serialEquipo) {
		this.serialEquipo = serialEquipo;
	}


	public Boolean getEstado() {
		return estado;
	}


	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
    
}
