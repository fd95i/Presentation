package onreadyej;
import java.util.*;
import java.util.stream.Collectors;


public class Concesionaria {
    
    public ArrayList<Vehiculo> vehiculosEnVenta;
    
    //Constructor
    public Concesionaria(ArrayList<Vehiculo> vehiculosEnVenta) {
        this.vehiculosEnVenta = new ArrayList(vehiculosEnVenta);
    }

    //Setters y getters
    public ArrayList<Vehiculo> getVehiculosEnVenta() {
        return vehiculosEnVenta;
    }
    public void setVehiculosEnVenta(ArrayList<Vehiculo> vehiculosEnVenta) {
        this.vehiculosEnVenta = new ArrayList(vehiculosEnVenta);
    }
   
    //Comportamiento
    public void vehiculoMasCaro(){
        Vehiculo elMasCaro = vehiculosEnVenta.stream().max( (Vehiculo vehiculo,Vehiculo oVehiculo) -> Float.compare(vehiculo.getPrecio(),oVehiculo.getPrecio())).get();
        System.out.println("Vehículo más caro: " + elMasCaro.getMarca() + " " + elMasCaro.getModelo());
    }
    public void vehiculoMasBarato(){
        Vehiculo elMasCaro = vehiculosEnVenta.stream().min( (Vehiculo vehiculo,Vehiculo oVehiculo) -> Float.compare(vehiculo.getPrecio(),oVehiculo.getPrecio())).get();
        System.out.println("Vehículo más barato: " + elMasCaro.getMarca() + " " + elMasCaro.getModelo());
    }
    public void contieneLetraY(){
        ArrayList<Vehiculo> contieneY = new ArrayList();
        contieneY.addAll(vehiculosEnVenta.stream().filter( (Vehiculo vehiculo) -> vehiculo.getModelo().contains("Y") ).collect(Collectors.toList()));        
        System.out.print("Vehículos que contienen en el modelo la letra 'Y': ");
        contieneY.stream().forEach((Vehiculo vehiculo) -> System.out.println(vehiculo.getMarca() + " " + vehiculo.getModelo() + " $" + vehiculo.getPrecio()));
    }
    public void mostrarVehiculos(){
        vehiculosEnVenta.forEach( (Vehiculo vehiculo) -> System.out.println(vehiculo.toString()) );
    }
    public void ordenarPorPrecio(){
        ArrayList<Vehiculo> listaOrd = new ArrayList();
        listaOrd.addAll(vehiculosEnVenta.stream().sorted((Vehiculo vehiculo, Vehiculo otroVeh) -> Float.compare(otroVeh.getPrecio(), vehiculo.getPrecio())).collect(Collectors.toList()));
        System.out.println("Vehículos ordenados por precio de mayor a menor:");
        listaOrd.stream().forEach((Vehiculo vehiculo) -> System.out.println(vehiculo.getMarca() + " " + vehiculo.getModelo()));
    }
}
