package com.m.escudero.powerlifting_tracker.controller;

import com.m.escudero.powerlifting_tracker.entity.Entrenamiento;
import com.m.escudero.powerlifting_tracker.service.EntrenamientoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entrenamientos")
public class EntrenamientoController {

    private final EntrenamientoService entrenamientoService;

    public EntrenamientoController(EntrenamientoService entrenamientoService) {
        this.entrenamientoService = entrenamientoService;
    }

    @PostMapping
    public Entrenamiento crear(@RequestBody Entrenamiento entrenamiento, @RequestParam Long usuarioId){
        return entrenamientoService.crear(usuarioId, entrenamiento);
    }

    @GetMapping
    public List<Entrenamiento> listar(){
        return entrenamientoService.listar();
    }
}
