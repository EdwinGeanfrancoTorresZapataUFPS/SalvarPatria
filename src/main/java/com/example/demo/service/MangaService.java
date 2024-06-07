package com.example.demo.service;

import com.example.demo.modelo.Manga;

import com.example.demo.Repository.MangaRepository;
import com.example.demo.serviceInterface.IMangaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MangaService implements IMangaService {

    @Autowired
    private MangaRepository mangaRepository;

    @Override
    public List<Manga> getAllMangas() {
        return mangaRepository.findAll();
    }

    @Override
    public Manga getMangaById(Long id) {
        return mangaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Manga not found"));
    }

    @Override
    public Manga createManga(Manga manga) {
        return mangaRepository.save(manga);
    }

    @Override
    public Manga updateManga(Long id, Manga manga) {
        Manga existingManga = mangaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Manga not found"));
        existingManga.setNombre(manga.getNombre());
        // Actualiza los demás campos...
        return mangaRepository.save(existingManga);
    }

    @Override
    public void deleteManga(Long id) {
        mangaRepository.deleteById(id);
    }
}

