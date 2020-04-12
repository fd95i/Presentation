package tp5;

public class Televisor extends Electrodomesticos{
    float pulgadas = 20;
    boolean sintonizadorTDT = false;

    //Constructor
    public Televisor() {
    }
    public Televisor(float preciobase, float peso) {
        super(preciobase, peso);
    }
    public Televisor(float pulgadas, boolean sintonizadorTDT, float preciobase, String color, char consumo_energetico, float peso) {
        super(preciobase, color, consumo_energetico, peso);
        this.pulgadas = pulgadas;
        this.sintonizadorTDT = sintonizadorTDT;
    }

    //Getters
    public float getPulgadas() {
        return pulgadas;
    }
    public boolean isSintonizadorTDT() {
        return sintonizadorTDT;
    }
    
    @Override
    public float precioFinal(){
        if(pulgadas > 40 && sintonizadorTDT) return super.precioFinal() + ((super.precioFinal() * 30)/100) + 7000;
        return super.precioFinal();
    }
}
