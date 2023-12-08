package com.example.proyecto_5_8.persistence;

import com.example.proyecto_5_8.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
