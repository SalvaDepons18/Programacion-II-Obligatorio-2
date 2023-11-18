//Salvador Depons(303738) y Valentina Velazquez(305278)
package Dominio;

import java.io.Serializable;

// Clase del objeto Tematica
public class Tematica implements Serializable{
    
    // Atributos del objeto Tematica
    private String nombre;
    private String descripcion;
    
    // Constructor vacio de Tematica
    public Tematica(){
        this.nombre = "";
        this.descripcion = "";
    }
    
    // Constructor de Tematica
    public Tematica(String elNombre, String laDescripcion){
        this.nombre = elNombre;
        this.descripcion = laDescripcion;
    }
    
    // Metodos set y get del objeto Tematica
    public void setNombre(String elNombre){
        this.nombre = elNombre;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void setDescripcion(String laDescripcion){
        this.descripcion = laDescripcion;
    }
    
    public String getDescripcion(){
        return this.descripcion;
    }
    
    // Metodo toString de Tematica
    @Override
    public String toString(){
        return this.getNombre();
    }
    
}
