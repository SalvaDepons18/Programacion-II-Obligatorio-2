//Salvador Depons(303738) y Valentina Velazquez(305278)
package Dominio;

import java.io.Serializable;

// Clase creada para el objeto Entrevista
public class Entrevista implements Serializable{

    private Evaluador evaluador;
    private Postulante postulante;
    private String comentario;
    private String puntaje;
    private String numeroEntrevista;

    // Costructor vacio de Entrevista
    public Entrevista(){
        this.evaluador = new Evaluador();
        this.postulante = new Postulante();
        this.comentario = "";
        this.puntaje = "";
        this.numeroEntrevista = "";
    }

    // Costructor de Entrevista
    public Entrevista(Evaluador elEvaluador,Postulante elPostulante,String elComenteario, String elPuntaje, String elNumero){
        this.evaluador = elEvaluador;
        this.postulante = elPostulante;
        this.comentario = elComenteario;
        this.puntaje = elPuntaje;
        this.numeroEntrevista = elNumero;
    }
    
    // Metodos Set y Get de cada atributo de Entrevista
    public void setEvaluador(Evaluador elEvaluador){
        this.evaluador = elEvaluador;
    }

    public Evaluador getEvaluador(){
        return this.evaluador;
    }

    public void setPostulante(Postulante elPostulante){
        this.postulante = elPostulante;
    }

    public Postulante getPostulante(){
        return this.postulante;
    }

    public void setComentario(String elComenteario){
        this.comentario = elComenteario;
    }

    public String getComentario(){
        return this.comentario;
    }

    public void setPuntaje(String elPuntaje){
        this.puntaje = elPuntaje;
    }


    public String getPuntaje(){
        return this.puntaje;
    }

    public void setNumeroEntrevista(String elNumero){
        this.numeroEntrevista = elNumero;
    }

    public String getNumeroEntrevista (){
        return this.numeroEntrevista;
    }
    
    // Metodo toString para Entrevista
    @Override
    public String toString(){
        return "Entrevista número: "+this.getNumeroEntrevista();
    }
}

