package br.rh.excepcion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class RecursoNoEncontradoExcepcio extends RuntimeException {
    public RecursoNoEncontradoExcepcio(String mensaje){
        super(mensaje);
    }

}
