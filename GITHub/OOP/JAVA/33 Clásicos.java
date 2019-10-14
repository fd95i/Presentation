import javax.swing.*;
import java.util.*;

public class EjerciciosPractica {
    public static void main(String args[]){
        //3 bienvenida("Federico");
        //4 bienvenidaCustom();
        //5 areaDeCirculo();
        //6 esMultiploDeDos();
        //7 reverseASCII();
        //8 aSCII();
        //9 precioConIVA();
        //10 unoA100();
        //11 facil
        //12 divisiblesEntre2y3();
        //13 ventas();
        //14 ecuacionSegundoGrado();
        //15 numeroMayorQue0();
        //16 comprobarContraseña("churro");
        //17 diaLaboral();
        //18 numeroRandomEntre(1,10);
        //19 cantidadDeCifras();
        //20 numeroPrimo();
        //21 funcionFI(5);
        //22 vocalesEn("La lluvia en Sevilla es una maravilla");
        //23 lenguajeInclusivo("La lluvia en Sevilla es una maravilla");
        //24 stringToCharToASCII("La lluvia en Sevilla es una maravilla");
        //25 calculadoraPolacaInversa(2,3,"^");
        //26 sumaHasta(100);
        //27 estoyAburrido();
        //28 eliminarEspacios("hola brugha");
        //29 frasesInfinitas();
        //30 mayusOminus();
        //31 longitud("mogolico");
        //32 palabrasIguales();
        //33 sacarLetras("trolohijodeputa");

    }

