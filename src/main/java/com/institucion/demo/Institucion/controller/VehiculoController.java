package com.institucion.demo.Institucion.controller;

import com.institucion.demo.Institucion.Excepciones.MiException;
import com.institucion.demo.Institucion.entities.Persona;
import com.institucion.demo.Institucion.entities.Propietario;
import com.institucion.demo.Institucion.entities.Vehiculo;
import com.institucion.demo.Institucion.services.Vehiculo_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/vehiculo")
public class VehiculoController {

    @Autowired
    private Vehiculo_Service vehiculoService;

    @PreAuthorize("isAuthenticated()")
    @RequestMapping("/crear")
    public String crearPersona(Model model) {
        model.addAttribute("vehiculo", new Vehiculo());

        return "persona/crearPersona.html";
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/creado", method = RequestMethod.POST)
    public String crearPersona(@ModelAttribute("vehiculo") Vehiculo coche, ModelMap model) throws MiException {
        try {
            vehiculoService.crearVehiculo(coche);
        } catch (MiException e) {

            model.addAttribute("vehiculo", new Vehiculo());

            model.put("error", e.getMessage());
            return "persona/crearPersona.html";
            
        }
        return "persona/crearPersona.html";
    }
}
