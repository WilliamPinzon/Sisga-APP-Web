package com.registro.usuarios.controlador;


import java.util.List;
import java.util.stream.Collectors;

//import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.registro.usuarios.modelo.Activos;
import com.registro.usuarios.modelo.Inventario;
import com.registro.usuarios.modelo.Usuario;
import com.registro.usuarios.modelo.UsuarioExterno;
import com.registro.usuarios.repositorio.InventarioRepositorio;
import com.registro.usuarios.repositorio.UsuarioExternoRepositorio;
import com.registro.usuarios.repositorio.UsuarioRepositorio;
import com.registro.usuarios.servicio.ActivosServicio;
import com.registro.usuarios.servicio.InventarioServicio;
import com.registro.usuarios.servicio.UsuarioExternoServicio;
import com.registro.usuarios.servicio.UsuarioServicio;


@Controller
public class RegistroExternoControlador {

	@Autowired
	private UsuarioServicio servicio;
	
	@Autowired
	private UsuarioExternoServicio servicioExterno;
	
	@Autowired
	private InventarioServicio inventarioServicio;
	
	@Autowired
	private ActivosServicio activosServicio;
	

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
	
	@GetMapping("/inventarios")
	public String inventarios(@RequestParam(value = "filtro", required = false) String filtro, @RequestParam(value = "filtroEstado", required = false) String filtroEstado, Model modelo) {
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
        List<Inventario> inventarios = inventarioServicio.obtenerInventarios();
        
        if (filtro != null && !filtro.isEmpty()) {
            switch (filtro) {
                case "computadoras":
                    inventarios = inventarios.stream().filter(inventario -> inventario.getId_codigo() >= 1 && inventario.getId_codigo() <= 20).collect(Collectors.toList());
                    break;
                case "camaras":
                    inventarios = inventarios.stream().filter(inventario -> inventario.getId_codigo() >= 21 && inventario.getId_codigo() <= 25).collect(Collectors.toList());
                    break;
                case "videobeams":
                    inventarios = inventarios.stream().filter(inventario -> inventario.getId_codigo() >= 26 && inventario.getId_codigo() <= 50).collect(Collectors.toList());
                    break;
                default:
                    // No se seleccionó ningún filtro válido, se muestra todos los inventarios sin aplicar ningún filtro adicional
                    break;
            }
        }
        
        if(filtroEstado != null && !filtroEstado.isEmpty()) {
        	switch (filtroEstado) {
			case "activo":
					inventarios = inventarios.stream().filter(inventario -> inventario.getEstado() == true).collect(Collectors.toList());
				break;
			case "inactivo":
				inventarios = inventarios.stream().filter(inventario -> inventario.getEstado() == false).collect(Collectors.toList());;
				break;
			default:
				break;
			}
        }
        modelo.addAttribute("nombre", nombre);
        modelo.addAttribute("apellido", apellido);
		modelo.addAttribute("inventarios", inventarios);
		return "Inventarios";
	}
	
	@GetMapping("/activos")
	public String activos(@RequestParam(value = "filtroEstado", required = false) String filtroEstado,  Model modelo) {
		
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
        
        List<Activos> activos = activosServicio.listarActivos();
        
        if(filtroEstado != null && !filtroEstado.isEmpty()) {
        	switch (filtroEstado) {
			case "activo":
					activos = activos.stream().filter(activo -> activo.getEstado() == true).collect(Collectors.toList());
				break;
			case "inactivo":
					activos = activos.stream().filter(activo -> activo.getEstado() == false).collect(Collectors.toList());;
				break;
			default:
				break;
			}
        }
        
		modelo.addAttribute("activos", activosServicio.listarActivos());
		modelo.addAttribute("nombre", nombre);
        modelo.addAttribute("apellido", apellido);
		return "activos";
	}


	
	@Autowired
	private UsuarioExternoRepositorio usuarioExternoRepositorio;
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	
	

}
