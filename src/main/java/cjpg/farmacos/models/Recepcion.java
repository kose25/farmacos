package cjpg.farmacos.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Recepcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @ManyToOne
    Producto producto;
    @ManyToOne
    Proveedor proveedor;
    Date fechaRecepcion;

    String numeroFactura;
    Integer cantidad;

    String registroInvima;
    Date fechaVencimiento;
    String descripcion;
    @ManyToOne
    Estado estado;
}
