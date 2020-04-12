public class ProductoRefrigerado extends Producto{
    private int codigoDeOrganismo;

    //Constructor
    public ProductoRefrigerado(String fechaDeCaducidad, long numeroDeLote, int codigoDeOrganismo) {
        super(fechaDeCaducidad, numeroDeLote);
        this.codigoDeOrganismo = codigoDeOrganismo;
    }

    //Getters y setters
    public int getCodigoDeOrganismo() {
        return codigoDeOrganismo;
    }
    public void setCodigoDeOrganismo(int codigoDeOrganismo) {
        this.codigoDeOrganismo = codigoDeOrganismo;
    }


    public String mostrarInformacionProducto() {
        return "ProductoRefrigerado[" + "codigoDeOrganismo=" + codigoDeOrganismo + ", fechaDeCaducidad='" + fechaDeCaducidad + '\'' +", numeroDeLote=" + numeroDeLote +  ']';
    }
}

