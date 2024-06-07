package com.example.demo.controller;

import com.example.demo.modelo.Manga;

import com.example.demo.service.MangaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mangas")
public class MangaController {
    @Autowired
    private MangaService mangaService;

    @GetMapping
    public ResponseEntity<List<Manga>> getAllMangas() {
        List<Manga> mangas = mangaService.getAllMangas();
        return ResponseEntity.ok(mangas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Manga> getMangaById(@PathVariable Long id) {
        Manga manga = mangaService.getMangaById(id);
        return ResponseEntity.ok(manga);
    }

    @PostMapping
    public ResponseEntity<Manga> createManga(@RequestBody Manga manga) {
        Manga createdManga = mangaService.createManga(manga);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdManga);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Manga> updateManga(@PathVariable Long id, @RequestBody Manga manga) {
        Manga updatedManga = mangaService.updateManga(id, manga);
        return ResponseEntity.ok(updatedManga);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteManga(@PathVariable Long id) {
        mangaService.deleteManga(id);
        return ResponseEntity.noContent().build();
    }
}
