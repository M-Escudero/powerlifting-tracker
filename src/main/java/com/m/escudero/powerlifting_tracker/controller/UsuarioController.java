package com.m.escudero.powerlifting_tracker.controller;

import com.m.escudero.powerlifting_tracker.entity.Usuario;
import com.m.escudero.powerlifting_tracker.service.UsuarioService;
import jakarta.persistence.Id;
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
    public Usuario crear (@RequestBody Usuario usuario){
        return usuarioService.crear(usuario);
    }

    @GetMapping("{id}")
    public Usuario buscarPorId(@PathVariable Long id){
        return usuarioService.buscarPorId(id);
    }

    @DeleteMapping("{id}")
    public void eliminar(@PathVariable Long id){
        usuarioService.eliminar(id);
    }
}
