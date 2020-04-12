public class Main {
    public static void main(String args[]){
        Empleado churro = new Empleado("federico","hola",23,true,19163);
        System.out.println(churro.mostrarDatos());
        System.out.println(churro.clasificacionEdad());
        churro.aumentarSueldo(10);
        System.out.println(churro.mostrarDatos());
    }
}
