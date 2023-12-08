package com.example.proyecto_5_6.persistence;

import com.example.proyecto_5_6.model.Persona;

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Set;

import org.springframework.stereotype.Repository;

@Repository
public class MemoriadeAgendaDao {
    private static final SortedSet<Persona> personas = new TreeSet<>();

    public Persona guardaPersona(Persona persona) {
        personas.add(persona);
        return persona;
    }

    public Set<Persona> getPersonas() {
        return personas;
    }
}
