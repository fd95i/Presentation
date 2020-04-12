import java.util.*;

public class Cumpleañito {
    private String nombreCumpleañero;
    private String direccion;
    private ArrayList<String> invitados;

    public Cumpleañito(String nombreCumpleañero, String salonDeFiestas) {
        this.nombreCumpleañero = nombreCumpleañero;
        this.direccion = salonDeFiestas;
        this.invitados = new ArrayList<String>();
    }

    //Getters y setters
    public String nombreCumpleañero() {
        return nombreCumpleañero;
    }
    public void nombreCumpleañero(String nombreCumpleañero) {
        this.nombreCumpleañero = nombreCumpleañero;
    }
    public String direccion() {
        return direccion;
    }
    public void direccion(String direccion) {
        this.direccion = direccion;
    }

    //Comportamiento
    public boolean estaInvitado(String persona){
        return invitados.contains(persona);
    }
}
