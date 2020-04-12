package tp5;

public class Lavarropas extends Electrodomesticos {
    int carga = 5;

    //Constructores
    public Lavarropas() {
    }
    public Lavarropas(float preciobase, float peso) {
        super(preciobase, peso);
    }
    public Lavarropas(int carga,float preciobase, String color, char consumo_energetico, float peso) {
        super(preciobase, color, consumo_energetico, peso);
        this.carga = carga;
    }
    
    //Getter de carga
    public int getCarga() {
        return carga;
    }
    
    //Comportamiento
    @Override
    public float precioFinal(){ 
        if(carga>=0 && carga <=19){
            return 5000 + super.precioFinal();
        }
        else if(carga>=20 && carga<=49){
            if(carga>30) return 10000 + 10000 + super.precioFinal();
            else return 10000 + super.precioFinal();
        }
        else if(carga>=50 && carga <=70){
            return 27000 + super.precioFinal();
        }
        else return 35000 + super.precioFinal();
    }//Para este caso como no comprendí bien el punto a cada tamaño +30 le sumé 10000
}
