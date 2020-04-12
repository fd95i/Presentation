public class Programador extends Empleado {
    private int lineasDeCodigoPorHora;
    private String lenguajeDominante;

    public Programador(){}
    public Programador(int lineasDeCodigoPorHora, String lenguajeDominante) {
        this.lineasDeCodigoPorHora = lineasDeCodigoPorHora;
        this.lenguajeDominante = lenguajeDominante;
    }
    public Programador(String nombre, String celula, int edad, boolean casado, double salario, int lineasDeCodigoPorHora, String lenguajeDominante) {
        super(nombre, celula, edad, casado, salario);
        this.lineasDeCodigoPorHora = lineasDeCodigoPorHora;
        this.lenguajeDominante = lenguajeDominante;
    }
}
