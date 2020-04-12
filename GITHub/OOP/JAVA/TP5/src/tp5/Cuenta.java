package tp5;


public class Cuenta {
    private String titular;
    private double cantidad;

    //Constructores
    public Cuenta(String titular) {
        this.titular = titular;
    }
    public Cuenta(String titular, double cantidad) {
        this.titular = titular;
        this.cantidad = cantidad;
    }
    
    //Getters, Setters
    public String getTitular() {
        return titular;
    }
    public void setTitular(String titular) {
        this.titular = titular;
    }
    public double getCantidad() {
        return cantidad;
    }
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
    
    //toString
    @Override
    public String toString() {
        return "Cuenta[" + "Titular=" + titular + ", Cantidad=" + cantidad + ']';
    }
    
    //Comportamiento
    public void ingresar(double cantidad){
        if(cantidad > 0) this.cantidad += cantidad;
    }
    public void retirar(double cantidad){
        if( (this.cantidad - cantidad) < 0 ) setCantidad(0);
        else this.cantidad -= cantidad;
    }
}
