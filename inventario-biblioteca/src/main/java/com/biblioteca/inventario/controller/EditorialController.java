package com.biblioteca.inventario.controller;

import com.biblioteca.inventario.model.Editorial;
import com.biblioteca.inventario.service.EditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/editoriales")
public class EditorialController {

    @Autowired
    private EditorialService editorialService;

    @GetMapping
    public ResponseEntity<List<Editorial>> listar() {
        return ResponseEntity.ok(editorialService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Editorial> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(editorialService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Editorial> crear(@RequestBody Editorial editorial) {
        Editorial guardado = editorialService.guardar(editorial);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Editorial> actualizar(@PathVariable Long id, @RequestBody Editorial editorial) {
        return ResponseEntity.ok(editorialService.actualizar(id, editorial));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        editorialService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
