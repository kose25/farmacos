package cjpg.farmacos.repository;

import cjpg.farmacos.models.Estado;
import cjpg.farmacos.models.Producto;
import cjpg.farmacos.models.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {
    @Query("SELECT p FROM Proveedor p WHERE p.estado.codigo = 'A'")
    List<Proveedor> findAllActiveProveedores();

    @Modifying
    @Transactional
    @Query("UPDATE Proveedor p SET p.estado = ?2 WHERE p.id = ?1")
    void cambiarEstadoProveedor(Integer id, Estado nuevoEstado);
}
