package com.example.demo.serviceInterface;

import com.example.demo.modelo.Pais;

import java.util.List;

public interface IPaisService {
    List<Pais> getAllPaises();
    Pais getPaisById(Long id);
    Pais createPais(Pais pais);
    Pais updatePais(Long id, Pais pais);
    void deletePais(Long id);
}

