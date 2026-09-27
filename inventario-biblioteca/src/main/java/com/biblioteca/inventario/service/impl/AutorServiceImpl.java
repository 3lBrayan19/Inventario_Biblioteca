package com.biblioteca.inventario.service.impl;

import com.biblioteca.inventario.model.Autor;
import com.biblioteca.inventario.repository.AutorRepository;
import com.biblioteca.inventario.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AutorServiceImpl implements AutorService {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public List<Autor> listar() {
        return autorRepository.findAll();
    }

    @Override
    public Autor buscarPorId(Long id) {
        return autorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autor no encontrado con id: " + id));
    }

    @Override
    public Autor guardar(Autor autor) {
        return autorRepository.save(autor);
    }

    @Override
    public Autor actualizar(Long id, Autor autor) {
        Autor existente = buscarPorId(id);
        autor.setIdAutor(existente.getIdAutor());
        return autorRepository.save(autor);
    }

    @Override
    public void eliminar(Long id) {
        autorRepository.deleteById(id);
    }
}
