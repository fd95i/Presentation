public class ProductoCongelado extends Producto {
    private double temperaturaDeCongelamiento;

    //Constructor
    public ProductoCongelado(String fechaDeCaducidad, long numeroDeLote, double temperaturaDeCongelamiento) {
        super(fechaDeCaducidad, numeroDeLote);
        this.temperaturaDeCongelamiento = temperaturaDeCongelamiento;
    }

    //Getters y setters
    public double getTemperaturaDeCongelamiento() {
        return temperaturaDeCongelamiento;
    }
    public void setTemperaturaDeCongelamiento(double temperaturaDeCongelamiento) {
        this.temperaturaDeCongelamiento = temperaturaDeCongelamiento;
    }


    public String mostrarInformacionProducto() {
        return "ProductoCongelado[" +"temperaturaDeCongelamiento=" + temperaturaDeCongelamiento + ", fechaDeCaducidad='" + fechaDeCaducidad + '\'' +", numeroDeLote=" + numeroDeLote +  ']';
    }
}
