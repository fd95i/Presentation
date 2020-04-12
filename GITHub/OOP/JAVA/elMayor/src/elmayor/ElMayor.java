/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elmayor;
import java.util.Scanner;
/**
 *
 * @author Fede
 */
public class ElMayor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("ingrese 3 numeros:");
        Scanner d= new Scanner(System.in);
        double num= d.nextDouble();
        Scanner d1=new Scanner(System.in);
        double num1=d1.nextDouble();
        Scanner d2=new Scanner(System.in);
        double num2=d2.nextDouble();
        
        Mayor.mayor(num, num1, num2);
    }
    
}
