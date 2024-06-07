package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Favorito;

@Repository
public interface FavoritoRepository extends JpaRepository<Favorito, Long> {
}

