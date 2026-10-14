package com.m.escudero.powerlifting_tracker.entity;

import jakarta.persistence.*;

@Entity
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double peso;
    private int repeticiones;

    @ManyToOne
    private Entrenamiento entrenamiento;

    @ManyToOne
    private Ejercicio ejercicio;
}
