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
public class Estudiante extends Persona {
    int calif;
    int inasistencias;

    public Estudiante(String nombre, int edad, String sexo,int calif, int inasistencias) {
        super(nombre,edad,sexo);
        this.calif = calif;
        this.inasistencias = inasistencias;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getCalif(){
    return calif;
    }
    public void setCalif(int otraCalif){
    calif=otraCalif;
    }
    
    public int getInasistencias(){
    return inasistencias;
    }

    public void setInasistencias(int inasistencias) {
        this.inasistencias = inasistencias;
    }
    
    public boolean libre(Aula aula){
    return this.inasistencias > aula.getCantClases() *0.5;
    }
    
}
