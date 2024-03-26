package cjpg.farmacos.services;

import cjpg.farmacos.models.TipoDocumento;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITipoDocumentoService {
    public List<TipoDocumento> ListarTipoDocumento();
}
