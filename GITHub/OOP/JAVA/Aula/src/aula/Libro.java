/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula;

public class Libro {
    private int isbn;
    private String nombre;
    private String autor;
    private String materia;
    private int numeroDePaginas;

    //Constructor
    public Libro(int isbn,String nombre, String autor, String materia, int numeroDePaginas){
        this.isbn = isbn;
        this.nombre = nombre;
        this.autor = autor;
        this.materia = materia;
        this.numeroDePaginas = numeroDePaginas;
    }

    //Getters y setters
    public int isbn(){
        return isbn;
    }
    public String nombre(){
        return nombre;
    }
    public String autor(){
        return autor;
    }
    public String materia(){
        return materia;
    }
    public int numeroDePaginas(){
        return numeroDePaginas;
    }
    public void isbn(int numero){
        isbn = numero;
    }
    public void nombre(String _nombre){
        nombre = _nombre;
    }
    public void autor(String _autor){
        autor = _autor;
    }
    public void materia(String _materia){
        materia = _materia;
    }
    public void numeroDePagina(int _numeroDePaginas){
        numeroDePaginas = _numeroDePaginas;
    }

    @Override
    public String toString(){
        return "El libro con ISBN " + isbn + " creado por el autor " + autor + " tiene " + numeroDePaginas + "páginas.";
    }
    
    

}
