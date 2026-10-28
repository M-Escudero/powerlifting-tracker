package com.m.escudero.powerlifting_tracker.service;

import com.m.escudero.powerlifting_tracker.entity.Ejercicio;
import com.m.escudero.powerlifting_tracker.entity.Entrenamiento;
import com.m.escudero.powerlifting_tracker.entity.Serie;
import com.m.escudero.powerlifting_tracker.exception.RecursoNoEncontradoException;
import com.m.escudero.powerlifting_tracker.repository.SerieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieService {

    private final SerieRepository serieRepository;
    private final EntrenamientoService entrenamientoService;
    private final EjercicioService ejercicioService;

    public SerieService(SerieRepository serieRepository, EntrenamientoService entrenamientoService, EjercicioService ejercicioService) {
        this.serieRepository = serieRepository;
        this.entrenamientoService = entrenamientoService;
        this.ejercicioService = ejercicioService;
    }

    public Serie crear(Long entrenamientoid, Long ejercicioid, Serie serie){
        Entrenamiento entrenamiento = entrenamientoService.buscarPorId(entrenamientoid);
        Ejercicio ejercicio = ejercicioService.buscarPorId(ejercicioid);
        serie.setEntrenamiento(entrenamiento);
        serie.setEjercicio(ejercicio);
        return serieRepository.save(serie);

    }

    public List<Serie> listar(){
        return serieRepository.findAll();
    }

    public Serie buscarPorId(Long id){
        return serieRepository.findById(id).
                orElseThrow(()-> new RecursoNoEncontradoException("Serie no encontrada con id: " + id));
    }

    public void eliminar(Long id){
        buscarPorId(id);
        serieRepository.deleteById(id);
    }
}
