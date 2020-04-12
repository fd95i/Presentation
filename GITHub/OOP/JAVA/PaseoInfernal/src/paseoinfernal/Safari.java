/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paseoinfernal;
import java.util.*;
/**
 *
 * @author Fede
 */
public class Safari extends Mision{
    int porcentajeMinimo;
    List lugar = new ArrayList(); 
    
    public Safari(int porcentajeMinimo, List<Alma> lugar){
        this.porcentajeMinimo = porcentajeMinimo;
        this.lugar = lugar;
    }
    
    public void lugar(List<Alma> unLugar){
        lugar = unLugar;
    }
    
    @Override
    public boolean condicionParaCumplir(Demonio unDemonio){
        return ((unDemonio.cantidadAlmasCazadas()/lugar.size())*100) > porcentajeMinimo;
    }
}
