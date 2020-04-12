/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula;


public class Profesor extends Persona{
    private String materia;
    private boolean presente;
    private Libro bibliografiaOficial;
    
    
    //Constructor
    public Profesor(String nombre,int edad, String sexo,String materia,boolean presente){
        super(nombre,edad,sexo);
        this.materia = materia;
        this.presente = presente;
    }

    //Getter y setter
    public String getMateria() {
        return materia;
    }
    public void setMateria(String materia) {
        this.materia = materia;
    }
    public void adoptarBibliografiaOficial(Libro libro){
        bibliografiaOficial = libro;
    }
    public Libro bibliografiaOficial(){
        return bibliografiaOficial;
    }
    
    //Comportamiento
    public boolean estaDisponible(){
        return presente;
    }

}
