package com.registro.usuarios.servicio;

import com.registro.usuarios.modelo.Inventario;
import com.registro.usuarios.repositorio.InventarioRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventarioServicioImpl implements InventarioServicio {

    private final InventarioRepositorio inventarioRepositorio;

    @Autowired
    public InventarioServicioImpl(InventarioRepositorio inventarioRepositorio) {
        this.inventarioRepositorio = inventarioRepositorio;
    }

    @Override
    public List<Inventario> obtenerInventarios() {
        return inventarioRepositorio.findAll();
    }

    @Override
    public Inventario obtenerInventarioPorId(Long id) {
        return inventarioRepositorio.findById(id).orElse(null);
    }

    @Override
    public void guardarInventario(Inventario inventario) {
        inventarioRepositorio.save(inventario);
    }

    @Override
    public void eliminarInventario(Long id) {
        inventarioRepositorio.deleteById(id);
    }
    
    @Override
    public Inventario obtenerPorDescripcion(String descripcion) {
        List<Inventario> inventarios = inventarioRepositorio.findAllInventarioByDescripcion(descripcion);
        if (!inventarios.isEmpty()) {
            return inventarios.get(0); // Obtener el primer objeto de la lista
        }
        return null; // Retornar null si no se encontró ningún inventario
    }

}
	