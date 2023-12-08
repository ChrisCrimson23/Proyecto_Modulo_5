package com.example.proyecto_5_8.controller;

import com.example.proyecto_5_8.model.Persona;
import com.example.proyecto_5_8.service.AgendadeServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@Validated
public class ControladordeAgenda {

    private final AgendadeServicio agendadeServicio;

    @Autowired
    public ControladordeAgenda(AgendadeServicio agendadeServicio) {
        this.agendadeServicio = agendadeServicio;
    }

    @GetMapping({"/",  "/index"})
    public String formulariodeRegistro(Model model) {
        model.addAttribute("persona", new Persona());
        model.addAttribute("listadePersonas", agendadeServicio.getPersonas());
        return "index";
    }

    @PostMapping("/registro")
    public ModelAndView registra(@Valid Persona persona, BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView("index");

        if (bindingResult.hasErrors()) {
            mav.addObject("error", "Validation failed. Please check the input.");
        } else {
            agendadeServicio.guardarPersona(persona);
            mav.addObject("listadePersonas", agendadeServicio.getPersonas());
            mav.addObject("persona", new Persona());
        }

        return mav;
    }
}