package com.m.escudero.powerlifting_tracker.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Entrenamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fecha;
    private String comentario;

    @ManyToOne
    private Usuario usuario;
}
