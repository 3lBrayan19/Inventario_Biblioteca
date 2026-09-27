package com.biblioteca.inventario.service.impl;

import com.biblioteca.inventario.model.Libro;
import com.biblioteca.inventario.repository.LibroRepository;
import com.biblioteca.inventario.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LibroServiceImpl implements LibroService {

    @Autowired
    private LibroRepository libroRepository;

    @Override
    public List<Libro> listar() {
        return libroRepository.findAll();
    }

    @Override
    public Libro buscarPorId(Long id) {
        return libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado con id: " + id));
    }

    @Override
    public Libro guardar(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public Libro actualizar(Long id, Libro libro) {
        Libro existente = buscarPorId(id);
        libro.setIdLibro(existente.getIdLibro());
        return libroRepository.save(libro);
    }

    @Override
    public void eliminar(Long id) {
        libroRepository.deleteById(id);
    }
}
