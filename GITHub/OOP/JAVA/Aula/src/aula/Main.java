/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula;
import java.util.*;
/**
 *
 * @author Fede
 */
public class Main {
        public static void main(String[] args) {
            Estudiante churra = new Estudiante(10,"Churra",21,"Femenino",true);
            Estudiante churro = new Estudiante(10,"Churro",23,"Masculino",true);
            Estudiante ova = new Estudiante(7,"Ova",23,"Masculino",true);
            Estudiante daro = new Estudiante(9,"Daro",23,"Masculino",false);
            
            Profesor mauldhart = new Profesor("Martin",40,"Masculino","Matematica",true);
            Libro mateparagordas = new Libro(959,"Matematica para gorditas bebé","Churringui","Matematica",480);
            mauldhart.adoptarBibliografiaOficial(mateparagordas);
            
            Aula aula = new Aula(132,4,"Matematica",mauldhart);
            aula.setEstudiantes(Arrays.asList(churra,churro,ova,daro));
            System.out.println(aula.puedeDarClase());
            aula.estudiantesAprobados();
            aula.bibliografiaOficialDeLaMateria();
    }
}
