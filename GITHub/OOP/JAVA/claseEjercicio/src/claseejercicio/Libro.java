/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package claseejercicio;

/**
 *
 * @author melanie_sol
 */
public class Libro {
    int ISBN;
    String titulo;
    String autor;
    String materia;
    int paginas;
    
    
    public int getISBN(int isbn){
    return isbn;
    }
    public void setISBN(int isbn){
    ISBN= isbn;
    }
    
    public String getTitulo(String titulo){
    return titulo;
    }
    public void setTitulo(String unTitulo){
    titulo= unTitulo;
    }
    
    public String getAutor(String autor){
    return autor;
    }
    public void setAutor(String unAutor){
    autor= unAutor;
    }
    
    
    public String getMateria(String materia){
    return materia;
    }
    public void setMateria(String unaMateria){
    materia= unaMateria;
    }
    
    public int getPaginas(int paginas){
    return paginas;
    }
    public void setPaginas(int pagsNuevas){
    paginas= pagsNuevas;
    }
    
    @Override
    public String toString(){
    return "El libro "+ titulo + "con "+ ISBN + "creado por el autor "+ autor+ "tiene "+ paginas + " paginas";
    }
}
