package cjpg.farmacos.repository;

import cjpg.farmacos.models.Estado;
import cjpg.farmacos.models.Proveedor;
import cjpg.farmacos.models.Recepcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface RecepcionRepository extends JpaRepository<Recepcion, Integer> {

    @Query("SELECT r FROM Recepcion r WHERE r.estado.codigo = 'A'")
    List<Recepcion> findAllActiveRecepciones();

    @Modifying
    @Transactional
    @Query("UPDATE Recepcion e SET e.estado = ?2 WHERE e.id = ?1")
    void cambiarEstadoRecepcion(Integer id, Estado nuevoEstado);

    List<Recepcion> findByProveedor(Proveedor proveedor);
}
