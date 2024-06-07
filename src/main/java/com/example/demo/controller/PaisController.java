package com.example.demo.controller;

import com.example.demo.modelo.Pais;
import com.example.demo.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paises")
public class PaisController {

    @Autowired
    private PaisService paisService;

    @GetMapping
    public ResponseEntity<List<Pais>> getAllPaises() {
        List<Pais> paises = paisService.getAllPaises();
        return ResponseEntity.ok(paises);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pais> getPaisById(@PathVariable Long id) {
        Pais pais = paisService.getPaisById(id);
        return ResponseEntity.ok(pais);
    }

    @PostMapping
    public ResponseEntity<Pais> createPais(@RequestBody Pais pais) {
        Pais createdPais = paisService.createPais(pais);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPais);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pais> updatePais(@PathVariable Long id, @RequestBody Pais pais) {
        Pais updatedPais = paisService.updatePais(id, pais);
        return ResponseEntity.ok(updatedPais);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePais(@PathVariable Long id) {
        paisService.deletePais(id);
        return ResponseEntity.noContent().build();
    }
}
