package com.example.proyecto_5_7.persistence;

import com.example.proyecto_5_7.model.Persona;
import com.example.proyecto_5_7.service.FormateadordeTelefono;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

@Repository

public class AgendadelaMemoriaDAO {
    private static final SortedSet<Persona> personas = new TreeSet<>();
    private final FormateadordeTelefono formateadordeTelefono;

    public AgendadelaMemoriaDAO(FormateadordeTelefono formateadordeTelefono) {
        this.formateadordeTelefono = formateadordeTelefono;
    }

    public Persona guardaPersona(Persona persona) {
        persona.setTelefono(formateadordeTelefono.formatea(persona.getTelefono()));
        personas.add(persona);
        return persona;
    }

    public Set<Persona> getPersonas() {
        return personas;
    }
}
