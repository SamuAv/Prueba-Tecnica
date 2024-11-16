package com.example.Logistica.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Envio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String tipoProducto;
    private int cantidadProducto;
    private LocalDate fechaRegistro;
    private LocalDate fechaEntrega;
    private String bodegaEntrega;
    private double precioEnvio;
    private double descuentoEnvio;
    private double precioEnvioFinal;
    private String placaVehiculo;

    @Column(unique = true)
    private String numeroGuia;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

}
