package cjpg.farmacos.repository;

import cjpg.farmacos.models.Estado;
import cjpg.farmacos.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    @Query("SELECT p FROM Producto p WHERE p.estado.codigo = 'A'")
    List<Producto> findAllActiveProductos();

    @Modifying
    @Transactional
    @Query("UPDATE Producto p SET p.estado = ?2 WHERE p.id = ?1")
    void cambiarEstadoProducto(Integer id, Estado nuevoEstado);
}
