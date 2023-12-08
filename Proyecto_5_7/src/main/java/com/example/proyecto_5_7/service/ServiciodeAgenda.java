package com.example.proyecto_5_7.service;

import com.example.proyecto_5_7.model.Persona;
import com.example.proyecto_5_7.persistence.AgendadelaMemoriaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ServiciodeAgenda {
    private final ValidadordeTelefono validadordeTelefono;
    private final AgendadelaMemoriaDAO agendaDao;

    @Autowired
    public ServiciodeAgenda(ValidadordeTelefono validadordeTelefono, AgendadelaMemoriaDAO agendaDao) {
        this.validadordeTelefono = validadordeTelefono;
        this.agendaDao = agendaDao;
    }

    public Persona guardaPersona(Persona persona) {
        String telefono = validadordeTelefono.limpiaNumero(persona.getTelefono());

        persona.setTelefono(telefono);

        return agendaDao.guardaPersona(persona);
    }

    public Set<Persona> getPersonas() {
        return agendaDao.getPersonas();
    }

}
