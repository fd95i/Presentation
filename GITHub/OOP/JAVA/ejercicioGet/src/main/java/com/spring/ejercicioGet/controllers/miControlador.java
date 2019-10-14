package com.spring.ejercicioGet.controllers;

import com.spring.ejercicioGet.model.Chofer;
import com.spring.ejercicioGet.model.Jubilado;
import com.spring.ejercicioGet.model.Prestamo;
import com.spring.ejercicioGet.model.ListaSalteada;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class miControlador {

    @GetMapping("/jubilacion")
    public String puedeJubilarse(@RequestParam("edad") int edad,
                                 @RequestParam("sexo") String sexo){
        if(edad>65) return "Puede jubilarse";
        else if(edad == 65 && sexo.equals("masculino")) return "Puede jubilarse";
        else return "Te faltan " + (65-edad) + " año/s para jubilarte";
    }

    @GetMapping("/lista")
    public List<Integer> lista(@RequestParam("desde") int desde,
                               @RequestParam("hasta") int hasta,
                               @RequestParam("salto") int salto){
        List<Integer> lista = new ArrayList<>();
        for(int i = desde;i<=hasta;i+=salto){
            lista.add(i);
        }
        return lista;
    }

    @GetMapping("/prestamo")
    public boolean prestamo(@RequestParam("nombre")int nombre,
                            @RequestParam("apellido")int apellido,
                            @RequestParam("deudas") int deudas,
                            @RequestParam("puntuacion_del_banco")int puntuacion_del_banco,
                            @RequestParam("ahorros") int ahorros){
        if(puntuacion_del_banco==0) return false;
        if(ahorros>deudas) return true;
        if(deudas>ahorros && puntuacion_del_banco>200) return true;
        else return false;
    }

    //Posts

    @PostMapping("/chofer")
    public String nombreChofer(@RequestBody Chofer chofer){
        return "Soy el chofer " + chofer.getNombre() + " " + chofer.getApellido() + " y el color de mi ropa es " + chofer.getColorRopa();
    }

    @PostMapping("/jubilacion")
    public String puedeJubilarse(@RequestBody Jubilado jubilado){
        if(jubilado.getEdad()>65) return "Puede jubilarse";
        else if(jubilado.getEdad() == 65 && jubilado.getSexo().equals("masculino")) return "Puede jubilarse";
        else return "Te faltan " + (65-jubilado.getEdad()) + " año/s para jubilarte";
    }

    @PostMapping("/lista")
    public List<Integer> lista(@RequestBody ListaSalteada listaSalteada){
        List<Integer> lista = new ArrayList<>();
        for(int i = listaSalteada.getDesde();i<=listaSalteada.getHasta();i+=listaSalteada.getSalto()){
            lista.add(i);
        }
        return lista;
    }

    @PostMapping("/prestamo")
    public boolean prestamo(@RequestBody Prestamo prestamo){
        if(prestamo.getPuntuacion_del_banco()==0) return false;
        if(prestamo.getAhorros()>prestamo.getDeudas()) return true;
        if(prestamo.getDeudas()>prestamo.getAhorros() && prestamo.getPuntuacion_del_banco()>200) return true;
        else return false;
    }
}
