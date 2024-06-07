package com.example.demo.modelo;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Manga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private LocalDate fechaLanzamiento;
    private Integer numeroTemporadas;
    private Boolean adaptacionAnime;
    private Boolean adaptacionJuego;
    private Boolean adaptacionPelicula;

    @ManyToOne
    @JoinColumn(name = "pais_id")
    private Pais pais;

    @ManyToOne
    @JoinColumn(name = "tipo_id")
    private Tipo tipo;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public Integer getNumeroTemporadas() {
        return numeroTemporadas;
    }

    public void setNumeroTemporadas(Integer numeroTemporadas) {
        this.numeroTemporadas = numeroTemporadas;
    }

    public Boolean getAdaptacionAnime() {
        return adaptacionAnime;
    }

    public void setAdaptacionAnime(Boolean adaptacionAnime) {
        this.adaptacionAnime = adaptacionAnime;
    }

    public Boolean getAdaptacionJuego() {
        return adaptacionJuego;
    }

    public void setAdaptacionJuego(Boolean adaptacionJuego) {
        this.adaptacionJuego = adaptacionJuego;
    }

    public Boolean getAdaptacionPelicula() {
        return adaptacionPelicula;
    }

    public void setAdaptacionPelicula(Boolean adaptacionPelicula) {
        this.adaptacionPelicula = adaptacionPelicula;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}
