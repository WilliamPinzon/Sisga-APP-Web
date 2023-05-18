package com.registro.usuarios.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.registro.usuarios.modelo.UsuarioExterno;

public interface UsuarioExternoRepositorio extends JpaRepository<UsuarioExterno, Long>{
	
	public UsuarioExterno findByUsername(String username);
	public UsuarioExterno findByNombre(String nombre);
	public UsuarioExterno findByApellido(String apellido);
	
	@Query("SELECT u FROM UsuarioExterno u WHERE u.cedula = :cedula")
    UsuarioExterno findByCedula(@Param("cedula") Integer cedula);

}
