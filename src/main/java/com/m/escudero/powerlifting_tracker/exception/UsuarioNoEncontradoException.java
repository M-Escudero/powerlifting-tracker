package com.m.escudero.powerlifting_tracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsuarioNoEncontradoException extends RuntimeException{

    public UsuarioNoEncontradoException (String mensaje){
        super(mensaje);
    }
}
