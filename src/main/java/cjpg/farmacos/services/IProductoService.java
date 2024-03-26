package cjpg.farmacos.services;

import cjpg.farmacos.models.Estado;
import cjpg.farmacos.models.Producto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductoService {
    public List<Producto> ListarProductos();

    public Producto GetProductoById(Integer productoId);

    public Producto SaveProducto(Producto producto);

    public void InactivarProdcuto(Integer id, Estado estado);
}
