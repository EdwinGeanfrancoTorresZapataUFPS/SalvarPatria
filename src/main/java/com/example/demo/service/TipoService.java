package com.example.demo.service;

import com.example.demo.modelo.Tipo;

import com.example.demo.Repository.TipoRepository;
import com.example.demo.serviceInterface.ITipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoService implements ITipoService {

    @Autowired
    private TipoRepository tipoRepository;

    @Override
    public List<Tipo> getAllTipos() {
        return tipoRepository.findAll();
    }

    @Override
    public Tipo getTipoById(Long id) {
        return tipoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tipo not found"));
    }

    @Override
    public Tipo createTipo(Tipo tipo) {
        return tipoRepository.save(tipo);
    }

    @Override
    public Tipo updateTipo(Long id, Tipo tipo) {
        Tipo existingTipo = tipoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tipo not found"));
        existingTipo.setNombre(tipo.getNombre());
        // Actualiza los demás campos...
        return tipoRepository.save(existingTipo);
    }

    @Override
    public void deleteTipo(Long id) {
        tipoRepository.deleteById(id);
    }
}