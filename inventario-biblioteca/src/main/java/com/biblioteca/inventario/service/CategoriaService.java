package com.biblioteca.inventario.service;

import com.biblioteca.inventario.model.Categoria;
import java.util.List;

public interface CategoriaService {
    List<Categoria> listar();
    Categoria buscarPorId(Long id);
    Categoria guardar(Categoria categoria);
    Categoria actualizar(Long id, Categoria categoria);
    void eliminar(Long id);
}
