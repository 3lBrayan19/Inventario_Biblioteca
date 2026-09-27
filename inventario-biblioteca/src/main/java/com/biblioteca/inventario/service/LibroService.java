package com.biblioteca.inventario.service;

import com.biblioteca.inventario.model.Libro;
import java.util.List;

public interface LibroService {
    List<Libro> listar();
    Libro buscarPorId(Long id);
    Libro guardar(Libro libro);
    Libro actualizar(Long id, Libro libro);
    void eliminar(Long id);
}
