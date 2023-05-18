package com.registro.usuarios.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.registro.usuarios.controlador.dto.ActivosRegistroDTO;
import com.registro.usuarios.servicio.ActivosServicio;
import com.registro.usuarios.servicio.InventarioServicio;
import com.registro.usuarios.modelo.*;

@Controller
@RequestMapping("/prestamo")
public class PrestamoControlador {

	private ActivosServicio activosServicio;
	
	@Autowired
	private InventarioServicio inventarioServicio;
	
	public PrestamoControlador(ActivosServicio activosServicio) {
		super();
		this.activosServicio = activosServicio;
	}
	
	@ModelAttribute("activos")
	public ActivosRegistroDTO retornarNuevoActivoRegistroDTO() {
		return new ActivosRegistroDTO();
	}

	@GetMapping
	public String mostrarFormularioDePrestamo() {
		return "prestamo";
	}
	
	/*@PostMapping
	public String registrarActivos(@ModelAttribute("activos") ActivosRegistroDTO actiosRegistroDTO) {
		    
		activosServicio.guardar(actiosRegistroDTO);
		return "redirect:/prestamo?exito";
	}*/
	
	@PostMapping
	public String registrarActivos(@ModelAttribute("activos") ActivosRegistroDTO activosRegistroDTO) {
		// Verificar si el campo "serialEquipo" está vacío
		if (activosRegistroDTO.getSerialEquipo().isEmpty()) {
			// Si está vacío, redirigir al formulario nuevamente con un mensaje de error
			return "prestamo";
		}

		// Guardar el activo en la base de datos
		activosServicio.guardar(activosRegistroDTO);

		// Verificar la descripción del equipo y actualizar el estado en la tabla "inventario"
		String descripcionEquipo = activosRegistroDTO.getDescripcionEquipo();
		if (descripcionEquipo != null && !descripcionEquipo.isEmpty()) {
			// Obtener el inventario correspondiente a la descripción del equipo
			Inventario inventario = (Inventario) inventarioServicio.obtenerPorDescripcion(descripcionEquipo);
			if (inventario != null) {
				inventario.setEstado(false); // Cambiar el estado a "false"
				inventarioServicio.guardarInventario(inventario); // Guardar los cambios en el inventario
			}
		}

		return "redirect:/prestamo?exito";
	}
}
