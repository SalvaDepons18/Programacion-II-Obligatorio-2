//Salvador Depons(303738) y Valentina Velazquez(305278)

package Dominio;
import java.io.Serializable;
import java.util.*;

// Clase creada para el objeto Postulante que extiende a Persona
public class Postulante extends Persona implements Serializable{
    
    // Atributos de Postulante (El resto los hereda de persona)
    private String telefono;
    private String mail;
    private String linkedin;
    private String formato;
    private HashMap<Tematica,String> experiencia;
    
    // Constructor vacio de Postulante
    public Postulante(){
        super("", "","");
        this.telefono = "";
        this.mail = "";
        this.linkedin = "";
        this.formato = "";
        this.experiencia = new HashMap<Tematica, String>();
    }
    
    // Constructor de Postulante
    public Postulante(String elNombre,String laCI,String laDireccion,String elTelefono,String elMail,String elLinkedin,String elFormato){
        super(elNombre, laCI, laDireccion);
        this.telefono = elTelefono;
        this.mail = elMail;
        this.linkedin = elLinkedin;
        this.formato = elFormato;
        this.experiencia = new HashMap<Tematica, String>();
    }
    
    // Metodos set y get de Postulante
    public void setTelefono(String elTelefono){
        this.telefono = elTelefono;
    }
    
    public String getTelefono(){
        return this.telefono;
    }
    
    public void setMail(String elMail){
        this.mail = elMail;
    }
    
    public String getMail(){
        return this.mail;
    }
    
    public void setLinkedin(String elLinkedin){
        this.linkedin = elLinkedin;
    }
    
    public String getLinkedin(){
        return this.linkedin;
    }
    
    public void setFormato(String elFormato){
        this.formato = elFormato;
    }
    
    public String getFormato(){
        return this.formato;
    }
    
    public void setExperiencia(HashMap<Tematica,String> laExperiencia){
        this.experiencia = laExperiencia;
    }
    
    public HashMap<Tematica,String> getExperiencia(){
        return this.experiencia;
    }
    
    // Metodo to String de Postulante
    @Override
    public String toString(){
        return this.getNombre()+" ("+this.getCI()+")";
    }
    
    // Metodo encargado de recibir una tematica y un nivel y agregarselo a la experiencia del postulante
    public void agregarExperiencia(Tematica laTematica, String elNivel){
        this.experiencia.put(laTematica, elNivel);
    }
    
    // Metodo encargado de recibir una tematica y eliminarla de la experiencia del postulante junto a su nivel asocioado
    public void eliminarExperienciaEnTematica(Tematica laTematica){
        this.experiencia.remove(laTematica);
    }
    
    // Metodo que recibe una tematica y devuelve el nivel del postulante en la misma
    public String darNivelExperienciaEnTematica(Tematica laTematica){
        return this.experiencia.get(laTematica);
    }
    
    // Metodo que devuelve un ArrayList con los nombres de las tematicas que el postulante tiene en su experiencia
    public ArrayList<String> darExperiencias(){
        ArrayList<String> listaAux = new ArrayList<>();
        Iterator<Tematica> it = this.experiencia.keySet().iterator();
        while (it.hasNext()) {
            Tematica tematica = it.next();
            listaAux.add(tematica.getNombre());
        }
        return listaAux;
    }
    
}
