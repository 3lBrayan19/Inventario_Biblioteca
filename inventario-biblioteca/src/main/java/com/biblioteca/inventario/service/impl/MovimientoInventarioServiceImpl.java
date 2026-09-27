package com.biblioteca.inventario.service.impl;

import com.biblioteca.inventario.model.MovimientoInventario;
import com.biblioteca.inventario.repository.MovimientoInventarioRepository;
import com.biblioteca.inventario.service.MovimientoInventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MovimientoInventarioServiceImpl implements MovimientoInventarioService {

    @Autowired
    private MovimientoInventarioRepository movimientoInventarioRepository;

    @Override
    public List<MovimientoInventario> listar() {
        return movimientoInventarioRepository.findAll();
    }

    @Override
    public MovimientoInventario buscarPorId(Long id) {
        return movimientoInventarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("MovimientoInventario no encontrado con id: " + id));
    }

    @Override
    public MovimientoInventario guardar(MovimientoInventario movimientoInventario) {
        return movimientoInventarioRepository.save(movimientoInventario);
    }

    @Override
    public MovimientoInventario actualizar(Long id, MovimientoInventario movimientoInventario) {
        MovimientoInventario existente = buscarPorId(id);
        movimientoInventario.setIdMovimiento(existente.getIdMovimiento());
        return movimientoInventarioRepository.save(movimientoInventario);
    }

    @Override
    public void eliminar(Long id) {
        movimientoInventarioRepository.deleteById(id);
    }
}
