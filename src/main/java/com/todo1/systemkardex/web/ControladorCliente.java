package com.todo1.systemkardex.web;

import com.todo1.systemkardex.domain.Persona;
import com.todo1.systemkardex.servicio.IPersonaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@Slf4j
public class ControladorCliente {

    @Autowired
    private IPersonaService personaService;

    @GetMapping("/cliente")
    public String inicio(Model model, @AuthenticationPrincipal User user) {
        var map = personaService.initClient();
        log.info("Usuario que hizo login: " + user);
        for (String key : map.keySet()) {
            model.addAttribute(key, map.get(key));
        }
        return "cliente/index";
    }

    @GetMapping("/cliente/agregar")
    public String agregar(Persona persona) {
        return "modificar";
    }

    @PostMapping("/cliente/guardar")
    public String guardar(@Valid Persona persona, Errors errores) {
        if (errores.hasErrors()) return "/cliente/modificar";
        personaService.guardar(persona);
        return "redirect:/cliente/";
    }

    @GetMapping("/cliente/editar/{idPersona}")
    public String editar(Persona persona, Model model) {
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona", persona);
        return "/cliente/modificar";
    }

    @GetMapping("/cliente/eliminar")
    public String eliminar(Persona persona) {
        personaService.eliminar(persona);
        return "redirect:/cliente/";
    }
}
