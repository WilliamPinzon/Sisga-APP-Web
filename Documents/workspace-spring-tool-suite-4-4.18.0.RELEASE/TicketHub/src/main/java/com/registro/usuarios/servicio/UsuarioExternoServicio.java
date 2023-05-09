package com.registro.usuarios.servicio;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.registro.usuarios.controlador.dto.UsuarioExternoRegistroDTO;
import com.registro.usuarios.modelo.UsuarioExterno;


public interface UsuarioExternoServicio extends UserDetailsService{

	public UsuarioExterno guardar(UsuarioExternoRegistroDTO registroExternoDTO);
	
	public List<UsuarioExterno> listarUsuarios();
	
	public boolean existeUsuarioExterno(String username);
	
}
