package cjpg.farmacos.services;

import cjpg.farmacos.models.Estado;
import cjpg.farmacos.models.Proveedor;
import cjpg.farmacos.models.Recepcion;
import cjpg.farmacos.repository.RecepcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecepcionService implements IRecepcionService{

    @Autowired
    private RecepcionRepository recepcionRepository;
    @Override
    public List<Recepcion> ListarRecepcion() {
        return this.recepcionRepository.findAllActiveRecepciones();
    }

    @Override
    public Recepcion GetRecepcionById(Integer id) {
        return this.recepcionRepository.findById(id).orElse(null);
    }

    @Override
    public Recepcion SaveRecepcion(Recepcion recepcion) {
        return this.recepcionRepository.save(recepcion);
    }

    @Override
    public void InactivarRecepcion(Integer id, Estado estado) {
        this.recepcionRepository.cambiarEstadoRecepcion(id, estado);
    }

    @Override
    public List<Recepcion> ListarRecepcionByProveedor(Proveedor proveedor) {
        return this.recepcionRepository.findByProveedor(proveedor);
    }
}
