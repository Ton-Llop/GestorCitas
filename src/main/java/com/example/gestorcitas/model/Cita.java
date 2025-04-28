package com.example.gestorcitas.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fechaHora;

    @Embedded
    private Cliente cliente;

    private String servicio;

    public Cita() {}

    public Cita(LocalDateTime fechaHora, Cliente cliente, String servicio) {
        this.fechaHora = fechaHora;
        this.cliente = cliente;
        this.servicio = servicio;
    }

    // Getters y Setters
    public LocalDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public String getServicio() { return servicio; }
    public void setServicio(String servicio) { this.servicio = servicio; }
}
