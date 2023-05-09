package com.registro.usuarios.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.registro.usuarios.controlador.dto.UsuarioExternoRegistroDTO;
import com.registro.usuarios.servicio.UsuarioExternoServicio;

@Controller
@RequestMapping("/gestorRegistroDeUsuario")
public class RegistroUsuarioExternoControlador {

	private UsuarioExternoServicio usuarioExternoServicio;
	
	public RegistroUsuarioExternoControlador(UsuarioExternoServicio usuarioExternoServicio) {
		super();
		this.usuarioExternoServicio = usuarioExternoServicio;
	}
	
	@ModelAttribute("usuarioExterno")
	public UsuarioExternoRegistroDTO retornarNuevoUsuarioExternoRegistroDTO() {
		return new UsuarioExternoRegistroDTO();
	}

	@GetMapping
	public String mostrarFormularioDeRegistro() {
		return "gestorRegistroDeUsuario";
	}
	
	@PostMapping
	public String registrarCuentaDeUsuarioExterno(@ModelAttribute("usuarioExterno") UsuarioExternoRegistroDTO registroExternoDTO, Model modelo) {
		
		 if (usuarioExternoServicio.existeUsuarioExterno(registroExternoDTO.getUsername())) {
		        modelo.addAttribute("usuarioExternoExistente", true);
		        return "gestorRegistroDeUsuario";
		    }
		    
		usuarioExternoServicio.guardar(registroExternoDTO);
		return "redirect:/gestorRegistroDeUsuario?exito";
	}
	
}
