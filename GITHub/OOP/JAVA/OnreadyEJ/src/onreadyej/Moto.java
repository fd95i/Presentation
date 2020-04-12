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
public class Moto extends Vehiculo{
    String cilindrada;

    //Constructor
    public Moto(String marca, String modelo, String cilindrada, float precio) {
        super(marca, modelo, precio);
        this.cilindrada = cilindrada;
    }
    
    //Getters y Setters
    public String getCilindrada() {
        return cilindrada;
    }
    public void setCilindrada(String cilindrada) {
        this.cilindrada = cilindrada;
    }
    
    
    @Override
    public String toString() {
        return "Marca: " + super.getMarca() + " // Modelo: " + super.getModelo() + " // Cilindrada: " + cilindrada + " // Precio: $" + super.getPrecio();
    }
}
