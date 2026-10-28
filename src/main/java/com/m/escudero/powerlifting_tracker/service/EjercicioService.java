package com.m.escudero.powerlifting_tracker.service;

import com.m.escudero.powerlifting_tracker.entity.Ejercicio;
import com.m.escudero.powerlifting_tracker.exception.RecursoNoEncontradoException;
import com.m.escudero.powerlifting_tracker.repository.EjercicioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EjercicioService {

    private final EjercicioRepository ejercicioRepository;

    public EjercicioService(EjercicioRepository ejercicioRepository) {
        this.ejercicioRepository = ejercicioRepository;
    }

    public Ejercicio crear(Ejercicio ejercicio){
        return ejercicioRepository.save(ejercicio);
    }

    public List<Ejercicio> listar(){
        return ejercicioRepository.findAll();
    }

    public Ejercicio buscarPorId(Long id){
        return ejercicioRepository.findById(id).
                orElseThrow(()-> new RecursoNoEncontradoException("Ejercicio no encontrado con id: " + id));
    }

    public void eliminar(Long id){
        buscarPorId(id);
        ejercicioRepository.deleteById(id);
    }
}
