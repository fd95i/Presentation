/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onreadyej;
import java.util.*;
/**
 *
 * @author Fede
 */
public class OnreadyEJ {

    public static void main(String[] args) {
        Auto peugeot = new Auto("Peugeot","206",200000,4);
        Moto honda = new Moto("Honda", "Titan", "125c", 60000);
        Auto peugeot208 = new Auto("Peugeot","208",250000,5);
        Moto hondaYBR = new Moto("Honda", "YBR", "160c", 80500); 
        
        
        ArrayList<Vehiculo> lista = new ArrayList();
        lista.addAll(Arrays.asList(peugeot,honda,peugeot208,hondaYBR));
        Concesionaria concesionaria = new Concesionaria(lista);
        
        concesionaria.mostrarVehiculos();
        System.out.println("======================================");
        
        concesionaria.vehiculoMasCaro();
        concesionaria.vehiculoMasBarato();
        concesionaria.contieneLetraY();
        System.out.println("======================================");
        
        concesionaria.ordenarPorPrecio();
        
    }
    
}
