package com.biblioteca.inventario.controller;

import com.biblioteca.inventario.model.MovimientoInventario;
import com.biblioteca.inventario.service.MovimientoInventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/movimientos")
public class MovimientoInventarioController {

    @Autowired
    private MovimientoInventarioService movimientoInventarioService;

    @GetMapping
    public ResponseEntity<List<MovimientoInventario>> listar() {
        return ResponseEntity.ok(movimientoInventarioService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovimientoInventario> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(movimientoInventarioService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<MovimientoInventario> crear(@RequestBody MovimientoInventario movimientoInventario) {
        MovimientoInventario guardado = movimientoInventarioService.guardar(movimientoInventario);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovimientoInventario> actualizar(@PathVariable Long id, @RequestBody MovimientoInventario movimientoInventario) {
        return ResponseEntity.ok(movimientoInventarioService.actualizar(id, movimientoInventario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        movimientoInventarioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
