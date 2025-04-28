package com.example.gestorcitas.controller;

import com.example.gestorcitas.model.Cita;
import com.example.gestorcitas.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/citas")
@CrossOrigin(origins = "*") // Permitir peticiones del navegador
public class CitaController {

    @Autowired
    private AgendaService agendaService;

    @PostMapping("/agendar")
public ResponseEntity<String> agendarCita(@RequestBody Cita cita) {
    try {
        agendaService.agregarCita(cita);
        return ResponseEntity.ok("Cita agendada correctamente");
    } catch (IllegalStateException e) {
        // Si duplicada
        return ResponseEntity.status(HttpStatus.CONFLICT).body("❌ Ya existe una cita a esa hora.");
    } catch (Exception e) {
        // Errors
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("❌ Error inesperado al agendar.");
    }
}


    @PostMapping("/cancelar")
    public ResponseEntity<String> cancelarCita(@RequestBody CancelarRequest cancelarRequest) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
            LocalDateTime fecha = LocalDateTime.parse(cancelarRequest.getFechaHora(), formatter);
            agendaService.cancelarCita(fecha);
            return ResponseEntity.ok("Cita cancelada correctamente");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Error cancelando la cita: " + e.getMessage());
        }
    }




    @GetMapping
    public List<Cita> listarCitas() {
        return agendaService.obtenerCitas();
    }
}
