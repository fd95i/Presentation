package tp5;

public class Electrodomesticos {
    private float preciobase = 10000;
    private String color = "blanco";
    private char consumo_energetico = 'f';
    private float peso = 5;

    //Constructores
    public Electrodomesticos() {
    }
    public Electrodomesticos(float preciobase, float peso) {
        this.preciobase = preciobase;
        this.peso = peso;
    }
    public Electrodomesticos(float preciobase, String color, char consumo_energetico, float peso) {
        this.preciobase = preciobase;
        comprobarColor(color);
        comprobarConsumoEnergetico(consumo_energetico);
        this.peso = peso;
    }

    //Getters
    public float getPreciobase() {
        return preciobase;
    }
    public String getColor() {
        return color;
    }
    public char getConsumo_energetico() {
        return consumo_energetico;
    }
    public float getPeso() {
        return peso;
    }
    
    //Comportamiento
    private void comprobarConsumoEnergetico(char letra){
        if(letra!='a'&&letra!='b'&&letra!='c'&&letra!='d'&&letra!='e'&&letra!='f') consumo_energetico = 'f';
        else consumo_energetico = letra;
    }
    private void comprobarColor(String color){
         if(!"blanco".equals(color)&&!"rojo".equals(color)&&!"negro".equals(color)&&!"gris".equals(color)&&!"azul".equals(color)) this.color = "blanco";
         else this.color = color;
    }
    public float precioFinal(){
        switch(consumo_energetico){
            case 'a':
                    return preciobase + 10000 + peso;
            case 'b':
                    return preciobase + 8000 + peso;
            case 'c':
                    return preciobase + 7000 + peso;
            case 'd':
                    return preciobase + 5000 + peso;
            default:
                    return preciobase + peso;
        }
    }
}
