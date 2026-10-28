package com.m.escudero.powerlifting_tracker.repository;

import com.m.escudero.powerlifting_tracker.entity.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieRepository extends JpaRepository<Serie, Long> {
}
