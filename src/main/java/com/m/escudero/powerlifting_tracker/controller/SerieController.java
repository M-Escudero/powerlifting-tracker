package com.m.escudero.powerlifting_tracker.controller;

import com.m.escudero.powerlifting_tracker.entity.Serie;
import com.m.escudero.powerlifting_tracker.service.SerieService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SerieController {

    private final SerieService serieService;

    public SerieController(SerieService serieService) {
        this.serieService = serieService;
    }

    @PostMapping
    public Serie crear(@Valid @RequestBody Serie serie, @RequestParam Long entrenamientoId, @RequestParam Long ejercicioId){
        return serieService.crear(entrenamientoId, ejercicioId, serie);
    }

    @GetMapping
    public List<Serie> listar(){
        return serieService.listar();
    }

    @GetMapping("{id}")
    public Serie buscarPorId(@PathVariable Long id){
        return serieService.buscarPorId(id);
    }

    @DeleteMapping("{id}")
    public void eliminar(@PathVariable Long id){
        serieService.eliminar(id);
    }
}
