package com.biblioteca.inventario.service;

import com.biblioteca.inventario.model.Proveedor;
import java.util.List;

public interface ProveedorService {
    List<Proveedor> listar();
    Proveedor buscarPorId(Long id);
    Proveedor guardar(Proveedor proveedor);
    Proveedor actualizar(Long id, Proveedor proveedor);
    void eliminar(Long id);
}
