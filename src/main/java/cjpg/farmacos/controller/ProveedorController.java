package cjpg.farmacos.controller;

import cjpg.farmacos.excepcion.RecursoNotFoundExcepcion;
import cjpg.farmacos.models.Producto;
import cjpg.farmacos.models.Proveedor;
import cjpg.farmacos.services.EstadoService;
import cjpg.farmacos.services.ProveedorService;
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
public class ProveedorController {
    private static final Logger logger = LoggerFactory.getLogger(ProveedorController.class);

    @Autowired
    private ProveedorService proveedorService;
    @Autowired
    private EstadoService estadoService;

    @GetMapping("/proveedores")
    public List<Proveedor> GetProveedores(){
        List<Proveedor> proveedores = proveedorService.ListarProveedores();
        logger.info("proveedores obtenidos:");
        proveedores.forEach((s->logger.info(s.toString())));
        return proveedores;
    }

    @PostMapping("/proveedores")
    public Proveedor AgregarProveedor(@RequestBody Proveedor proveedor){
        logger.info("Producto a Agregar: " + proveedor);
        proveedor.setEstado(estadoService.GetEstadoByCodigo("A"));
        return this.proveedorService.SaveProveedor(proveedor);
    }

    @GetMapping("/proveedores/{id}")
    public ResponseEntity<Proveedor> ObtenerProveedorById(@PathVariable int id){
        Proveedor proveedor = this.proveedorService.GetProveedorById(id);
        if(proveedor != null){
            return ResponseEntity.ok(proveedor);
        }else{
            throw new RecursoNotFoundExcepcion("No se Encontro el id " + id);
        }
    }

    @PutMapping("/proveedores/{id}")
    public ResponseEntity<Proveedor> ActualizarProveedor(@PathVariable int id, @RequestBody Proveedor proveedorRecibido){
        this.proveedorService.SaveProveedor(proveedorRecibido);
        return ResponseEntity.ok(proveedorRecibido);
    }

    @DeleteMapping("/proveedores/{id}")
    public ResponseEntity<Map<String,Boolean>> EliminarProveedor(@PathVariable int id){
        Proveedor proveedor = proveedorService.GetProveedorById(id);
        if(proveedor== null){
            throw new RecursoNotFoundExcepcion("no se encontro el id: " + id);
        }
        this.proveedorService.InactivarProveedor(id, estadoService.GetEstadoByCodigo("I"));
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", true);
        return ResponseEntity.ok(respuesta);
    }

}
