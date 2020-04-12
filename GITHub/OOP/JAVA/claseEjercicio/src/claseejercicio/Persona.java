/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package claseejercicio;

/**
 *
 * @author melanie_sol
 */
public class Persona {
    String nombre;
    int edad;
    String sexo;

    public Persona(String nombre, int edad, String sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
    }
    
    public String getNombre(String nombre){
    return nombre;
    }
    public void setNombre(String unNombre){
    nombre= unNombre;
    }
    
    public int getEdad(int edad){
    return edad;
    }
    public void setEdad(int unaEdad){
    edad= unaEdad;
    }
    
    public String getSexo(String sexo){
    return sexo;
    }
    public void setSexo(String sexoNuevo){
    sexo= sexoNuevo;
    }
}
