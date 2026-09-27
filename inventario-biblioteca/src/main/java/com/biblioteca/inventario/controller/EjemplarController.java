package com.biblioteca.inventario.controller;

import com.biblioteca.inventario.model.Ejemplar;
import com.biblioteca.inventario.service.EjemplarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/ejemplares")
public class EjemplarController {

    @Autowired
    private EjemplarService ejemplarService;

    @GetMapping
    public ResponseEntity<List<Ejemplar>> listar() {
        return ResponseEntity.ok(ejemplarService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ejemplar> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(ejemplarService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Ejemplar> crear(@RequestBody Ejemplar ejemplar) {
        Ejemplar guardado = ejemplarService.guardar(ejemplar);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ejemplar> actualizar(@PathVariable Long id, @RequestBody Ejemplar ejemplar) {
        return ResponseEntity.ok(ejemplarService.actualizar(id, ejemplar));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        ejemplarService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
