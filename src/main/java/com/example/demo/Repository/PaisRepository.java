package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {
}

