package aula;
import java.util.*;
import java.util.stream.Collectors;

public class Aula {
    private int id;
    private float nroMaxEstudiantes;
    private String destino;
    private Profesor profesor;
    private List<Estudiante> estudiantes;

    public Aula(int id, float nroMaxEstudiantes, String destino, Profesor profesor) {
        this.id = id;
        this.nroMaxEstudiantes = nroMaxEstudiantes;
        this.destino = destino;
        this.profesor = profesor;
        this.estudiantes = new ArrayList<>();
    }

    
    //Getters y setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public float getNroMaxEstudiantes() {
        return nroMaxEstudiantes;
    }
    public void setNroMaxEstudiantes(float nroMaxEstudiantes) {
        this.nroMaxEstudiantes = nroMaxEstudiantes;
    }
    public String getDestino() {
        return destino;
    }
    public void setDestino(String destino) {
        this.destino = destino;
    }
    public Profesor getProfesor() {
        return profesor;
    }
    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
    public void getEstudiantes() {
         estudiantes.stream().forEach(estudiante -> System.out.println(estudiante.getNombre()));
    }
    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }
    
    //Comportamiento
    public List<Estudiante> estudiantesDisponibles(){
        return estudiantes.stream().filter(estudiante -> estudiante.estaDisponible()).collect(Collectors.toList());
    }
    public boolean puedeDarClase(){
        return profesor.estaDisponible() && profesor.getMateria().equals(destino) && ((this.estudiantesDisponibles().size()/nroMaxEstudiantes)*100)>50;
    }
    public void estudiantesAprobados(){
        int varones = (int) estudiantes.stream().filter(estudiante->estudiante.getSexo().equals("Masculino") && estudiante.calificacionActual()>5).count();
        int mujeres = (int) estudiantes.stream().filter(estudiante-> estudiante.getSexo().equals("Femenino") && estudiante.calificacionActual()>5).count();
        System.out.println("Cantidad de varones aprobados: " + varones + ". Cantidad de mujeres aprobadas: " + mujeres);
    }
    public void bibliografiaOficialDeLaMateria(){
        System.out.println("El libro oficial de esta materia es: " + profesor.bibliografiaOficial().nombre());
    }
}
