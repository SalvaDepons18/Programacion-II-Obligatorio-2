//Salvador Depons(303738) y Valentina Velazquez(305278)
package Dominio;
import java.io.Serializable;
import java.util.*;

// Clase para el objeto Puesto
public class Puesto implements Serializable{
    
    // Atributos del objeto Puesto
    private String nombre;
    private String tipo;
    private ArrayList<Tematica> temas;
    
    // Constructor vacio de Puesto
    public Puesto(){
        this.nombre = "";
        this.tipo = "";
        this.temas = new ArrayList<>();
    }
    
    // Constructor de Puesto
    public Puesto(String elNombre,String elTipo, ArrayList<Tematica> losTemas){
        this.nombre = elNombre;
        this.tipo = elTipo;
        this.temas = losTemas;
    }
    
    // Metodos set y get del objeto Puesto
    public void setNombre(String elNombre){
        this.nombre = elNombre;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void setTipo(String elTipo){
        this.tipo = elTipo;
    }
    
    public String getTipo(){
        return this.tipo;
    }
    
    public void setTemas(ArrayList<Tematica> losTemas){
        this.temas = losTemas;
    }
    
    public ArrayList<Tematica> getTemas(){
        return this.temas;
    }
    
    // Metodo toString de Puesto
    @Override
    public String toString(){
        return this.getNombre();
    }
    
}
