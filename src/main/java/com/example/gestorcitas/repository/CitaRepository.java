package com.example.gestorcitas.repository;

import com.example.gestorcitas.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface CitaRepository extends JpaRepository<Cita, Long> {
    Optional<Cita> findByFechaHora(LocalDateTime fechaHora);
    boolean existsByFechaHora(LocalDateTime fechaHora);
    void deleteByFechaHora(LocalDateTime fechaHora);
}
