package com.example.gestorcitas.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Cliente {
    private String nombre;
    private String telefono;
    private String email;

    public Cliente() {} // Constructor vacío requerido por Spring

    
    public Cliente(String nombre, String telefono, String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
