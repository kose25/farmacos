package cjpg.farmacos.controller;

import cjpg.farmacos.models.TipoDocumento;
import cjpg.farmacos.services.TipoDocumentoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//http://localhost:8080/famacos-app
@RequestMapping("farmacos-app")
@CrossOrigin(value = "http://localhost:4200")
public class TipoDocumentoController {
    private static final Logger logger = LoggerFactory.getLogger(ProveedorController.class);

    @Autowired
    private TipoDocumentoService tipoDocumentoService;

    @GetMapping("/tipodocumento")
    public List<TipoDocumento> GetTipoDocumentos(){
        List<TipoDocumento> tipoDocumentos = this.tipoDocumentoService.ListarTipoDocumento();
        logger.info("proveedores obtenidos:");
        tipoDocumentos.forEach((s->logger.info(s.toString())));
        return tipoDocumentos;
    }

}
