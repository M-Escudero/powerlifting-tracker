package com.m.escudero.powerlifting_tracker.service;

import com.m.escudero.powerlifting_tracker.entity.Entrenamiento;
import com.m.escudero.powerlifting_tracker.entity.Usuario;
import com.m.escudero.powerlifting_tracker.repository.EntrenamientoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntrenamientoService {

    private final EntrenamientoRepository entrenamientoRepository;
    private final UsuarioService usuarioService;

    public EntrenamientoService(EntrenamientoRepository entrenamientoRepository, UsuarioService usuarioService) {
        this.entrenamientoRepository = entrenamientoRepository;
        this.usuarioService = usuarioService;
    }

    public Entrenamiento crear(Long usuarioId, Entrenamiento entrenamiento){
        Usuario usuario = usuarioService.buscarPorId(usuarioId);
        entrenamiento.setUsuario(usuario);
        return entrenamientoRepository.save(entrenamiento);
    }

    public List<Entrenamiento> listar(){
        return entrenamientoRepository.findAll();
    }
}
