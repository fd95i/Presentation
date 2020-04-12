/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onreadyej;

/**
 *
 * @author Fede
 */
public class Auto extends Vehiculo{
    public int puertas;

    //Constructor   
    public Auto(String marca, String modelo, float precio,int puertas) {
        super(marca, modelo, precio);
        this.puertas = puertas;
    }

    //Getters y setters
    public int getPuertas() {
        return puertas;
    }
    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }
    
    
    //toString
    @Override
    public String toString() {
        return "Marca: " + super.getMarca() + " // Modelo: " + super.getModelo() + " // Puertas: " + puertas + " // Precio: $" + super.getPrecio();
    }
    
}
