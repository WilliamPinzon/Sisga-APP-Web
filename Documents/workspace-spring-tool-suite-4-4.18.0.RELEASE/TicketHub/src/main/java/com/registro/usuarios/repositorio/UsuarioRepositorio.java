package com.registro.usuarios.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.registro.usuarios.modelo.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{
	
	public Usuario findByUsername(String username);
	public Usuario findByNombre(String nombre);
	public Usuario findByApellido(String apellido);
	

}
