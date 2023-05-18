package com.registro.usuarios.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.*;

import com.registro.usuarios.modelo.Facultad;
import com.registro.usuarios.modelo.Inventario;
import com.registro.usuarios.modelo.Usuario;
import com.registro.usuarios.modelo.UsuarioExterno;
import com.registro.usuarios.repositorio.InventarioRepositorio;
import com.registro.usuarios.repositorio.UsuarioExternoRepositorio;

@Controller
public class UsuarioExternoController {

    @Autowired
    private UsuarioExternoRepositorio usuarioExternoRepository;
    
    @Autowired
    private InventarioRepositorio inventarioRepository;


    @PostMapping("/modificar-usuarioExterno")
    public String modificarUsuario(@ModelAttribute UsuarioExterno usuarioExterno) {
        // Asignar la facultad seleccionada al objeto UsuarioExterno
        Facultad facultadSeleccionada = usuarioExterno.getFacultad();
        usuarioExterno.setFacultad(facultadSeleccionada);

        // Actualizar el usuario en la base de datos
        usuarioExternoRepository.save(usuarioExterno);

        return "redirect:/configUsuarios";
    }

    @PostMapping("/eliminar-usuarioExterno")
    public String eliminarUsuario(@RequestParam Long id) {
        // Eliminar el usuario de la base de datos
    	usuarioExternoRepository.deleteById(id);
        return "redirect:/configUsuarios";
    }
    
    @GetMapping("/buscarUsuario")
    public ResponseEntity<?> buscarUsuarioPorCedula(@RequestParam("cedula") String cedula) {
        Integer cedulaInteger = Integer.parseInt(cedula);
        UsuarioExterno usuarioExterno = usuarioExternoRepository.findByCedula(cedulaInteger);

        if (usuarioExterno != null) {
            // Construir el objeto de respuesta
            Map<String, Object> respuesta = new HashMap<>();
            respuesta.put("encontrado", true);
            respuesta.put("nombre", usuarioExterno.getNombre());
            respuesta.put("apellido", usuarioExterno.getApellido());
            respuesta.put("correo", usuarioExterno.getUsername());
            respuesta.put("facultad", usuarioExterno.getFacultad());

            return ResponseEntity.ok(respuesta);
        } else {
            // Construir el objeto de respuesta
            Map<String, Object> respuesta = new HashMap<>();
            respuesta.put("encontrado", false);

            return ResponseEntity.ok(respuesta);
        }
    }
    
    @GetMapping("/buscarDescripcion")
    public ResponseEntity<List<String>> buscarDescripcion() {
        List<String> descripciones = inventarioRepository.findAllDescriptions();

        if (!descripciones.isEmpty()) {
            return ResponseEntity.ok(descripciones);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/buscarDetalles")
    public ResponseEntity<Map<String, Object>> buscarDetallesPorDescripcion(@RequestParam("descripcion") String descripcion) {
        List<Inventario> inventarios = inventarioRepository.findAllInventarioByDescripcion(descripcion);

        if (!inventarios.isEmpty()) {
            Inventario inventario = inventarios.get(0);

            // Construir el objeto de respuesta
            Map<String, Object> respuesta = new HashMap<>();
            respuesta.put("referencia", inventario.getReferencia());
            respuesta.put("serial", inventario.getSerial());
            respuesta.put("estado", inventario.getEstado());
            respuesta.put("categoria", inventario.getCategoria());

            return ResponseEntity.ok(respuesta);
        } else {
            // Construir el objeto de respuesta vacío
            Map<String, Object> respuesta = new HashMap<>();
            respuesta.put("referencia", "");
            respuesta.put("serial", "");
            respuesta.put("estado", "");
            respuesta.put("categoria", "");

            return ResponseEntity.ok(respuesta);
        }
    }













 
}
