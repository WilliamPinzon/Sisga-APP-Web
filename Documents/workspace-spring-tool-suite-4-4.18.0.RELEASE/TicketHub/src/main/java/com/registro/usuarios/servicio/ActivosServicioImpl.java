package com.registro.usuarios.servicio;


import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.registro.usuarios.controlador.dto.ActivosRegistroDTO;
import com.registro.usuarios.modelo.*;
import com.registro.usuarios.repositorio.ActivosRepositorio;

@Service
public class ActivosServicioImpl implements ActivosServicio {
	
	private ActivosRepositorio activosRepositorio;
	
	public ActivosServicioImpl(ActivosRepositorio activosRepositorio) {
		super();
		this.activosRepositorio = activosRepositorio;
	}

	@Override
	public Activos guardar(ActivosRegistroDTO activosRegistroDTO) {
		Activos activos = new Activos(
										activosRegistroDTO.getCedulaEstudiante(),
										activosRegistroDTO.getNombreEstudiante(),
										activosRegistroDTO.getApellidoEstudiante(),
										activosRegistroDTO.getUsernameEstudiante(),
										activosRegistroDTO.getFacultadEstudiante(),
										activosRegistroDTO.getDescripcionEquipo(),
										activosRegistroDTO.getCategoriaEquipo(),
										activosRegistroDTO.getReferenciaEquipo(),
										activosRegistroDTO.getSerialEquipo(),
										activosRegistroDTO.getEstado()
										);
		return activosRepositorio.save(activos);
	}
	
	@Override
	public List<Activos> listarActivos() {
		return activosRepositorio.findAll();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	

	
}
