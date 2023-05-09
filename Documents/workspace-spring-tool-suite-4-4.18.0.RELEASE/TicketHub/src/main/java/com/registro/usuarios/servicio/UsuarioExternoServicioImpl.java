package com.registro.usuarios.servicio;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.registro.usuarios.controlador.dto.UsuarioExternoRegistroDTO;
import com.registro.usuarios.modelo.Rol;
import com.registro.usuarios.modelo.UsuarioExterno;
import com.registro.usuarios.repositorio.UsuarioExternoRepositorio;

@Service
public class UsuarioExternoServicioImpl implements UsuarioExternoServicio {

	
	private UsuarioExternoRepositorio usuarioExternoRepositorio;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public UsuarioExternoServicioImpl(UsuarioExternoRepositorio usuarioExternoRepositorio) {
		super();
		this.usuarioExternoRepositorio = usuarioExternoRepositorio;
	}

	@Override
	public UsuarioExterno guardar(UsuarioExternoRegistroDTO registroExternoDTO) {
		UsuarioExterno usuarioExterno = new UsuarioExterno(registroExternoDTO.getNombre(), 
				registroExternoDTO.getApellido(),registroExternoDTO.getUsername(),
				passwordEncoder.encode(registroExternoDTO.getPassword()),Arrays.asList(new Rol("ROLE_USER")));
		return usuarioExternoRepositorio.save(usuarioExterno);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsuarioExterno usuarioExterno = usuarioExternoRepositorio.findByUsername(username);
		if(usuarioExterno == null) {
			throw new UsernameNotFoundException("Usuario o password inválidos");
		}
		return new User(usuarioExterno.getUsername(),usuarioExterno.getPassword(), mapearAutoridadesRoles(usuarioExterno.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
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
}
