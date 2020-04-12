/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp6;

/**
 *
 * @author Fede
 */
public class TP6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // ejercicio1();
        // ejercicio2();
        /* ejercicio3
        ClaseExcepcion classex = new ClaseExcepcion();
        classex.main();
        */
        // ejercicio4();
        // ejercicio5();
    }
    
    public static void ejercicio1(){
        System.out.println("Intentamos ejecutar el bloque de instrucciones: ");
        System.out.println("Instrucción 1.");
        System.out.println("Instrucción 2.");
        System.out.println("Instrucción 3, etc.");
        System.out.println("Instrucciones a ejecutar finalmente tanto si se producen errores como si no.");
    }    
    public static void ejercicio2(){
        System.out.println("Intentamos ejecutar el bloque de instrucciones: ");
        System.out.println("Instrucción 1.");
        try{
            Integer.parseInt("M");
            System.out.println("Instrucción 2.");
            System.out.println("Instrucción 3, etc.");
        }catch(NumberFormatException e){
            System.out.println("Instrucciones a ejecutar cuando se produce un error");
        }finally{
            System.out.println("Instrucciones a ejecutar finalmente tanto si se producen errores como si no.");
        }
    }
    public static void ejercicio4(){
        try{
            MiExcepcion e = new MiExcepcion("ExcepcionCreadaPorUsuario");
            throw e;
        }catch(MiExcepcion e){
            System.out.println("Hubo una excepción ( ! ) de tipo " + e.getMessage());
        }
    }
    public static void ejercicio5(){
        int controlador = 5;
        
        while(controlador != 0){
            try{
                throw new MiExcepcion("NumeroDistintoDe0");
            }catch(MiExcepcion e){
                System.out.println("El número sigue siendo distinto de 0, excepción " + e.getMessage());
            }finally{
                controlador--;
            }
        }
        System.out.println("Retornando la ejecución...");
        
    }
}
