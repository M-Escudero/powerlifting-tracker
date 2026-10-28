package com.m.escudero.powerlifting_tracker.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Positive
    private double peso;

    @Positive
    private int repeticiones;

    @ManyToOne
    private Entrenamiento entrenamiento;

    @ManyToOne
    private Ejercicio ejercicio;
}
