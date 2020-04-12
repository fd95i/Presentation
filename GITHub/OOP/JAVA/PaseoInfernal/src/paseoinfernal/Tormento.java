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
public class Tormento extends Mision{
    
    List<List<Alma>> listaDeLugares;
    
    public Tormento(List<List<Alma>> listaDeLugares){
        this.listaDeLugares = listaDeLugares;
    }
    
    @Override
    public boolean condicionParaCumplir(Demonio unDemonio){
        return listaDeLugares.stream().allMatch((lugar) -> this.alMenosUnAlmaEsAtormentable(lugar));
    }
    public boolean alMenosUnAlmaEsAtormentable(List<Alma> unLugar){
        return unLugar.stream().anyMatch((alma) -> alma.atormentadaHastaLaLocura());
    }
}
