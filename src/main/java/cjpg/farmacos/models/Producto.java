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
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String codigo;
    String nombre;
    String descripcion;
    String laboratorio;
    @ManyToOne
    Estado estado;

}
