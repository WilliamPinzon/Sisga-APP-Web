package com.registro.usuarios.controlador;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.registro.usuarios.modelo.Usuario;
import com.registro.usuarios.repositorio.UsuarioRepositorio;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepositorio usuarioRepository;


    @PostMapping("/modificar-usuario")
    public String modificarUsuario(@ModelAttribute Usuario usuario) {
        // Verificar si se envió un valor para el campo de contraseña
        if (usuario.getPassword().isEmpty()) {
            // Recuperar el valor original de la base de datos
            Usuario usuarioOriginal = usuarioRepository.findById(usuario.getId()).get();
            usuario.setPassword(usuarioOriginal.getPassword());
        }
        // Actualizar el usuario en la base de datos
        usuarioRepository.save(usuario);
        return "redirect:/configGestores";
    }

    @PostMapping("/eliminar-usuario")
    public String eliminarUsuario(@RequestParam Long id) {
        // Eliminar el usuario de la base de datos
        usuarioRepository.deleteById(id);
        return "redirect:/configGestores";
    }
    
    
    
    

    // ...
}
