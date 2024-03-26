package cjpg.farmacos.services;

import cjpg.farmacos.models.Estado;
import cjpg.farmacos.models.Proveedor;
import cjpg.farmacos.models.Recepcion;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IRecepcionService {

    public List<Recepcion> ListarRecepcion();

    public Recepcion GetRecepcionById(Integer id);

    public Recepcion SaveRecepcion(Recepcion recepcion);

    public void InactivarRecepcion(Integer id, Estado estado);

    public List<Recepcion> ListarRecepcionByProveedor(Proveedor proveedor);

}
