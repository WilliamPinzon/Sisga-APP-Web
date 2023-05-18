package com.registro.usuarios.servicio;


import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.registro.usuarios.controlador.dto.UsuarioExternoRegistroDTO;
import com.registro.usuarios.modelo.UsuarioExterno;
import com.registro.usuarios.repositorio.UsuarioExternoRepositorio;

@Service
public class UsuarioExternoServicioImpl implements UsuarioExternoServicio {

	
	private UsuarioExternoRepositorio usuarioExternoRepositorio;

	
	public UsuarioExternoServicioImpl(UsuarioExternoRepositorio usuarioExternoRepositorio) {
		super();
		this.usuarioExternoRepositorio = usuarioExternoRepositorio;
	}

	@Override
	public UsuarioExterno guardar(UsuarioExternoRegistroDTO registroExternoDTO) {
		UsuarioExterno usuarioExterno = new UsuarioExterno(registroExternoDTO.getNombre(), 
				registroExternoDTO.getApellido(),registroExternoDTO.getUsername(),registroExternoDTO.getCedula(),
				registroExternoDTO.getFacultad());
		return usuarioExternoRepositorio.save(usuarioExterno);
	}
	
	@Override
	public List<UsuarioExterno> listarUsuarios() {
		return usuarioExternoRepositorio.findAll();
	}
	
	@Override
    public boolean existeUsuarioExterno(String username) {
        UsuarioExterno usuarioExterno = usuarioExternoRepositorio.findByUsername(username);
        return usuarioExterno != null;
    }

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
}
