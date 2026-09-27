package com.biblioteca.inventario.service;

import com.biblioteca.inventario.model.Editorial;
import java.util.List;

public interface EditorialService {
    List<Editorial> listar();
    Editorial buscarPorId(Long id);
    Editorial guardar(Editorial editorial);
    Editorial actualizar(Long id, Editorial editorial);
    void eliminar(Long id);
}
