package cjpg.farmacos.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String nombre;
    String numeroIdentifiacion;
    String direccion;
    String nombreContacto;
    String celular;
    @ManyToOne
    TipoDocumento tipoDocumento;
    @ManyToOne
    Estado estado;

}
