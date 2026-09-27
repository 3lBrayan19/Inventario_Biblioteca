package com.biblioteca.inventario.controller;

import com.biblioteca.inventario.model.Ubicacion;
import com.biblioteca.inventario.service.UbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/ubicaciones")
public class UbicacionController {

    @Autowired
    private UbicacionService ubicacionService;

    @GetMapping
    public ResponseEntity<List<Ubicacion>> listar() {
        return ResponseEntity.ok(ubicacionService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ubicacion> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(ubicacionService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Ubicacion> crear(@RequestBody Ubicacion ubicacion) {
        Ubicacion guardado = ubicacionService.guardar(ubicacion);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ubicacion> actualizar(@PathVariable Long id, @RequestBody Ubicacion ubicacion) {
        return ResponseEntity.ok(ubicacionService.actualizar(id, ubicacion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        ubicacionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
