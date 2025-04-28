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
    public void agendarCita(@RequestBody Cita cita) {
        agendaService.agregarCita(cita);
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
