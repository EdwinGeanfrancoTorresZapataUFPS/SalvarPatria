package com.example.demo.controller;

import com.example.demo.modelo.Tipo;
import com.example.demo.service.TipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipos")
public class TipoController {

    @Autowired
    private TipoService tipoService;

    @GetMapping
    public ResponseEntity<List<Tipo>> getAllTipos() {
        List<Tipo> tipos = tipoService.getAllTipos();
        return ResponseEntity.ok(tipos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tipo> getTipoById(@PathVariable Long id) {
        Tipo tipo = tipoService.getTipoById(id);
        return ResponseEntity.ok(tipo);
    }

    @PostMapping
    public ResponseEntity<Tipo> createTipo(@RequestBody Tipo tipo) {
        Tipo createdTipo = tipoService.createTipo(tipo);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTipo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tipo> updateTipo(@PathVariable Long id, @RequestBody Tipo tipo) {
        Tipo updatedTipo = tipoService.updateTipo(id, tipo);
        return ResponseEntity.ok(updatedTipo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipo(@PathVariable Long id) {
        tipoService.deleteTipo(id);
        return ResponseEntity.noContent().build();
    }
}
