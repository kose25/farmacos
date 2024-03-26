package cjpg.farmacos.services;

import cjpg.farmacos.models.Estado;
import cjpg.farmacos.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoService implements IEstadoService{

    @Autowired
    private EstadoRepository estadoRepository;
    @Override
    public Estado GetEstadoByCodigo(String codigo) {
        return this.estadoRepository.findFirstByCodigo(codigo);
    }
}
