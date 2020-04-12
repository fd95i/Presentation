/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp42;

/**
 *
 * @author Fede
 */
public class Handler {
    private String numeroStr;
    private String numerop5Str1;
    private String numerop5Str2;
    
    
    
    public int getDataFromWindowPunto4(){
        numeroStr = Punto4.numero.getText();
        return Integer.parseInt(numeroStr);
    }
    
    public String getDataFromWindowPunto5(){
        numerop5Str1 = Punto5.numero1.getText();
        numerop5Str2 = Punto5.numero2.getText();
        int resultado = Integer.parseInt(numerop5Str1) + Integer.parseInt(numerop5Str2);
        return Integer.toString(resultado);
    }
}
