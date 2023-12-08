package com.example.proyecto_5_7.controller;

import com.example.proyecto_5_7.model.Persona;
import com.example.proyecto_5_7.service.ServiciodeAgenda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class AgendadelControlador {

    private final ServiciodeAgenda serviciodeAgenda;

    @Autowired
    public AgendadelControlador(ServiciodeAgenda serviciodeAgenda) {
        this.serviciodeAgenda = serviciodeAgenda;
    }

    @GetMapping({"/", "/index"})
    public String formulariodeRegistro(Model model) {
        model.addAttribute("persona", new Persona());
        model.addAttribute("listaPersonas", serviciodeAgenda.getPersonas());

        return "index";
    }

    @PostMapping("/registro")
    public ModelAndView registra(@Valid Persona persona, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            redirectAttributes.addAttribute("listaPersonas", serviciodeAgenda.getPersonas());
            return new ModelAndView("index");
        }
        String nombreDesdeFormulario = persona.getNombre();
        persona.setNombre(nombreDesdeFormulario);
        serviciodeAgenda.guardaPersona(persona);

        ModelAndView mav = new ModelAndView("redirect:/index");
        mav.addObject("mensaje", "Persona registrada con éxito");
        return mav;
    }
}