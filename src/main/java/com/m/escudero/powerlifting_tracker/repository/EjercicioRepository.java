package com.m.escudero.powerlifting_tracker.repository;

import com.m.escudero.powerlifting_tracker.entity.Ejercicio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EjercicioRepository extends JpaRepository<Ejercicio, Long> {
}
