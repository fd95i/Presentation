/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paseoinfernal;
import java.util.*;
import java.util.stream.Collectors;
/**
 *
 * @author Fede
 */
public abstract class Demonio {
    
    protected int nivelDeMaldad;
    protected List<Alma> almasCazadas = new ArrayList();
    
    public Demonio(int nivelDeMaldad){
        this.nivelDeMaldad = nivelDeMaldad;
    }
   
    public boolean puedeCazar(Alma unAlma){
        return cumpleCondicionesParaCazar(unAlma);
    }

    public boolean cumpleCondicionesParaCazar(Alma unAlma){
        return nivelDeMaldad > unAlma.nivelDeBondad();
    }

    public List<Alma> almasCazables(List<Alma> unLugar){
        return unLugar.stream().filter(this::puedeCazar).collect(Collectors.toList());
    }

    public void salirDeCaza(List<Alma> unLugar){
        almasCazadas.addAll(this.almasCazables(unLugar));
        unLugar.removeAll(this.almasCazables(unLugar));
        unLugar.forEach((alma) -> this.atormentar(alma));
    }

    public boolean puedeSerCumplida(Mision unaMision){
        return unaMision.condicionParaCumplir(this);
    }

    public int cantidadAlmasCazadas(){
        return almasCazadas.size();
    }

    public void rendicionDeCuentas(){
        if(almasCazadas.isEmpty())
            nivelDeMaldad = nivelDeMaldad/10;
    }

    public abstract void atormentar(Alma unAlma);
}

