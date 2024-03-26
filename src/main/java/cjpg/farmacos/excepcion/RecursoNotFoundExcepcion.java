package cjpg.farmacos.excepcion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecursoNotFoundExcepcion extends RuntimeException{
    public RecursoNotFoundExcepcion(String mensaje){
        super(mensaje);
    }
}
