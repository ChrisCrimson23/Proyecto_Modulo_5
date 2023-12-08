package com.example.proyecto_5_8.service;

import org.springframework.stereotype.Service;

@Service
public class ValiadordeTelefono {
    public String limpiarNumero(String telefono) {
        return telefono != null ? telefono.replaceAll("[^0-9]", "") : null;
    }
    }
