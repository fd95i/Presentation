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
public class Profesor extends Persona {
    String materia;
    int inasistencias;

    public Profesor(String materia, int inasistencias, String nombre, int edad, String sexo) {
        super(nombre, edad, sexo);
        this.materia = materia;
        this.inasistencias = inasistencias;
    }
    
    public String getMateria(){
    
    return materia;
    }
    public void setMateria(String otraMateria){
    materia=otraMateria;
    }
    
    
    public int getInasistencias(){
    return inasistencias;
    }
    public void setInasistencias(int inasistencias) {
        this.inasistencias = inasistencias;
    }
    
    public boolean libre(Aula aula){
    return inasistencias > 0.2 * aula.getCantClases();
    }
}
