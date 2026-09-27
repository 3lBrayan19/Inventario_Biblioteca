package com.biblioteca.inventario.service;

import com.biblioteca.inventario.model.Ubicacion;
import java.util.List;

public interface UbicacionService {
    List<Ubicacion> listar();
    Ubicacion buscarPorId(Long id);
    Ubicacion guardar(Ubicacion ubicacion);
    Ubicacion actualizar(Long id, Ubicacion ubicacion);
    void eliminar(Long id);
}
