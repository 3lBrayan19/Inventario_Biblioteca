package com.biblioteca.inventario.service.impl;

import com.biblioteca.inventario.model.Proveedor;
import com.biblioteca.inventario.repository.ProveedorRepository;
import com.biblioteca.inventario.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public List<Proveedor> listar() {
        return proveedorRepository.findAll();
    }

    @Override
    public Proveedor buscarPorId(Long id) {
        return proveedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado con id: " + id));
    }

    @Override
    public Proveedor guardar(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    @Override
    public Proveedor actualizar(Long id, Proveedor proveedor) {
        Proveedor existente = buscarPorId(id);
        proveedor.setIdProveedor(existente.getIdProveedor());
        return proveedorRepository.save(proveedor);
    }

    @Override
    public void eliminar(Long id) {
        proveedorRepository.deleteById(id);
    }
}
