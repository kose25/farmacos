package cjpg.farmacos.services;

import cjpg.farmacos.models.Estado;
import cjpg.farmacos.models.Producto;
import cjpg.farmacos.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private ProductoRepository productoRepository;
    @Override
    public List<Producto> ListarProductos() {
        return this.productoRepository.findAllActiveProductos();
    }

    @Override
    public Producto GetProductoById(Integer productoId) {
        return this.productoRepository.findById(productoId).orElse(null);
    }

    @Override
    public Producto SaveProducto(Producto producto) {
        return this.productoRepository.save(producto);
    }

    @Override
    public void InactivarProdcuto(Integer id, Estado estado) {
        this.productoRepository.cambiarEstadoProducto(id,estado);
    }
}
