package com.registro.usuarios.controlador;

//import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.registro.usuarios.modelo.Usuario;
import com.registro.usuarios.modelo.UsuarioExterno;
import com.registro.usuarios.repositorio.UsuarioExternoRepositorio;
import com.registro.usuarios.repositorio.UsuarioRepositorio;
import com.registro.usuarios.servicio.UsuarioExternoServicio;
import com.registro.usuarios.servicio.UsuarioServicio;


@Controller
public class RegistroExternoControlador {

	@Autowired
	private UsuarioServicio servicio;
	
	@Autowired
	private UsuarioExternoServicio servicioExterno;
	

	@GetMapping("/externo")
    public String verPaginaDeInicio(Model modelo) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String apellido, nombre;
        try {
            UsuarioExterno usuarioExterno = usuarioExternoRepositorio.findByUsername(auth.getName());
            nombre = usuarioExterno.getNombre();
            apellido = usuarioExterno.getApellido();
        } catch (Exception e) {
            apellido = "";
            nombre = "";
        }

        if (auth.getName().equals("prueba.admin@gmail.co") || auth.getName().equals("admin@ucooperativa.edu.co")) {
        	modelo.addAttribute("nombre", nombre);
        	modelo.addAttribute("apellido", apellido);
            modelo.addAttribute("usuarios", servicio.listarUsuarios());
            return "index";
        } else {
        	modelo.addAttribute("nombre", nombre);
            modelo.addAttribute("apellido", apellido);
            modelo.addAttribute("usuarios_externos", servicioExterno.listarUsuarios());
            return "gestorIndex";
        }
    }
	
	@GetMapping("/configUsuarios")
	public String configGestores(Model modelo) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String apellido, nombre;
        try {
        	Usuario usuario = usuarioRepositorio.findByUsername(auth.getName());
            nombre = usuario.getNombre();
            apellido = usuario.getApellido();
        } catch (Exception e) {
            apellido = "";
            nombre = "";
        }
        modelo.addAttribute("nombre", nombre);
        modelo.addAttribute("apellido", apellido);
		modelo.addAttribute("usuarios_externos", servicioExterno.listarUsuarios());
		return "configUsuarios";
	}
	
	
	
	@Autowired
	private UsuarioExternoRepositorio usuarioExternoRepositorio;
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	
	

}
