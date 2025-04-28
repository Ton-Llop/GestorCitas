package com.example.gestorcitas.service;

import com.example.gestorcitas.model.Cita;
import com.example.gestorcitas.repository.CitaRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AgendaService {

    @Autowired
    private CitaRepository citaRepository;

    public void agregarCita(Cita cita) {
        citaRepository.save(cita);
    }

    @Transactional
    public void cancelarCita(LocalDateTime fechaHora) {
        citaRepository.deleteByFechaHora(fechaHora);
    }

    public List<Cita> obtenerCitas() {
        return citaRepository.findAll();
    }
}
