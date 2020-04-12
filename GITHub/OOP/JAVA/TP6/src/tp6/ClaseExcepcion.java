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
public class ClaseExcepcion {
    
    String errno = "Excepcion inventada";
    
    public void main(){
        try{
            throw new Exception(errno);
        }catch(Exception e){
            System.out.println(errno);
        }finally{
            System.out.println("Hubo una exception de tipo " + errno);
        }
    }
}
