package cjpg.farmacos.services;

import cjpg.farmacos.models.Estado;
import cjpg.farmacos.models.Producto;
import cjpg.farmacos.models.Proveedor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProveedorService {

    public List<Proveedor> ListarProveedores();

    public Proveedor GetProveedorById(Integer id);

    public Proveedor SaveProveedor(Proveedor producto);

    public void InactivarProveedor(Integer id, Estado estado);
}
