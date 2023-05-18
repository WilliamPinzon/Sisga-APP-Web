package com.registro.usuarios.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.registro.usuarios.modelo.Activos;

public interface ActivosRepositorio extends JpaRepository<Activos, Long>{
	
	public Activos findByUsernameEstudiante(String usernameEstudiante);
	public Activos findByNombreEstudiante(String nombreEstudiante);
	public Activos findByApellidoEstudiante(String apellidoEstudiante);
	

}
