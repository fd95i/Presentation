/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package claseejercicio;
import java.util.Scanner;
/**
 *
 * @author alumno
 */
public class Aula {
    String materia;
    int maxAlumnos;
    int numAula;
    int bibliografia;
    final int cantClases =20;
    Estudiante[] lista= new Estudiante[maxAlumnos];
    int[] asistencia= new int[maxAlumnos];
    
    boolean disponible=false;
    
    public int getCantClases(){
        return cantClases;
    }
     public Aula(){} 
     public Aula(String materia, int maxAlumnos, int numAula, int bibliografia) {
        this.materia = materia;
        this.maxAlumnos = maxAlumnos;
        this.numAula = numAula;
        this.bibliografia = bibliografia;
    }

    public boolean isDisponible() {
        return  this.tomar_Lista()>maxAlumnos*0.5;
    }

    public Estudiante[] getLista() {
        return lista;
    }

    public void setLista(Estudiante[] lista) {
        this.lista = lista;
    }

    public int[] getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(int[] asistencia) {
        this.asistencia = asistencia;
    }
    
    
    
    public int getBibliografia() {
        return bibliografia;
    }

    public void setBibliografia(int bibliografia) {
        this.bibliografia = bibliografia;
    }
    
    

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    
    public int getMaxAlumnos() {
        return maxAlumnos;
    }

    public void setMaxAlumnos(int maxAlumnos) {
        this.maxAlumnos = maxAlumnos;
    }

    
    public int getNumAula() {
        return numAula;
    }

    public void setNumAula(int numAula) {
        this.numAula = numAula;
    }
    
    
    public int tomar_Lista(){
    int presentes=0;
    for(int i=0; i<maxAlumnos;i++){
    Scanner d=new Scanner(System.in);
    int pres=d.nextInt();
    asistencia[i]=pres;
    if(pres==0){
    
    int aux=lista[i].getInasistencias();
    aux=aux+1;
    lista[i].setInasistencias(aux);
    
            }else{presentes+=1;}
    }
    return presentes;}
   
    

    @Override
    public String toString() {
        return "Aula{" + "materia=" + materia + ", maxAlumnos=" + maxAlumnos + ", numAula=" + numAula + ", bibliografia=" + bibliografia + ", cantClases=" + cantClases + ", lista=" + lista + ", asistencia=" + asistencia + ", disponible=" + disponible + '}';
    }
    
}
