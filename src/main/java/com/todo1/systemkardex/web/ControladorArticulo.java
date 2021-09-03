package com.todo1.systemkardex.web;

import com.todo1.systemkardex.domain.Articulo;
import com.todo1.systemkardex.servicio.ArticuloServiceImpl;
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
public class ControladorArticulo {

    @Autowired
    private ArticuloServiceImpl articuloService;

    @GetMapping("/articulo")
    public String inicio(Model model, @AuthenticationPrincipal User user) {
        var map = articuloService.initArticulo();
        log.info("Usuario que hizo login: " + user);
        for (String key : map.keySet()) {
            model.addAttribute(key, map.get(key));
        }
        return "articulo/index";
    }

    @GetMapping("/articulo/agregar")
    public String agregar(Articulo articulo) {
        return "modificar";
    }

    @PostMapping("/articulo/guardar")
    public String guardar(@Valid Articulo articulo, Errors errores) {
        if (errores.hasErrors()) return "modificar";
        articuloService.guardar(articulo);
        return "redirect:/articulo/";
    }

    @GetMapping("/articulo/editar/{idArticulo}")
    public String editar(Articulo articulo, Model model) {
        articulo = articuloService.encontrarArticulo(articulo);
        model.addAttribute("articulo", articulo);
        return "/articulo/modificar";
    }

    @GetMapping("/articulo/eliminar")
    public String eliminar(Articulo articulo) {
        articuloService.eliminar(articulo);
        return "redirect:/articulo/";
    }
}
