package com.m.escudero.powerlifting_tracker.service;

import com.m.escudero.powerlifting_tracker.entity.Usuario;
import com.m.escudero.powerlifting_tracker.exception.UsuarioNoEncontradoException;
import com.m.escudero.powerlifting_tracker.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario crear (Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listar(){
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId (Long id){
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNoEncontradoException("Usuario no encontrado"));
    }

    public void eliminar(Long id){
        buscarPorId(id);
        usuarioRepository.deleteById(id);
    }
}
