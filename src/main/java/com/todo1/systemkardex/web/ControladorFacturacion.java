package com.todo1.systemkardex.web;

import com.todo1.systemkardex.domain.Persona;
import com.todo1.systemkardex.servicio.PersonaServiceImpl;
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
public class ControladorFacturacion {


    @GetMapping("/facturacion")
    public String inicio(Model model, @AuthenticationPrincipal User user) {
        return "facturacion/index";
    }

    @GetMapping("/facturacion/agregar")
    public String agregar(Persona persona) {
        return "modificar";
    }

    @PostMapping("/facturacion/guardar")
    public String guardar(@Valid Persona persona, Errors errores) {
        return "redirect:/facturacion/";
    }

    @GetMapping("/facturacion/editar/{idPersona}")
    public String editar(Persona persona, Model model) {
        return "/facturacion/modificar";
    }

    @GetMapping("/facturacion/eliminar")
    public String eliminar(Persona persona) {
        return "redirect:/facturacion/";
    }
}
