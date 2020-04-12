/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4;

import javax.swing.JOptionPane;

/**
 *
 * @author Fede
 */
public class Handler {
    private String nombre="";
    private String apellido="";
    private String seleccion="";
    
    public void getDataFromWindowAlumno(){
        nombre = Alumnos.nombre.getText();
        apellido = Alumnos.apellido.getText();
    }
    
    public void getDataFromWindowFlores(){
        seleccion = Flores.listaFlores.getSelectedValue();
    }

    public String getSeleccion() {
        return seleccion;
    }
    public void setSeleccion(String seleccion) {
        this.seleccion = seleccion;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    
    
    public void printDataFromWindow(){
        JOptionPane.showMessageDialog(null,"El nombre es: " + nombre + "\nEl apellido es: " + apellido);
    }
}
