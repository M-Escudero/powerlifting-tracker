package com.m.escudero.powerlifting_tracker.controller;

import com.m.escudero.powerlifting_tracker.dto.UsuarioRequestDTO;
import com.m.escudero.powerlifting_tracker.dto.UsuarioResponseDTO;
import com.m.escudero.powerlifting_tracker.entity.Usuario;
import com.m.escudero.powerlifting_tracker.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> listar(){
        return usuarioService.listar();
    }

    @PostMapping
    public UsuarioResponseDTO crear (@Valid @RequestBody UsuarioRequestDTO request){
        Usuario usuario = new Usuario();
        usuario.setNombre(request.nombre());
        usuario.setEmail(request.email());
        Usuario usuarioOficial = usuarioService.crear(usuario);
        UsuarioResponseDTO usuarioDto = new UsuarioResponseDTO(usuarioOficial.getId(), usuarioOficial.getNombre(), usuarioOficial.getEmail());
        return usuarioDto;
    }

    @GetMapping("{id}")
    public UsuarioResponseDTO buscarPorId(@PathVariable Long id){
        Usuario usuario = usuarioService.buscarPorId(id);
        UsuarioResponseDTO usuarioDto = new UsuarioResponseDTO(usuario.getId(), usuario.getNombre(), usuario.getEmail());
        return usuarioDto;
    }

    @DeleteMapping("{id}")
    public void eliminar(@PathVariable Long id){
        usuarioService.eliminar(id);
    }
}
