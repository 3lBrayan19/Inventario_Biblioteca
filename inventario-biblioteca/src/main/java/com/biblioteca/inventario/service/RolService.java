package com.biblioteca.inventario.service;

import com.biblioteca.inventario.model.Rol;
import java.util.List;

public interface RolService {
    List<Rol> listar();
    Rol buscarPorId(Long id);
    Rol guardar(Rol rol);
    Rol actualizar(Long id, Rol rol);
    void eliminar(Long id);
}
