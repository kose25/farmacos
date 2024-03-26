package cjpg.farmacos.services;

import cjpg.farmacos.models.Estado;
import org.springframework.stereotype.Service;

@Service
public interface IEstadoService {
    public Estado GetEstadoByCodigo(String codigo);
}
