//Salvador Depons(303738) y Valentina Velazquez(305278)

package Dominio;
import java.io.Serializable;

// Clase creada para el objeto Persona
public class Persona implements Serializable{
    
    // Atributos de Persona
    private String nombre;
    private String ci;
    private String direccion;
    
    // Constructor vacio de Persona
    public Persona(){
        this.nombre = "";
        this.ci = "";
        this.direccion = "";
    }
    
    // Constructor de Persona
    public Persona(String elNombre,String laCI,String laDireccion){
        this.nombre = elNombre;
        this.ci = laCI;
        this.direccion = laDireccion;
    }
    
    // Metodos set y get de Persona
    public void setNombre(String elNombre){
        this.nombre = elNombre;
    }
    
    public String getNombre(){
        return this.nombre;
    } 
    
    public void setCI(String laCI){
        this.ci = laCI;
    }
    
    public String getCI(){
        return this.ci;
    }
    
    public void setDireccion(String laDireccion){
        this.direccion = laDireccion;
    }
    
    public String getDireccion(){
        return this.direccion;
    }
    
    // Metodo toString de Persona
    @Override
    public String toString(){
        return this.getNombre();
    }
    
}
