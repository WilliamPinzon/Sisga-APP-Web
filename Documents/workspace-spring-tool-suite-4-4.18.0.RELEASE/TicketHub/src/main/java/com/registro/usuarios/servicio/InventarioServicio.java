package com.registro.usuarios.servicio;

import com.registro.usuarios.modelo.Inventario;

import java.util.List;

public interface InventarioServicio {
    List<Inventario> obtenerInventarios();
    
    Inventario obtenerInventarioPorId(Long id);
    
    void guardarInventario(Inventario inventario);
    
    void eliminarInventario(Long id);

    Inventario obtenerPorDescripcion(String descripcion);
}
