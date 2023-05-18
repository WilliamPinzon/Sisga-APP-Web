package com.registro.usuarios.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.registro.usuarios.modelo.Inventario;

public interface InventarioRepositorio extends JpaRepository<Inventario, Long> {
	
    List<Inventario> findAll();
    Inventario save(Inventario inventario);
    void deleteById(Long id);
    List<Inventario> findByReferencia(String referencia);
    

    @Query("SELECT i FROM Inventario i")
    List<Inventario> findAllInventario();

    @Query("SELECT i.descripcion FROM Inventario i")
    List<String> findAllDescriptions();

    @Query("SELECT i FROM Inventario i WHERE i.descripcion = :descripcion")
    List<Inventario> findAllInventarioByDescripcion(@Param("descripcion") String descripcion);


}


