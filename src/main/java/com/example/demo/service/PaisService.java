package com.example.demo.service;

import com.example.demo.modelo.Pais;

import com.example.demo.Repository.PaisRepository;
import com.example.demo.serviceInterface.IPaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaisService implements IPaisService {

    @Autowired
    private PaisRepository paisRepository;

    public List<Pais> getAllPaises() {
        return paisRepository.findAll();
    }

    public Pais getPaisById(Long id) {
        Optional<Pais> pais = paisRepository.findById(id);
        if (pais.isPresent()) {
            return pais.get();
        } else {
            throw new RuntimeException("Pais not found");
        }
    }

    public Pais createPais(Pais pais) {
        return paisRepository.save(pais);
    }

    public Pais updatePais(Long id, Pais pais) {
        Optional<Pais> existingPaisOpt = paisRepository.findById(id);
        if (existingPaisOpt.isPresent()) {
            Pais existingPais = existingPaisOpt.get();
            existingPais.setNombre(pais.getNombre());
            // Actualiza los demás campos...
            return paisRepository.save(existingPais);
        } else {
            throw new RuntimeException("Pais not found");
        }
    }

    public void deletePais(Long id) {
        paisRepository.deleteById(id);
    }
}
