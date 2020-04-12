/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elmayor;

/**
 *
 * @author Fede
 */
public class Mayor {
    static void mayor(double num,double num1,double num2){
    if(num>num1 && num>num2){
        System.out.println(num);
    
    }else if(num1>num && num1>num2){
       System.out.println(num1);
    
    }else if(num2>num && num2>num1){
        System.out.println(num2);
    
    }
    
    
    }
}
