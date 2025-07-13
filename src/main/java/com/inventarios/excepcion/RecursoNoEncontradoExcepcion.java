package com.inventarios.excepcion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Excepción personalizada para recursos no encontrados
 * Se lanza cuando se busca un producto que no existe en la base de datos
 * Spring automáticamente devuelve HTTP 404 cuando se lanza esta excepción
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND) // Mapea la excepción a HTTP 404
public class RecursoNoEncontradoExcepcion extends RuntimeException{
    
    /**
     * Constructor que recibe el mensaje de error personalizado
     * @param mensaje Descripción del error para el usuario
     */
    public RecursoNoEncontradoExcepcion(String mensaje){
        super(mensaje); // Pasa el mensaje a la clase padre RuntimeException
    }
}
