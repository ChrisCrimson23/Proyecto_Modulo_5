package com.example.proyecto_5_6.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyecto_5_6.model.Persona;
import com.example.proyecto_5_6.persistence.MemoriadeAgendaDao;

import java.util.Set;

@Service
public class ServiciodeAgenda {
    private final ValidaciondeTelefono validaciondeTelefono;
    private final MemoriadeAgendaDao memoriadeAgendaDao;

    @Autowired
    public ServiciodeAgenda(ValidaciondeTelefono validaciondeTelefono, MemoriadeAgendaDao memoriadeAgendaDao) {
        this.validaciondeTelefono = validaciondeTelefono;
        this.memoriadeAgendaDao = memoriadeAgendaDao;
    }

    public Persona guardaPersona(Persona persona) {
        if (!validaciondeTelefono.isValido(persona.getTelefono())) {
            return null;
        }
        String telefono = validaciondeTelefono.limpiaNumero(persona.getTelefono());
        persona.setTelefono(telefono);
        return memoriadeAgendaDao.guardaPersona(persona);
    }
    public Set<Persona> getPersonas() {
        return memoriadeAgendaDao.getPersonas();
    }
}
