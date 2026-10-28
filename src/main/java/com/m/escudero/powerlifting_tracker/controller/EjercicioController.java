package com.m.escudero.powerlifting_tracker.controller;

import com.m.escudero.powerlifting_tracker.entity.Ejercicio;
import com.m.escudero.powerlifting_tracker.service.EjercicioService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ejercicios")
public class EjercicioController {

    private final EjercicioService ejercicioService;

    public EjercicioController(EjercicioService ejercicioService) {
        this.ejercicioService = ejercicioService;
    }

    @GetMapping
    public List<Ejercicio> listar(){
        return ejercicioService.listar();
    }

    @PostMapping
    public Ejercicio crear(@Valid @RequestBody Ejercicio ejercicio){
        return ejercicioService.crear(ejercicio);
    }

    @GetMapping("{id}")
    public Ejercicio buscarPorId(@PathVariable Long id){
        return ejercicioService.buscarPorId(id);
    }

    @DeleteMapping("{id}")
    public void eliminar(@PathVariable Long id){
        ejercicioService.eliminar(id);
    }
}
