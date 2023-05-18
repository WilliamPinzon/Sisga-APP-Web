package com.registro.usuarios.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "inventario", uniqueConstraints = @UniqueConstraint(columnNames = "referencia"))
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_codigo;
    
    @Column(name = "referencia")
    private String referencia;
    
    @Column(name = "serial")
    private String serial;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "estado")
    private Boolean estado;
    
    @Column(name = "categoria")
    private String categoria;
    
    public Inventario(Long id_codigo, String referencia, String serial, String descripcion, Boolean estado, String categoria) {
		super();
		this.id_codigo = id_codigo;
		this.referencia = referencia;
		this.serial = serial;
		this.descripcion = descripcion;
		this.estado =  estado;
		this.categoria = categoria;
	}

    public Inventario(String referencia, String serial, String descripcion, Boolean estado, String categoria) {
		super();
		this.referencia = referencia;
		this.serial = serial;
		this.descripcion = descripcion;
		this.estado =  estado;
		this.categoria = categoria;
	}
	public Inventario() {
		
    }

	public Long getId_codigo() {
		return id_codigo;
	}

	public void setId_codigo(Long id_codigo) {
		this.id_codigo = id_codigo;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
    
}
