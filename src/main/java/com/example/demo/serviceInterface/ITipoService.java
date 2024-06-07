package com.example.demo.serviceInterface;

import com.example.demo.modelo.Tipo;

import java.util.*;

public interface ITipoService {
    List<Tipo> getAllTipos();
    Tipo getTipoById(Long id);
    Tipo createTipo(Tipo tipo);
    Tipo updateTipo(Long id, Tipo tipo);
    void deleteTipo(Long id);
}