    public static void bienvenida(String nombre){
        JOptionPane.showMessageDialog(null,("Bienvenido " + nombre));
    }
    public static void bienvenidaCustom(){
        String nombre = JOptionPane.showInputDialog(null,"Ingrese su nombre");
        JOptionPane.showMessageDialog(null,"Bienvenido " + nombre);
    }
    public static void areaDeCirculo(){
        String radio = JOptionPane.showInputDialog(null,"Ingrese el radio");
        JOptionPane.showMessageDialog(null,("El area es "+ Math.pow(Math.PI*Double.parseDouble(radio),2)));
    }
    public static void esMultiploDeDos(){
        String numero = JOptionPane.showInputDialog(null,"Ingrese número");
        JOptionPane.showMessageDialog(null,Integer.parseInt(numero)%2==0);
    }
    public static void reverseASCII(){
        String numero = JOptionPane.showInputDialog("Ingrese número");
        JOptionPane.showMessageDialog(null,"El equivalente del número en ASCII es: " + (char) Integer.parseInt(numero));
    }
    public static void aSCII(){
        String caracter = JOptionPane.showInputDialog("Ingrese un caracter");
        char  caracter1 = caracter.charAt(0);
        JOptionPane.showMessageDialog(null,"El codigo ascii es: " + (int)caracter1);
    }
    public static void precioConIVA(){
        String numero = JOptionPane.showInputDialog("Ingrese un numero");
        JOptionPane.showMessageDialog(null,"El importe con IVA es " + Double.parseDouble(numero)*1.21);;
    }
    public static void unoA100(){
        int numero = 1;
        while(numero!=101){
            System.out.println(numero);
            numero++;
        }
    }
    public static void divisiblesEntre2y3(){
        for(int i=1;i<101;i++){
            if(i%6==0 || i==1) System.out.println(i);
        }

    }
    public static void ventas(){
        int acum = 0;
        String ventas = JOptionPane.showInputDialog("Introduce un número de ventas...");
        for(int i=0;i<Integer.parseInt(ventas);i++){
            String ventaActual = JOptionPane.showInputDialog("Ingrese monto de venta nro " + i);
            acum += Integer.parseInt(ventaActual);
        }
        JOptionPane.showMessageDialog(null,"La suma de las ventas es " + acum);
    }
    public static void ecuacionSegundoGrado(){
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int discriminante = (b*b) - (4*a*c);
        if(discriminante < 0) System.out.println("Discriminante negativo");
        else{
            double raiz1 = (b + Math.sqrt(discriminante)) / 2*a;
            double raiz2 = (b - Math.sqrt(discriminante)) / 2*a;
            JOptionPane.showMessageDialog(null,"Las raices son: R1=" + raiz1 + ", R2=" + raiz2);
        }
    }
    public static void numeroMayorQue0(){
        Scanner in = new Scanner(System.in);
        int numero;
        do{
           numero = in.nextInt();
        }while(numero<0);
        JOptionPane.showMessageDialog(null,"El numero ingresado es " + numero);
    }
    public static void comprobarContraseña(String ingreso){
        String contraseñaIngresada = "";
        int intentos = 3;
        boolean verificado = false;
        for(int i=0; i<intentos && !verificado;i++){
            contraseñaIngresada = JOptionPane.showInputDialog("Ingrese contraseña");
            if(ingreso.equals(contraseñaIngresada)) verificado = true;
        }
        JOptionPane.showMessageDialog(null,"Enhorabuena");
    }
    public static void diaLaboral(){
        String dia = JOptionPane.showInputDialog("Ingrese un día");
        switch(dia){
            case "lunes": JOptionPane.showMessageDialog(null,"Es día laboral");break;
            case "martes": JOptionPane.showMessageDialog(null,"Es día laboral");break;
            case "miercoles": JOptionPane.showMessageDialog(null,"Es día laboral");break;
            case "jueves": JOptionPane.showMessageDialog(null,"Es día laboral");break;
            case "viernes": JOptionPane.showMessageDialog(null,"Es día laboral");break;
            case "sabado": JOptionPane.showMessageDialog(null,"No es día laboral");break;
            case "domingo": JOptionPane.showMessageDialog(null,"No es día laboral");break;
            default: JOptionPane.showMessageDialog(null,"No es un día semanal");break;
        }
    }
    public static void numeroRandomEntre(int min,int max){
        for(int i=0; i<10;i++){
            int random = (int) (Math.random() * (max-min)) + min;
            System.out.println(random);
        }
    }
    public static void cantidadDeCifras(){
        String no = JOptionPane.showInputDialog("Ingrese un numero");
        int numero = Integer.parseInt(no);
        if(numero < 0) JOptionPane.showMessageDialog(null,"El numero debe ser positivo");
        int j = 1;
        int i;
        for(i=0;j<=numero;i++){
            numero /= 10;
        }
        System.out.println(i);
    }
    public static void numeroPrimo(){
        String no = JOptionPane.showInputDialog("Ingrese un número");
        int numero = Integer.parseInt(no);
        int divisores = 0;

        if(numero<2){
            JOptionPane.showMessageDialog(null, "El numero debe ser mayor a 1");
            System.exit(0);
        }
        for(int i=1;i<numero;i++){
            if(numero%i == 0) divisores++;
        }
        if(divisores >1) JOptionPane.showMessageDialog(null,"El número no es primo");
        else JOptionPane.showMessageDialog(null,"El número es primo");
    }
    public static void funcionFI(int numero){
        int divisores = 0;

        for(int i=1;i<=numero;i++){
            for(int j=1;j<i;j++){
                if(i%j == 0) divisores++;
            }
            if(divisores==1 || i==1) System.out.println(i);
            divisores = 0;
        }

    }
    public static void vocalesEn(String cadena){
        int vocales = 0;
        for(int i=0;i<cadena.length();i++){
            if(cadena.charAt(i) == 'a' || cadena.charAt(i) == 'e' || cadena.charAt(i) == 'i' || cadena.charAt(i) == 'o' || cadena.charAt(i) == 'u') vocales++;
        }
        JOptionPane.showMessageDialog(null,"Cantidad de vocales: " + vocales);
    }
    public static void lenguajeInclusivo(String cadena){
            System.out.println(cadena.replace('a','e'));
    }
    public static void stringToCharToASCII(String cadena){
        String nuevaCadena = "";
        for(int i=0;i<cadena.length();i++){
            int ascii = (int) cadena.charAt(i);
            nuevaCadena = nuevaCadena + " " + String.format("%s",ascii);
        }
        System.out.println(nuevaCadena);
    }
    public static void calculadoraPolacaInversa(int op1,int op2,String operador){
        switch (operador){
            case "+": JOptionPane.showMessageDialog(null,"El resultado es: " + (op1+op2));break;
            case "-": JOptionPane.showMessageDialog(null,"El resultado es: " + (op1-op2));break;
            case "*": JOptionPane.showMessageDialog(null,"El resultado es: " + (op1*op2));break;
            case "/": JOptionPane.showMessageDialog(null,"El resultado es: " + (op1/op2));break;
            case "%": JOptionPane.showMessageDialog(null, "El resultado es: " + (op1%op2));break;
            case "^": JOptionPane.showMessageDialog(null,"El resultado es: " + (Math.pow(op1,op2)));break;
            default: JOptionPane.showMessageDialog(null,"No es un operador valido");break;

        }
    }
    public static void sumaHasta(int numero){
        if(numero<1){
            JOptionPane.showMessageDialog(null,"El numero debe ser mayor a 1");
            System.exit(0);
        }

        int acum = 0;
        for(int i=0; i<=numero;i++){
            acum+=i;
        }
        JOptionPane.showMessageDialog(null,"La suma es: " + acum);
    }
    public static void estoyAburrido(){
        int numero = 0,contador = 0;
        while(numero!=-1){
            String respuesta = JOptionPane.showInputDialog("Inserte un numero, -1 para salir");
            numero = Integer.parseInt(respuesta);
            contador++;
        }
        JOptionPane.showMessageDialog(null,"Cantidad de numeros introducidos: " + contador);
    }
    public static void eliminarEspacios(String frase){
        System.out.println(frase.replace(" ",""));
    }
    public static void frasesInfinitas(){
        String cadenaActual = JOptionPane.showInputDialog("Ingrese cadenas, cuando no quiera ingresar mas no escriba nada");
        String cadenaInicial = "";
        while(!cadenaActual.equals("")){
            cadenaInicial += cadenaActual + " ";
            cadenaActual = JOptionPane.showInputDialog("Ingrese cadenas, cuando no quiera ingresar mas no escriba nada");
        }
        System.out.println(cadenaInicial);
    }
    public static void mayusOminus(){
        String cadena = JOptionPane.showInputDialog("Ingrese una cadena");
        String estilo = JOptionPane.showInputDialog("Mayuscula o minuscula?");
        if(estilo.equals("mayuscula")) JOptionPane.showMessageDialog(null,cadena.toUpperCase());
        else JOptionPane.showMessageDialog(null,cadena.toLowerCase());
    }
    public static void longitud(String cadena){
        JOptionPane.showMessageDialog(null,cadena.length());
    }
    public static void palabrasIguales(){
        String palabra1 = JOptionPane.showInputDialog("Ingrese una palabra");
        String palabra2 = JOptionPane.showInputDialog("Ingrese otra palabra");
        JOptionPane.showMessageDialog(null,palabra1.equals(palabra2));
    }
    public static void sacarLetras(String frase){
        System.out.println(frase.substring(0,3) + frase.substring(5));
    }
}










































































