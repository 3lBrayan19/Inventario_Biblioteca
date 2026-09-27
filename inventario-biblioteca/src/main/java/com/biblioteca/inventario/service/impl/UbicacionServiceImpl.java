package com.biblioteca.inventario.service.impl;

import com.biblioteca.inventario.model.Ubicacion;
import com.biblioteca.inventario.repository.UbicacionRepository;
import com.biblioteca.inventario.service.UbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UbicacionServiceImpl implements UbicacionService {

    @Autowired
    private UbicacionRepository ubicacionRepository;

    @Override
    public List<Ubicacion> listar() {
        return ubicacionRepository.findAll();
    }

    @Override
    public Ubicacion buscarPorId(Long id) {
        return ubicacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ubicacion no encontrado con id: " + id));
    }

    @Override
    public Ubicacion guardar(Ubicacion ubicacion) {
        return ubicacionRepository.save(ubicacion);
    }

    @Override
    public Ubicacion actualizar(Long id, Ubicacion ubicacion) {
        Ubicacion existente = buscarPorId(id);
        ubicacion.setIdUbicacion(existente.getIdUbicacion());
        return ubicacionRepository.save(ubicacion);
    }

    @Override
    public void eliminar(Long id) {
        ubicacionRepository.deleteById(id);
    }
}
