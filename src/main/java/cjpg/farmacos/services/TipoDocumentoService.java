package cjpg.farmacos.services;

import cjpg.farmacos.models.TipoDocumento;
import cjpg.farmacos.repository.TipoDocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoDocumentoService implements ITipoDocumentoService {

    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;
    @Override
    public List<TipoDocumento> ListarTipoDocumento() {
        return this.tipoDocumentoRepository.findAllActiveTiposDocumentos();
    }
}
