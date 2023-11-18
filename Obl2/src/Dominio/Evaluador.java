//Salvador Depons(303738) y Valentina Velazquez(305278)

package Dominio;
import java.io.Serializable;

// Clase creada para el objeto Evaluador que extiende a Persona
public class Evaluador extends Persona implements Serializable{
    
    // Atributo de Evaluador (El resto los hereda de persona)
    private String anoIngreso;
    
    // Constructor vacio de Evaluador
    public Evaluador(){
        super("", "", "");
        this.anoIngreso = "";
    }
    
    // Constructor de Evaluador
    public Evaluador(String elNombre,String laCI,String laDireccion,String elAnoIngreso){
        super(elNombre, laCI, laDireccion);
        this.anoIngreso = elAnoIngreso;
    }
    
    // Metodos set y get de Evaluador
    public void setAnoIngreso(String elAnoIngreso){
        this.anoIngreso = elAnoIngreso;
    }
    
    public String getAnoIngreso(){
        return this.anoIngreso;
    }
    
    // Metodo toString de Evaluador
    @Override
    public String toString(){
        return this.getNombre();
    }
      
}
