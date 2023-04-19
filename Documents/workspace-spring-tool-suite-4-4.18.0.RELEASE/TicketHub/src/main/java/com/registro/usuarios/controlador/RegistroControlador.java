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
import com.registro.usuarios.repositorio.UsuarioRepositorio;
import com.registro.usuarios.servicio.UsuarioServicio;


@Controller
public class RegistroControlador {

	@Autowired
	private UsuarioServicio servicio;
	
		
	@GetMapping("/login")
	public String iniciarSesion() {
		return "login";
	}
	
	@GetMapping("/")
    public String verPaginaDeInicio(Model modelo) {
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

        if (auth.getName().equals("prueba.admin@gmail.co") || auth.getName().equals("admin@ucooperativa.edu.co")) {
        	modelo.addAttribute("nombre", nombre);
        	modelo.addAttribute("apellido", apellido);
            modelo.addAttribute("usuarios", servicio.listarUsuarios());
            return "index";
        } else {
        	modelo.addAttribute("nombre", nombre);
            modelo.addAttribute("apellido", apellido);
            modelo.addAttribute("usuarios", servicio.listarUsuarios());
            return "gestorIndex";
        }
    }
	
	@GetMapping("/configGestores")
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
		modelo.addAttribute("usuarios", servicio.listarUsuarios());
		return "configGestores";
	}
	
	@GetMapping("/gestorIndex")
	public String configGestoresIndex(Model modelo) {
		modelo.addAttribute("usuarios", servicio.listarUsuarios());
		return "gestorIndex";
	}
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	
	

}
