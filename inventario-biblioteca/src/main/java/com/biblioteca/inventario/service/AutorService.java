package com.biblioteca.inventario.service;

import com.biblioteca.inventario.model.Autor;
import java.util.List;

public interface AutorService {
    List<Autor> listar();
    Autor buscarPorId(Long id);
    Autor guardar(Autor autor);
    Autor actualizar(Long id, Autor autor);
    void eliminar(Long id);
}
