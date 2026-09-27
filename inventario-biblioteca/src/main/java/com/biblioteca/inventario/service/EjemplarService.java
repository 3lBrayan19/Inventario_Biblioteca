package com.biblioteca.inventario.service;

import com.biblioteca.inventario.model.Ejemplar;
import java.util.List;

public interface EjemplarService {
    List<Ejemplar> listar();
    Ejemplar buscarPorId(Long id);
    Ejemplar guardar(Ejemplar ejemplar);
    Ejemplar actualizar(Long id, Ejemplar ejemplar);
    void eliminar(Long id);
}
