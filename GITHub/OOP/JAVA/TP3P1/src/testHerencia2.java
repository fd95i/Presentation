

public class testHerencia2 {
    public static void main(String args[]){

        //Creación de objetos
        ProductoCongelado espinaca = new ProductoCongelado("20/3/2023",23123165,-70);
        ProductoFresco leche = new ProductoFresco("20/10/2018",325561,"20/8/2018","Argentina");
        ProductoRefrigerado salchichas = new ProductoRefrigerado("20/9/2018",32156651,959);

        //Testeo
        System.out.println(espinaca.mostrarInformacionProducto());
        System.out.println(leche.mostrarInformacionProducto());
        System.out.println(salchichas.mostrarInformacionProducto());

    }
}

/*
    Preguntas:

    2- La sintaxis correcta es la número 2:
            private String nombre;
            private String apellido;
            private int edad;
            private String sexo;
    3- El metodo Humanos() es el constructor de la clase Humanos, no retorna ningun valor
    y solo asigna valores a alguna de los atributos que la componen. Por otro lado el método
    comoTeLlamas() es un getter de un atributo, retorna un valor de tipo String, en este
    caso, el nombre.

 */
