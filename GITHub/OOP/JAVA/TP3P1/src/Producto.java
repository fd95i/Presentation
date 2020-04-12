public class Producto {
    protected String fechaDeCaducidad;
    protected long numeroDeLote;

    //Constructor
    public Producto(String fechaDeCaducidad, long numeroDeLote) {
        this.fechaDeCaducidad = fechaDeCaducidad;
        this.numeroDeLote = numeroDeLote;
    }

    //Getters y setters
    public String getFechaDeCaducidad() {
        return fechaDeCaducidad;
    }
    public void setFechaDeCaducidad(String fechaDeCaducidad) {
        this.fechaDeCaducidad = fechaDeCaducidad;
    }
    public long getNumeroDeLote() {
        return numeroDeLote;
    }
    public void setNumeroDeLote(long numeroDeLote) {
        this.numeroDeLote = numeroDeLote;
    }


}
