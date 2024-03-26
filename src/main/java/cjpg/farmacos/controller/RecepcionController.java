package cjpg.farmacos.controller;

import cjpg.farmacos.excepcion.RecursoNotFoundExcepcion;
import cjpg.farmacos.models.Proveedor;
import cjpg.farmacos.models.Recepcion;
import cjpg.farmacos.repository.RecepcionRepository;
import cjpg.farmacos.services.EstadoService;
import cjpg.farmacos.services.ProveedorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import cjpg.farmacos.services.RecepcionService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//http://localhost:8080/famacos-app
@RequestMapping("farmacos-app")
@CrossOrigin(value = "http://localhost:4200")
public class RecepcionController {
    private static final Logger logger = LoggerFactory.getLogger(ProveedorController.class);

    @Autowired
    private RecepcionService recepcionService;

    @Autowired
    private EstadoService estadoService;

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping("/recepcion")
    public List<Recepcion> GetRecepciones(){
        List<Recepcion> recepciones =  recepcionService.ListarRecepcion();
        logger.info("proveedores obtenidos:");
        recepciones.forEach((s->logger.info(s.toString())));
        return recepciones;
    }

    @GetMapping("/recepcionbyproveedor/{id}")
    public List<Recepcion> GetRecepcionesByProveedor(@PathVariable int id){
        Proveedor proveedor = proveedorService.GetProveedorById(id);
        if(proveedor!=null){
            List<Recepcion> recepciones =  recepcionService.ListarRecepcionByProveedor(proveedor);
            logger.info("recepciones obtenidos:");
            recepciones.forEach((s->logger.info(s.toString())));
            return recepciones;
        }else{
            throw new RecursoNotFoundExcepcion("No se encontro el id de proveedor: " + id);
        }
    }

    @PostMapping("/recepcion")
    public Recepcion AgregarRecepcion(@RequestBody Recepcion recepcion){
        logger.info("Producto a Agregar: " + recepcion);
        recepcion.setEstado(estadoService.GetEstadoByCodigo("A"));
        return this.recepcionService.SaveRecepcion(recepcion);
    }

    @GetMapping("/recepcion/{id}")
    public ResponseEntity<Recepcion> ObtenerRecepcionById(@PathVariable int id){
        Recepcion recepcion = this.recepcionService.GetRecepcionById(id);
        if(recepcion != null){
            return ResponseEntity.ok(recepcion);
        }else{
            throw new RecursoNotFoundExcepcion("No se encontro el id: " + id);
        }
    }

    @PutMapping("/recepcion/{id}")
    public ResponseEntity<Recepcion> ActualizarRecepcion(@PathVariable int id, @RequestBody Recepcion recepcion){
        this.recepcionService.SaveRecepcion(recepcion);
        return ResponseEntity.ok(recepcion);
    }

    @DeleteMapping("/recepcion/{id}")
    public ResponseEntity<Map<String, Boolean>> EliminarRecepcion(@PathVariable int id){
        Recepcion recepcion = recepcionService.GetRecepcionById(id);
        if (recepcion==null){
            throw new RecursoNotFoundExcepcion("no se encontro el id: " + id);
        }
        this.recepcionService.InactivarRecepcion(id, estadoService.GetEstadoByCodigo("I"));
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", true);
        return ResponseEntity.ok(respuesta);
    }
}
