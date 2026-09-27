package com.biblioteca.inventario.service.impl;

import com.biblioteca.inventario.model.Ejemplar;
import com.biblioteca.inventario.repository.EjemplarRepository;
import com.biblioteca.inventario.service.EjemplarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EjemplarServiceImpl implements EjemplarService {

    @Autowired
    private EjemplarRepository ejemplarRepository;

    @Override
    public List<Ejemplar> listar() {
        return ejemplarRepository.findAll();
    }

    @Override
    public Ejemplar buscarPorId(Long id) {
        return ejemplarRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ejemplar no encontrado con id: " + id));
    }

    @Override
    public Ejemplar guardar(Ejemplar ejemplar) {
        return ejemplarRepository.save(ejemplar);
    }

    @Override
    public Ejemplar actualizar(Long id, Ejemplar ejemplar) {
        Ejemplar existente = buscarPorId(id);
        ejemplar.setIdEjemplar(existente.getIdEjemplar());
        return ejemplarRepository.save(ejemplar);
    }

    @Override
    public void eliminar(Long id) {
        ejemplarRepository.deleteById(id);
    }
}
