package com.m.escudero.powerlifting_tracker.repository;

import com.m.escudero.powerlifting_tracker.entity.Entrenamiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrenamientoRepository extends JpaRepository<Entrenamiento, Long> {
}
