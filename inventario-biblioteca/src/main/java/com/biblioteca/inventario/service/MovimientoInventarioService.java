package com.biblioteca.inventario.service;

import com.biblioteca.inventario.model.MovimientoInventario;
import java.util.List;

public interface MovimientoInventarioService {
    List<MovimientoInventario> listar();
    MovimientoInventario buscarPorId(Long id);
    MovimientoInventario guardar(MovimientoInventario movimientoInventario);
    MovimientoInventario actualizar(Long id, MovimientoInventario movimientoInventario);
    void eliminar(Long id);
}
