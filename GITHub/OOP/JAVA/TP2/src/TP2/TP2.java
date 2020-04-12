/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP2;

import java.util.*;
import javax.swing.JOptionPane;

    public class TP2 {
        public static void main(String args[]){
            Scanner in = new Scanner(System.in);
            int numero1,numero2,numero3;

            //Ejercicio 1
            System.out.println("Ingrese tres números.");
            numero1 = in.nextInt();
            numero2 = in.nextInt();
            numero3 = in.nextInt();
            int numMayor = mayorDeTres(numero1,numero2,numero3);
            System.out.println("El número mayor es: " + numMayor);
            
            //Ejercicio 2
            System.out.println("Ingrese un número mayor a 0 para calcular su raiz y potencia.");
            numero1=in.nextInt();
            raizYpotencia(numero1);
            
            //Ejercicio3
            System.out.println("Ingrese una fecha para determinar si es válida.");
            numero1=in.nextInt();
            numero2=in.nextInt();
            numero3=in.nextInt();
            fechaValida(numero1,numero2,numero3);
            
            //Ejercicio 4
            System.out.println("Ingrese un número mayor a 0 para determinar aleatoriamente las calificaciones de un grupo de estudiantes.");
            numero1=in.nextInt();
            gruposEstudiantes(numero1);
            
            //Ejercicio 5
            System.out.println("Ingrese un número mayor a 0 para determinar una longitud de vectores y mostrar las sumas y restas en un rango entre -100 y 100.");
            numero1=in.nextInt();
            juegoDeVectores(numero1);
        }

        public static int mayorDeTres(int numero1, int numero2, int numero3){
            if(numero1>numero2){
                if(numero1>numero3) return numero1;
                else return numero3;
            }
            else{
                if(numero2>numero3) return numero2;
                else return numero3;
            }
        }
        public static void raizYpotencia(int numero){
            if(numero <= 0){ 
                JOptionPane.showMessageDialog(null,"El número no es correcto.");      
            }
            System.out.println("Del número " + numero + " su raiz es " + Math.sqrt(numero) + " y su potencia es " + Math.pow(numero,numero));
        }
        public static void fechaValida(int dia,int mes,int año){
            if(año>0){
            if(mes>0 && mes<13){
                if(mes ==1 || mes==3 || mes==5 || mes==7 || mes==8 || mes==10 || mes==12){
                    if(dia>0 && dia<32) System.out.println("Fecha válida: día " + dia + " del mes " + mes + " del año " + año);
                    else JOptionPane.showMessageDialog(null,"Fecha inválida.");
                }else if(mes!=2){
                    if(dia>0 && dia<31) System.out.println("Fecha válida: día " + dia + " del mes " + mes + " del año " + año);
                    else JOptionPane.showMessageDialog(null,"Fecha inválida.");
                }else{
                    if(dia==29 && (año%400==0) || ((año%100!=0) && (año%4==0))) System.out.println("Fecha válida: día " + dia + " del mes " + mes + " del año " + año);
                    else if(dia>0 && dia<29) System.out.println("Fecha válida: día " + dia + "del mes " + mes + " del año " + año);
                    else JOptionPane.showMessageDialog(null,"Fecha inválida.");
                }
            }else JOptionPane.showMessageDialog(null,"Fecha inválida.");
            }else JOptionPane.showMessageDialog(null,"Fecha invalida.");
        }
        public static void gruposEstudiantes(int cantidadDeAlumnos){
            int[] array = new int[cantidadDeAlumnos];
            int contadorBajoConocimientos = 0,contadorRegulares = 0,contadorBuenos = 0,contadorMuyBuenos = 0,contadorExcelentes = 0;
            for(int i=0;i<cantidadDeAlumnos;i++){
                array[i] = (int) (Math.random()*((10-0)+1))+0;
                switch (array[i]){
                    case 0: contadorBajoConocimientos++;break;
                    case 1: contadorBajoConocimientos++;break;
                    case 2: contadorBajoConocimientos++;break;
                    case 3: contadorBajoConocimientos++;break;
                    case 4: contadorBajoConocimientos++;break;                        
                    case 5: contadorRegulares++;break;
                    case 6: contadorBuenos++;break;
                    case 7: contadorBuenos++;break;
                    case 8: contadorMuyBuenos++;break;
                    case 9: contadorMuyBuenos++;break;                        
                    case 10:contadorExcelentes++;break;
                    default:break;
                }
            }
            System.out.println("Estudiantes bajos de conocimiento: " + contadorBajoConocimientos);
            System.out.println("Estudiantes regulares: " + contadorRegulares);
            System.out.println("Estudiantes buenos: " + contadorBuenos);
            System.out.println("Estudiantes muy buenos: " + contadorMuyBuenos);
            System.out.println("Estudiantes excelentes: " + contadorExcelentes);
        }
        public static void juegoDeVectores(int cantidad){
            int[] arrayA = new int[cantidad];
            int[] arrayB = new int[cantidad];
            int erroresVectorC=0,erroresVectorD=0;
            
            for(int i=0;i<cantidad;i++) {arrayA[i] = (int) (Math.random()*((100-(-100))+1))+(-100); System.out.println("En vector A: Posicion " + i + " contiene el número: " + arrayA[i]);}
            for(int j=0;j<cantidad;j++) {arrayB[j] = (int) (Math.random()*((100-(-100))+1))+(-100); System.out.println("En vector B: Posicion " + j + " contiene el número: " + arrayB[j]);}
            
            int[] arrayC = new int[cantidad];
            for(int k=0;k<cantidad;k++){
                arrayC[k] = arrayA[k] + arrayB[k];
                System.out.println("En vector C: Posicion " + k + " contiene el número: " + arrayC[k]);
                if(arrayC[k]>100||arrayC[k]<-100) erroresVectorC++;
            }
            int[] arrayD = new int[cantidad];
            for(int l=0;l<cantidad;l++){
                arrayD[l] = arrayA[l] - arrayB[l];
                System.out.println("En vector D: Posicion " + l + " contiene el número: " + arrayD[l]);
                if(arrayD[l]>100||arrayD[l]<100) erroresVectorD++;
            }
            
            if(erroresVectorC>0) JOptionPane.showMessageDialog(null,"El vector C está fuera de rango");
            if(erroresVectorD>0) JOptionPane.showMessageDialog(null,"El vector D está fuera de rango");
        }
        
    }

