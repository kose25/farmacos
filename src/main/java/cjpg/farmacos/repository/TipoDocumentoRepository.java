package cjpg.farmacos.repository;

import cjpg.farmacos.models.Producto;
import cjpg.farmacos.models.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, Integer> {
    @Query("SELECT t FROM TipoDocumento t WHERE t.estado.codigo = 'A'")
    List<TipoDocumento> findAllActiveTiposDocumentos();
}
