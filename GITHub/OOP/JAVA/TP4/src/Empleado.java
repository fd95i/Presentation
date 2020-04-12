import javax.swing.*;

public class Empleado {
    protected String nombre;
    protected String celula;
    protected int edad;
    protected boolean casado;
    protected double salario;


    //Constructores
    public Empleado() {}
    public Empleado(String nombre, String celula, int edad, boolean casado, double salario) {
        this.nombre = nombre;
        this.celula = celula;
        this.edad = edad;
        this.casado = casado;
        this.salario = salario;
    }

    //Getters y setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCelula() {
        return celula;
    }
    public void setCelula(String celula) {
        this.celula = celula;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public boolean isCasado() {
        return casado;
    }
    public void setCasado(boolean casado) {
        this.casado = casado;
    }
    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }

    //Comportamiento
    public String clasificacionEdad(){
        if(edad>17 &&edad<=21) return "Principiante";
        if(edad>21&&edad<36) return "Intermedio";
        if(edad>35 && edad<=45) return "Senior";
        else return "La edad ingresada no es correcta";
    }
    public String mostrarDatos() {
        return "Empleado:\n" +
                "Nombre= " + nombre +
                "\nCelula= " + celula +
                "\nEdad= " + edad +
                "\nCasado= " + casado +
                "\nSalario= " + salario
                ;
    }
    public void aumentarSueldo(double porcentaje){
        salario += ( (salario*porcentaje)  /100 );
    }

    /*
    Cuestionario:

    1- Caracteristicas de JAVA:
    -> Lenguaje orientado a objetos
    -> Lenguaje fuertemente tipado
    -> Lenguaje interpretado
    -> Utiliza referencias a objetos o clases en lugar de referencias a posiciones
    de memoria
    -> No posee aritmética de punteros
    -> Es un lenguaje Multihilo
    -> Es portable

    2- Ventajas y desventajas:

    + Más seguro: Dado que no maneja aritmética de punteros y la reserva de memoria es
    realizada por la JVM, ayuda a evitar errores de manejo inapropiado o acceso a
    secciones prohibidas de la memoria.
    + Más expresivo/declarativo: Comparado con la programación secuencial o estructurada,
    la programación orientada a objetos y, por ende, JAVA, facilitan mucho la
    interpretación de código (expresividad) y esto permite concentrarnos en QUË hacer y no
    cómo (declaratividad).
    + Aprovecha conceptos: JAVA aprovecha conceptos fundamentales de la programación como
    el polimorfismo, el encapsulamiento, el acoplamiento, el orden superior, entre otros.
    Si bien estos conceptos son vistos, y en algunos casos, aprovechados mucho más en
    otras formas de programar, JAVA los aplica y son más visibles que en otros lenguajes
    dado el alto grado de declaratividad que posee.
    + Ejecución concurrente: Al ser multihilo, JAVA permite la ejecución concurrente
    a través de los denominados hilos, en el cual cada uno de los hilos de un proceso
    tiene sus propios registros de estado y bloques de control.
    + Portabilidad: La portabilidad de la JVM (que posee el ByteCodes) ayuda a que JAVA pueda ejecutarse en cualquier
    plataforma que la tenga instalada, por lo cual es un lenguaje completamente portable.

    - Bajo rendimiento: Dado que JAVA posee la interpretación de ByteCodes para habilitar la
    portabilidad, a contrapeso es mucho más lento que otros lenguajes incluso interpretados.

    3- JVM, y su ventaja

    La JVM (Java Virtual Machine, maquina virtual de JAVA en ingles) es el intérprete del código JAVA,
    el cual interpreta (valga la redundancia) y ejecuta las instrucciones expresadas en un código binario especial
    (el denominado ByteCodes) para que el compilador de JAVA las ejecute con el fin de que cualquier plataforma
    que posea una JVM pueda interpretar y ejecutar dicho código. La gran ventaja, como se dijo anteriormente,
    es la portabilidad.

    4- Pasos de compilación

    Los pasos para compilar código en JAVA son 4:

    El primero es escribir el código que necesitamos en un IDE
    El segundo guardar el código fuente en un archivo .java
    El tercero compilar
    El cuarto consiste en ejecutar el archivo .class generado por la compilación en caso de que no haya errores
    en la sintaxis o semántica

    El archivo .class contiene el ByteCodes de nuestro código, los cuales son interpretados por la JVM a la
    hora de ejecutar el programa

    5- JDK (Java Development Kit)

    El JDK (kit de desarrollo en java) es una herramienta con distribuciones, librerías, documentación y el ambiente
    de software en tiempo de ejecución (JRE). Este posee la JVM y las librerías en tiempo de ejecución requeridas
    para ejecutar la aplicación java

    */
}
