package com.spring.ejercicioGet.model;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class Chofer {
    private String nombre;
    private String apellido;
    private String modeloAuto;
    private String colorRopa;



    //Getters y setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getModeloAuto() {
        return modeloAuto;
    }
    public void setModeloAuto(String modeloAuto) {
        this.modeloAuto = modeloAuto;
    }
    public String getColorRopa() {
        return colorRopa;
    }
    public void setColorRopa(String colorRopa) {
        this.colorRopa = colorRopa;
    }
}
