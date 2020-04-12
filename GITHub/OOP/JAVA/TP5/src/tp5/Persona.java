package tp5;

public class Persona {
    private String nombre = "";
    private int edad = 0;
    private int DNI;
    private char sexo = 'H';

    //Constructores
    public Persona() {
    }
    public Persona(String nombre, int edad, char sexo){
        this.nombre=nombre;
        this.edad = edad;
        this.sexo = sexo;
    }
    public Persona(String nombre, int edad, int DNI, char sexo){
        this.nombre=nombre;
        this.edad = edad;
        this.DNI = DNI;
        this.sexo = sexo;
    }

    //Setters, Getters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public int getDNI() {
        return DNI;
    }
    public char getSexo() {
        return sexo;
    }
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    
    //Comportamiento
    public boolean esMayorDeEdad(){
        return edad >=18;
    }
    private void comprobarSexo(char sexo){
        if(sexo != 'h' && sexo != 'm') this.sexo = 'h';
        else this.sexo = sexo;
    }
    public void generaDNI(){
        int DNIRNG = (int) (Math.random() * ((43000000 - 0) + 1)) + 0;
        this.DNI = DNIRNG;
    }

    //toString
    @Override
    public String toString() {
        return "Persona[" + "Nombre=" + nombre + ", Edad=" + edad + ", DNI=" + DNI + ", Sexo=" + sexo + ']';
    }
    
    
}
