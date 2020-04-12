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
public class DemonioFuego extends Demonio {
    
    public DemonioFuego(int nivelDeMaldad){
        super(nivelDeMaldad);
    }
    @Override
    public void atormentar(Alma unAlma){
        unAlma.serAtormentadaPor(this);
    }
    @Override
    public boolean cumpleCondicionesParaCazar(Alma unAlma){
        return super.cumpleCondicionesParaCazar(unAlma)&& !unAlma.esFriolenta();
    }
    
}
