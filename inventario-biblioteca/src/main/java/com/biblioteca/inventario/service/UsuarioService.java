package com.biblioteca.inventario.service;

import com.biblioteca.inventario.model.Usuario;
import java.util.List;

public interface UsuarioService {
    List<Usuario> listar();
    Usuario buscarPorId(Long id);
    Usuario guardar(Usuario usuario);
    Usuario actualizar(Long id, Usuario usuario);
    void eliminar(Long id);
}
