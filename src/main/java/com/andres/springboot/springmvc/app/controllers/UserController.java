package com.andres.springboot.springmvc.app.controllers;

import com.andres.springboot.springmvc.app.entities.Cliente;
import com.andres.springboot.springmvc.app.services.Service;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/users")
@SessionAttributes({"user"})
public class UserController {

    private final Service<Cliente> service;

    public UserController(Service<Cliente> service) {
        this.service = service;
    }

    @GetMapping("/view")
    public String viewData(Model model) {
        model.addAttribute("title", "Hola Mundo Spring Boot!!!");
        model.addAttribute("message", "Esta es una aplicación de ejemplo usando Spring Boot!!!");
        //model.addAttribute("user", new Cliente("Andres", "Guzman"));
        return "view.html";
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("title", "Listado de usuarios");
        model.addAttribute("users", service.findAll());
        return "list";
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("user", new Cliente());
        model.addAttribute("title", "Crear Usuario");
        return "form";
    }

    @GetMapping("/form/{id}")
    public String form(@PathVariable Integer id, Model model, RedirectAttributes redirect) {
        Optional<Cliente> optionalUser = service.findById(id);
        if (optionalUser.isPresent()) {
            model.addAttribute("user", optionalUser.get());
            model.addAttribute("title", "Editar Usuario");

            return "form";
        } else {
            redirect.addFlashAttribute("error", "El usuario con id " +
                    id +
                    " no existe en la base de datos!");

            return "redirect:/users";
        }
    }

    @PostMapping
    public String form(@Valid Cliente user, BindingResult result, Model model, RedirectAttributes redirect, SessionStatus status) {

        if(result.hasErrors()){
            model.addAttribute("title", "Validando Formulario");
            return "form";
        }
        String message = (user.getId() != null && user.getId() > 0)? "El usuario " +
                user.getNombre() +
                " se ha actualizado con exito!" : "El usuario " +
                user.getNombre() +
                " se ha creado con exito!";

        service.save(user);
        status.setComplete();
        redirect.addFlashAttribute("success", message);
        return "redirect:/view";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirect) {
        Optional<Cliente> optionalUser = service.findById(id);
        if (optionalUser.isPresent()) {
            redirect.addFlashAttribute("success", "El usuario " +
                    optionalUser.get().getNombre() +
                    " se ha eliminado con exito!");
            service.remove(id);
            return "redirect:/users";
        }
        redirect.addFlashAttribute("error", "Error el usuario con el id " +
                id +
                " no existe en el sistema");
        return "redirect:/users";

    }

}
