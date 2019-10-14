package com.spring.clase4;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class miControlador {
    @GetMapping("/saludo")
    public String hola(@RequestParam("nombre") String nombre){
        return "Hola " + nombre;
    }
    @GetMapping("/saludoApellido")
    public String holaApellido(@RequestParam("nombre") String nombre,
                               @RequestParam("apellido") String apellido,
                               @RequestParam("edad" ) int edad){
        return "Hola sos " + nombre + " " + apellido + " y tu edad es: " + edad;
    }
}
