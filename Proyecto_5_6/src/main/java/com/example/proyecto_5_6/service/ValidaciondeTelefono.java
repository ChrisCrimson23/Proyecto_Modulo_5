package com.example.proyecto_5_6.service;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class ValidaciondeTelefono {
    private static final Pattern PATTERN_TELEFONO = Pattern.compile("^(\\d{2,4}[- .]?){2}\\d{4}$");

    public boolean isValido(String telefono) {
        return PATTERN_TELEFONO.matcher(telefono).matches();
    }

    public String limpiaNumero(String telefono){
        return telefono.replaceAll("[^0-9]", "");
    }
}
