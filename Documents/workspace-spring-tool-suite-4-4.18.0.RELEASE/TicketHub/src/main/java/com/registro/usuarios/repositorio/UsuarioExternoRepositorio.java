package com.registro.usuarios.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.registro.usuarios.modelo.UsuarioExterno;

public interface UsuarioExternoRepositorio extends JpaRepository<UsuarioExterno, Long>{
	
	public UsuarioExterno findByUsername(String username);
	public UsuarioExterno findByNombre(String nombre);
	public UsuarioExterno findByApellido(String apellido);

}
