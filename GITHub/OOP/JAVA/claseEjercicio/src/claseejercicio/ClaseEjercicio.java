/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package claseejercicio;
import java.util.*;
/**
 *
 * @author alumno
 */
public class ClaseEjercicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
        Estudiante estudiante1 = new Estudiante("fede", 23, "masculino", 10, 5);
        Estudiante estudiante2 = new Estudiante("mel", 18, "femenino", 10, 1);
        Estudiante estudiante3 = new Estudiante("jose", 18, "masculino", 6, 2);
        Estudiante estudiante4 = new Estudiante("carlos", 18, "masculino", 4, 3);
        Estudiante estudiante5 = new Estudiante("sofia", 18, "femenino", 2, 7);
        Estudiante estudiante6 = new Estudiante("mica", 18, "femenino", 8, 10);
        
        
        Aula aula1= new Aula();
        aula1.setMateria("fisica");
        aula1.setMaxAlumnos(2);
        aula1.setNumAula(58);
        aula1.setBibliografia(18);
        Estudiante[] lista= new Estudiante[aula1.getMaxAlumnos()];
        
        for(int i=0;i<aula1.getMaxAlumnos();i++){
        Scanner d=new Scanner(System.in);
        String nombre=d.nextLine();
        int edad=d.nextInt();
        String sexo ="masculino";
        int calif=d.nextInt();
        int inasistencias=d.nextInt();
        lista[i] = new Estudiante(nombre,edad,sexo,calif,inasistencias);
        
        }
        
        System.out.println(Arrays.toString(lista));
        
        Profesor profesor1 =new Profesor("fisica", 5,"martin",39, "masculino");
        
       // Estudiante[] lista1 = {estudiante1, estudiante2, estudiante3, estudiante4, estudiante5, estudiante6};
       
       System.out.println(aula1.toString());
               
    }
    
}
