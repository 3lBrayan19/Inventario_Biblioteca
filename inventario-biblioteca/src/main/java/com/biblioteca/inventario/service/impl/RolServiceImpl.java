package com.biblioteca.inventario.service.impl;

import com.biblioteca.inventario.model.Rol;
import com.biblioteca.inventario.repository.RolRepository;
import com.biblioteca.inventario.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    private RolRepository rolRepository;

    @Override
    public List<Rol> listar() {
        return rolRepository.findAll();
    }

    @Override
    public Rol buscarPorId(Long id) {
        return rolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado con id: " + id));
    }

    @Override
    public Rol guardar(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    public Rol actualizar(Long id, Rol rol) {
        Rol existente = buscarPorId(id);
        rol.setIdRol(existente.getIdRol());
        return rolRepository.save(rol);
    }

    @Override
    public void eliminar(Long id) {
        rolRepository.deleteById(id);
    }
}
