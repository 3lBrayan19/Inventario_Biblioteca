package com.biblioteca.inventario.service.impl;

import com.biblioteca.inventario.model.Editorial;
import com.biblioteca.inventario.repository.EditorialRepository;
import com.biblioteca.inventario.service.EditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EditorialServiceImpl implements EditorialService {

    @Autowired
    private EditorialRepository editorialRepository;

    @Override
    public List<Editorial> listar() {
        return editorialRepository.findAll();
    }

    @Override
    public Editorial buscarPorId(Long id) {
        return editorialRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Editorial no encontrado con id: " + id));
    }

    @Override
    public Editorial guardar(Editorial editorial) {
        return editorialRepository.save(editorial);
    }

    @Override
    public Editorial actualizar(Long id, Editorial editorial) {
        Editorial existente = buscarPorId(id);
        editorial.setIdEditorial(existente.getIdEditorial());
        return editorialRepository.save(editorial);
    }

    @Override
    public void eliminar(Long id) {
        editorialRepository.deleteById(id);
    }
}
