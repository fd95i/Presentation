/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paseoinfernal;

import java.util.*;

public class PaseoInfernal {


    public static void main(String[] args) {
        Alma puto = new Alma("Trolo",true,10,10);
        Alma forro = new Alma("Forro",false,10,10);
        List avellaneda = new ArrayList();
        List lanus = new ArrayList();
        List<List<Alma>> zonaSur = new ArrayList();
        DemonioFuego fuego = new DemonioFuego(100);
        DemonioHielo hielo = new DemonioHielo(100);
        DemonioSombras sombras = new DemonioSombras(100);
        
        //punto1
        System.out.println(fuego.puedeCazar(puto));
        
        //punto2
        fuego.atormentar(puto);
        hielo.atormentar(puto);
        sombras.atormentar(puto);
        System.out.println("Alma de puto: " + puto.nivelDeValor() + " " + puto.nivelDeBondad() + " " + puto.esFriolenta());
    
        //punto3
        avellaneda.add(forro);
        avellaneda.add(puto);
        lanus.add(puto);
        lanus.add(forro);
        System.out.println(fuego.almasCazables(avellaneda));
        
        //punto4
        hielo.salirDeCaza(avellaneda);
        
        //punto5
        zonaSur.add(lanus);
        zonaSur.add(avellaneda);
        Safari zona = new Safari(10,avellaneda);
        Tormento zona2 = new Tormento(zonaSur);
        System.out.println(zona.condicionParaCumplir(hielo));
        System.out.println(zona2.condicionParaCumplir(fuego));
    }
    
}
