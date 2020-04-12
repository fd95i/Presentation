public class ProductoFresco extends Producto {

    private String fechaDeEnvasado;
    private String paisDeOrigen;


    //Constructor
    public ProductoFresco(String fechaDeCaducidad, long numeroDeLote,String fechaDeEnvasado, String paisDeOrigen) {
        super(fechaDeCaducidad, numeroDeLote);
        this.fechaDeEnvasado = fechaDeEnvasado;
        this.paisDeOrigen = paisDeOrigen;
    }

    //Getters y setters
    public String getFechaDeEnvasado() {
        return fechaDeEnvasado;
    }
    public void setFechaDeEnvasado(String fechaDeEnvasado) {
        this.fechaDeEnvasado = fechaDeEnvasado;
    }
    public String getPaisDeOrigen() {
        return paisDeOrigen;
    }
    public void setPaisDeOrigen(String paisDeOrigen) {
        this.paisDeOrigen = paisDeOrigen;
    }

    public String mostrarInformacionProducto() {
        return "ProductoFresco[" + "fechaDeEnvasado='" + fechaDeEnvasado + '\'' +", paisDeOrigen='" + paisDeOrigen + '\'' +", fechaDeCaducidad='" + fechaDeCaducidad + '\'' +   ", numeroDeLote=" + numeroDeLote +  ']';
    }
}
