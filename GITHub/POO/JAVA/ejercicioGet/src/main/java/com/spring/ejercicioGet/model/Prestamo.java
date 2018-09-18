package com.spring.ejercicioGet.model;

public class Prestamo {
    int nombre;
    int apellido;
    int deudas;
    int puntuacion_del_banco;
    int ahorros;

    //getters y setters
    public int getNombre() {
        return nombre;
    }
    public void setNombre(int nombre) {
        this.nombre = nombre;
    }
    public int getApellido() {
        return apellido;
    }
    public void setApellido(int apellido) {
        this.apellido = apellido;
    }
    public int getDeudas() {
        return deudas;
    }
    public void setDeudas(int deudas) {
        this.deudas = deudas;
    }
    public int getPuntuacion_del_banco() {
        return puntuacion_del_banco;
    }
    public void setPuntuacion_del_banco(int puntuacion_del_banco) {
        this.puntuacion_del_banco = puntuacion_del_banco;
    }
    public int getAhorros() {
        return ahorros;
    }
    public void setAhorros(int ahorros) {
        this.ahorros = ahorros;
    }
}
