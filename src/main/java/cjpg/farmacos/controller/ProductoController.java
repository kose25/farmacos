package cjpg.farmacos.controller;


import cjpg.farmacos.excepcion.RecursoNotFoundExcepcion;
import cjpg.farmacos.models.Producto;
import cjpg.farmacos.services.EstadoService;
import cjpg.farmacos.services.IProductoService;
import cjpg.farmacos.services.ProductoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//http://localhost:8080/famacos-app
@RequestMapping("farmacos-app")
@CrossOrigin(value = "http://localhost:4200")
public class ProductoController {
    private static final Logger logger = LoggerFactory.getLogger(ProductoController.class);
    @Autowired
    private ProductoService productoService;
    @Autowired
    private EstadoService estadoService;
    @GetMapping("/productos")
    public List<Producto> GetProductos(){
        List<Producto> productos = this.productoService.ListarProductos();
        logger.info("productos obtenidos:");
        productos.forEach((s->logger.info(s.toString())));
        return productos;
    }

    @PostMapping("/productos")
    public Producto AgregarProducto(@RequestBody Producto producto){
        logger.info("Producto a Agregar: " + producto);
        producto.setEstado(this.estadoService.GetEstadoByCodigo("A"));
        return this.productoService.SaveProducto(producto);
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> ObtenerProductoById(@PathVariable int id){
        Producto producto = this.productoService.GetProductoById(id);
        if(producto != null){
            return ResponseEntity.ok(producto);
        }else{
            throw new RecursoNotFoundExcepcion("No se Encontro el id " + id);
        }

    }

    @PutMapping("/productos/{id}")
    public ResponseEntity<Producto> ActualizarProducto(@PathVariable int id, @RequestBody Producto productoRecibido){
        this.productoService.SaveProducto(productoRecibido);
        return ResponseEntity.ok(productoRecibido);
    }

    @DeleteMapping("/productos/{id}")
    public ResponseEntity<Map<String,Boolean>> EliminarProducto(@PathVariable int id){
        Producto producto = productoService.GetProductoById(id);
        if(producto == null){
            throw new RecursoNotFoundExcepcion("no se encontro el id: " + id);
        }
        this.productoService.InactivarProdcuto(producto.getId(), this.estadoService.GetEstadoByCodigo("I"));
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", true);
        return ResponseEntity.ok(respuesta);
    }

}
