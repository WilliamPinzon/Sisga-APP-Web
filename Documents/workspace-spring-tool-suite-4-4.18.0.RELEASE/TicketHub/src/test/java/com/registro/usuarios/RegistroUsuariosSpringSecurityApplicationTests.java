package com.registro.usuarios;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.registro.usuarios.modelo.Usuario;
import com.registro.usuarios.servicio.UsuarioServicio;

@SpringBootTest
class RegistroUsuariosSpringSecurityApplicationTests {

	@Autowired
	private UsuarioServicio usuarioService;

	@Test
	void contextLoads() {
		List<Usuario> usuarios = usuarioService.listarUsuarios();
		exportarCSV(usuarios);
	}

	private void exportarCSV(List<Usuario> usuarios) {
		try {
			File archivo = new File("usuarios.csv");
			FileWriter writer = new FileWriter(archivo);
			writer.write("id,nombre,correo\n");
			for (Usuario usuario : usuarios) {
				writer.write(usuario.getId() + "," + usuario.getNombre() + "," + usuario.getUsername() + "\n");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
