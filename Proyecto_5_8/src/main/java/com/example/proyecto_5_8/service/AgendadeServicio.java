package com.example.proyecto_5_8.service;

import com.example.proyecto_5_8.model.Persona;
import com.example.proyecto_5_8.persistence.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendadeServicio {

    private final ValiadordeTelefono validadordeTelefono;
    private final PersonaRepository personaRepository;

    @Autowired
    public AgendadeServicio(ValiadordeTelefono validadordeTelefono, PersonaRepository personaRepository) {
        this.validadordeTelefono = validadordeTelefono;
        this.personaRepository = personaRepository;
    }

    public Persona guardarPersona(Persona persona) {
        String telefono = validadordeTelefono.limpiarNumero(persona.getTelefono());
        persona.setTelefono(telefono);
        return personaRepository.save(persona);
    }

    public List<Persona> getPersonas() {
        return personaRepository.findAll(Sort.by("nombre"));
    }
}