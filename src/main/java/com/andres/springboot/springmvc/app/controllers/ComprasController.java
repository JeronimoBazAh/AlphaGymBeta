package com.andres.springboot.springmvc.app.controllers;


import com.andres.springboot.springmvc.app.entities.Compras;
import com.andres.springboot.springmvc.app.services.Service;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/cobros")
public class ComprasController {
    private final Service<Compras> service;
    public ComprasController(Service<Compras> service) {
        this.service = service;
    }

    @GetMapping("/cobross")
    public String cobros(){

        return "cobros.html";
    }

    @PostMapping
    public String cobrosPost(@Valid Compras compras, BindingResult result, Model model, RedirectAttributes redirect, SessionStatus status){
        if(result.hasErrors()){
            model.addAttribute("title", "Error al guardar");
            return "cobros.html";
        }
        String message = "Se ha realizado la compra con exito";
        service.save(compras);
        status.setComplete();


        return "redirect:/cobros.html";
    }


}
