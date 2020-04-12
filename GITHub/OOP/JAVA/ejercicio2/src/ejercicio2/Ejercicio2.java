/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Fede
 */
public class Ejercicio2 {

    public static void main(String[] args) {
        System.out.println("ingrese un numero");
        Scanner d= new Scanner(System.in);
        int num= d.nextInt();
        while(num<=0){
            JOptionPane.showMessageDialog(null, "el numero ingresado es 0 o menor a 0");
            num = d.nextInt();
        }
    }
	
    
    
}