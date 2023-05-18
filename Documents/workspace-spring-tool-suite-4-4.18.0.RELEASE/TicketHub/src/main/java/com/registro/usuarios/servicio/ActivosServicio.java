package com.registro.usuarios.servicio;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.registro.usuarios.controlador.dto.ActivosRegistroDTO;
import com.registro.usuarios.modelo.Activos;


public interface ActivosServicio extends UserDetailsService{

	public Activos guardar(ActivosRegistroDTO activosRegistroDTO);
	
	public List<Activos> listarActivos();
	
}
