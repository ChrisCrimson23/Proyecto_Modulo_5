package com.example.proyecto_5_7.service;

import org.springframework.stereotype.Service;

@Service
public class ValidadordeTelefono {
    public String limpiaNumero(String telefono) {
        if (telefono != null) {
            return telefono.replaceAll("[^0-9]", "");
        } else {
            return null;
        }
    }
}
