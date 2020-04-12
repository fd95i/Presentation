/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paseoinfernal;

/**
 *
 * @author Fede
 */
public class Alma {
    private String nombre;
    private boolean esFriolenta;
    private int nivelDeBondad;
    private int nivelDeValor;
    
    public Alma(String nombre,boolean esFriolenta,int nivelDeBondad,int nivelDeValor){
        this.nombre = nombre;
        this.esFriolenta = esFriolenta;
        this.nivelDeBondad = nivelDeBondad;
        this.nivelDeValor = nivelDeValor;
    }
    
    public void serAtormentadaPor(DemonioFuego unDemonio){
        nivelDeBondad -=5;
        esFriolenta = false;
    }
    
    public void serAtormentadaPor(DemonioHielo unDemonio){
        nivelDeBondad -=5;
        esFriolenta = true;
    }
    
    public void serAtormentadaPor(DemonioSombras unDemonio){
        nivelDeBondad -=5;
        nivelDeValor(nivelDeValor/2);
    }
    
    public void nivelDeValor(int _nivelDeValor){
        nivelDeValor = _nivelDeValor;
    }
    public void esFriolenta(boolean valor){
        esFriolenta = valor;
    }
    public boolean atormentadaHastaLaLocura(){
        return nivelDeBondad < 10;
    }
    public boolean esFriolenta(){
        return esFriolenta;
    }
    public int nivelDeBondad(){
        return nivelDeBondad;
    }
    public int nivelDeValor(){
        return nivelDeValor;
    }
    public String nombre(){
        return nombre;
    }
}
