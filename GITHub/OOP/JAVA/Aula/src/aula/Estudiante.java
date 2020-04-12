/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula;

/**
 *
 * @author Fede
 */
public class Estudiante extends Persona {
    private double calificacionActual;
    private boolean presente;

    public Estudiante(double calificacionActual, String nombre, int edad, String sexo, boolean ausente){
        super(nombre,edad,sexo);
        this.calificacionActual = calificacionActual;
        this.presente = ausente;
    }

    public double calificacionActual(){
        return calificacionActual;
    }
    public void calificacionActual(int unaCalificacion){
        calificacionActual = unaCalificacion;
    }
    public boolean estaDisponible(){
        return presente;
    }

}
