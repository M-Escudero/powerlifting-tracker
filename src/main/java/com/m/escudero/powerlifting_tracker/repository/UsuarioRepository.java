package com.m.escudero.powerlifting_tracker.repository;

import com.m.escudero.powerlifting_tracker.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
