package com.example.proyecto_5_6.controller;

import com.example.proyecto_5_6.model.Persona;
import com.example.proyecto_5_6.service.ServiciodeAgenda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/agenda")
public class ControladordeAgenda {

    private final ServiciodeAgenda serviciodeAgenda;

    @Autowired
    public ControladordeAgenda(ServiciodeAgenda serviciodeAgenda) {
        this.serviciodeAgenda = serviciodeAgenda;
    }

    @PostMapping
    public ResponseEntity<Persona> guardaPersona(@RequestBody Persona persona) {
        Persona resultado = serviciodeAgenda.guardaPersona(persona);

        if (resultado == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(resultado);
    }

    @GetMapping
    public ResponseEntity<Set<Persona>> getPersonas(){
        return ResponseEntity.ok(serviciodeAgenda.getPersonas());
    }
}
