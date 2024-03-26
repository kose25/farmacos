package cjpg.farmacos.services;

import cjpg.farmacos.models.Estado;
import cjpg.farmacos.models.Proveedor;
import cjpg.farmacos.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorService implements IProveedorService{

    @Autowired
    private ProveedorRepository proveedorRepository;
    @Override
    public List<Proveedor> ListarProveedores() {
        return this.proveedorRepository.findAllActiveProveedores();
    }

    @Override
    public Proveedor GetProveedorById(Integer id) {
        return this.proveedorRepository.findById(id).orElse(null);
    }

    @Override
    public Proveedor SaveProveedor(Proveedor proveedor) {
        return this.proveedorRepository.save(proveedor);
    }

    @Override
    public void InactivarProveedor(Integer id, Estado estado) {
        this.proveedorRepository.cambiarEstadoProveedor(id, estado);
    }
}
