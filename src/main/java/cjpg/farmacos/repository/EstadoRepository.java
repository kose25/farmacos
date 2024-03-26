package cjpg.farmacos.repository;

import cjpg.farmacos.models.Estado;
import cjpg.farmacos.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EstadoRepository extends JpaRepository<Estado, Integer> {

    Estado findFirstByCodigo(String Codigo);
}
