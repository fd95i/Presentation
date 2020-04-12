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
public class DemonioSombras extends Demonio{
    
    int limiteActual;
    
    public DemonioSombras(int nivelDeMaldad){
        super(nivelDeMaldad);
    }
    public void programaDeEntrenamiento(int _limiteNuevo){
        limiteActual = _limiteNuevo;
    }
    
    @Override
    public void atormentar(Alma unAlma){
        unAlma.serAtormentadaPor(this);
    }
    
    @Override
    public boolean cumpleCondicionesParaCazar(Alma unAlma){
        return super.cumpleCondicionesParaCazar(unAlma) && unAlma.nivelDeValor() < limiteActual;
    }

    
}
