//Salvador Depons(303738) y Valentina Velazquez(305278)
package Dominio;
import java.util.*;
import java.io.Serializable;
import java.util.Observable;

// Clase creada para el Sistema
public class Sistema extends Observable implements Serializable {
   
    // Atributos del Sistema
    private int cantEntrevistas;
    private ArrayList<Evaluador> listaEvaluadores;
    private ArrayList<Postulante> listaPostulantes;
    private ArrayList<Entrevista> listaEntrevistas;
    private ArrayList<Puesto> listaPuestos;
    private ArrayList<Tematica> listaTematicas;
    private ArrayList<Persona> listaPersonas;
    
    // Constructor de Sistema
    public Sistema(){
        this.listaEvaluadores = new ArrayList<>();
        this.listaPostulantes = new ArrayList<>();
        this.listaEntrevistas = new ArrayList<>();
        this.listaPuestos = new ArrayList<>();
        this.listaTematicas = new ArrayList<>();
        this.listaPersonas = new ArrayList<>();
        this.cantEntrevistas = 0;
    }

    // Metodos set y get de la clase Sistema
    public void setListaEntrevistas(ArrayList<Entrevista> lalistaEntrevistas){
        this.listaEntrevistas = lalistaEntrevistas;
    }
    
    public ArrayList<Entrevista> getListaEntrevistas(){
        return this.listaEntrevistas;
    }
    
    public void setListaPuestos(ArrayList<Puesto> lalistaPuestos){
        this.listaPuestos = lalistaPuestos;
    }
    
    public ArrayList<Puesto> getListaPuestos(){
        return this.listaPuestos;
    } 
    
    public void setListaTematicas(ArrayList<Tematica> lalistaTematicas){
        this.listaTematicas = lalistaTematicas;
    }
    
    public ArrayList<Tematica> getListaTematicas(){
        return this.listaTematicas;
    } 
    
    public void setListaPersonas(ArrayList<Persona> lalistaPersonas){
        this.listaPersonas = lalistaPersonas;
    }
    
    public ArrayList<Persona> getListaPersonas(){
        return this.listaPersonas;
    }
    
    public void setListaEvaluadores(ArrayList<Evaluador> laListaEvaluadores){
        this.listaEvaluadores = laListaEvaluadores;
    }
    
    public ArrayList<Evaluador> getListaEvaluadores(){
        return this.listaEvaluadores;
    }
    
    public void setListaPostulantes(ArrayList<Postulante> laListaPostulantes){
        this.listaPostulantes = laListaPostulantes;
    }
    
    public ArrayList<Postulante> getListaPostulantes(){
        return this.listaPostulantes;
    }
    
    public void setCantEntrevistas(int laCantidad){
        this.cantEntrevistas = laCantidad;
    }
    
    public int getCantEntrevistas(){
        return this.cantEntrevistas;
    }
    
    public void aumentarCantDeEntrevistas(){
        this.cantEntrevistas++;
    }
    
    // Metodos para agregar los objetos a las listas
    public void agregarEntrevista(Entrevista e){
        this.listaEntrevistas.add(e); 
        setChanged();
        notifyObservers();
    }
    
    public void agregarEvaluador(Evaluador e){
        this.listaEvaluadores.add(e); 
        setChanged();
        notifyObservers();
    }
    
    public void agregarPersona(Persona p){
        this.listaPersonas.add(p);   
    }
    
    public void agregarPostulante(Postulante p){
        this.listaPostulantes.add(p);
        setChanged();
        notifyObservers();
    }
    
    public void agregarPuesto(Puesto p){
        this.listaPuestos.add(p); 
        setChanged();
        notifyObservers();
    }
    
    public void agregarTematica(Tematica t){
        this.listaTematicas.add(t);   
        setChanged();
        notifyObservers();
    }
    
    // Metodos para quitar los objetos de las listas
    public void quitarEntrevista(Entrevista e){
        this.listaEntrevistas.remove(e);
        setChanged();
        notifyObservers();
    }
    
    public void quitarEvaluador(Evaluador e){
        this.listaEvaluadores.remove(e);   
    }
    
    public void quitarPersona(Persona p){
        this.listaPersonas.remove(p);   
    }
    
    public void quitarPostulante(Postulante p){
        this.listaPostulantes.remove(p);
        setChanged();
        notifyObservers();
    }
    
    public void quitarPuesto(Puesto p){
        this.listaPuestos.remove(p);   
    }
    
    public void quitarTematica(Tematica t){
        this.listaTematicas.remove(t);   
    }
    
    // Metodo que recibe una tematica y devuelve si ya esta o no en la lista de tematicas
    public boolean verificarTematicaRepetida(Tematica laTematica){
        ArrayList<Tematica> lista = this.getListaTematicas();
        boolean esta = false; 
        for (Tematica tem: lista){
            if(tem.getNombre().toLowerCase().equals(laTematica.getNombre().toLowerCase())){
                esta = true;
            }
        }
        return esta;
    }

    // Metodo que recibe el nombre de una tematica y devuelve el objeto Tematica con ese nombre
    public Tematica temaPorNombre(String nom){
        ArrayList<Tematica> list = this.getListaTematicas();
        Tematica ret = new Tematica();
        for (Tematica elem: list){
            if (elem.getNombre().equalsIgnoreCase(nom)){
                ret = elem;
            }
        }
        return ret;
    } 
    
    // Metodo que valida que una cedula sea unica
    public boolean validarCedulaUnica(String unaCedula) {
    ArrayList<Persona> lista = this.getListaPersonas();
    boolean esta = false;
    for(int i=0; i<lista.size(); i++){
        if(lista.get(i).getCI().equals(unaCedula)){
            esta = true; 
        }
    }
    return esta;
    }
    
    /* Metodo que recibe un puesto y un nivel. Devolviendo una lista con los postulantes
       que tienen todas las tematicas del puesto y cumplen con  con el nivel dado o mayor. 
       A su vez tienen el mismo formato que el puesto y al menos una entrevista realizada.*/
    
    public ArrayList<Postulante> verPostulantesCumplidores(Puesto puesto,String nivel){
        ArrayList<Tematica> tematicas = puesto.getTemas();
        String tipo = puesto.getTipo();
        ArrayList<Postulante> postulantesElegidos = new ArrayList<>();
        boolean valido = true;
        ArrayList<Postulante> postulantes = this.postulConEntrevista(); 
        
        // recorro la lista de postulantes con entrevista validando cada uno de ellos 
        for (int i=0; i<postulantes.size(); i++){
            valido = true;
            Postulante p = postulantes.get(i);
            
            // valido formato
            if(!p.getFormato().equals(tipo)){
                valido = false;
            }
            
            // valido sus tematicas y el nivel
            ArrayList<String> lista = p.darExperiencias();
            for(int j=0 ; j<tematicas.size(); j++){
                if(!(lista.contains(tematicas.get(j).getNombre()))){
                    valido = false;
                } else if((Integer.parseInt(p.darNivelExperienciaEnTematica(tematicas.get(j)))) < Integer.parseInt(nivel) ){
                    valido = false;
                }
            }
            
            // si es valido lo agrego al retorno
            if(valido){
                postulantesElegidos.add(p);
            }
        }
        return postulantesElegidos;
    }
    
    // Metodo que devuelve una lista con los postulantes que tienen al menos una entrevista
    public ArrayList<Postulante> postulConEntrevista(){
        ArrayList<Postulante> ret = new ArrayList<>();
        for (Entrevista e: this.listaEntrevistas){
            Postulante p = e.getPostulante();
            if (!containsPostulante(ret, p)) {
                ret.add(p);
            }
        }
        return ret;
    }

    // Metodo auxiliar que verifica si un postulante esta en una lista de postulantes por ci
    public boolean containsPostulante(ArrayList<Postulante> list, Postulante postulante) {
        for (Postulante p : list) {
            if (p.getCI().equalsIgnoreCase(postulante.getCI())) {
                return true; 
            }
        }
        return false; 
    }
    
    // Metodo que devuleve los postulantes que tienen nivel 5 o mayor un una cierta tematica dada
    public String postulantes5Mayor(Tematica tem){
        int cont = 0;
        for (Postulante p: this.listaPostulantes){
            if(p.darExperiencias().contains(tem.getNombre()) && Integer.parseInt(p.darNivelExperienciaEnTematica(tem)) > 4){
                cont++;
            }
        }
        return cont+"";
    }
    
    // Metodo que devuelve la cantidad de puestos que contienen una tematica dada entre sus temas
    public String cantPuestosInteresadosEnTem(Tematica tem){
        int cont = 0;
        for (Puesto p: this.listaPuestos){
            if(p.getTemas().contains(tem)){
                cont++;
            }
        }
        return cont+"";
    }
    
    // Metodo que retorna una lista de entrevistas de un postulante dado
    public ArrayList<Entrevista> entrevistasDePostulante(Postulante p){
        ArrayList<Entrevista> entrevistas = new ArrayList<>();
        for (Entrevista e: listaEntrevistas){
            if(e.getPostulante().equals(p)){
                entrevistas.add(e);
            }
        }
        return entrevistas;
    }
    
    // Metodo que ordena decreciente una lista de postulantes segun su nivel en la ultima entrevista
    public ArrayList<Postulante> ordernarPorNivel(ArrayList<Postulante> laLista){
        Collections.sort(laLista, new Comparator<Postulante>(){
            public int compare(Postulante p1, Postulante p2){
                return puntajeDePostulante(p2) - (puntajeDePostulante(p1));
            }
        });
        return laLista;
    }
    
    // Metodo que devuelve el puntaje de un postulante es su ultima entrevista
    public int puntajeDePostulante(Postulante p){
        ArrayList<Entrevista> listE=this.getListaEntrevistas();
        boolean encontro = false;
        String puntaje="";
        for(int i=listE.size()-1; i>=0 && !encontro; i--){
            if(listE.get(i).getPostulante().equals(p)){
                encontro = true;
                puntaje = listE.get(i).getPuntaje();
            }
        }
        
        return Integer.parseInt(puntaje);
    }
    
    // Metodo que recibe un puesto y una lista de postulantes y la guarda en un archivo txt
    public void guardarPostulantesEnArchivo(Puesto p, ArrayList<Postulante> lista){
        //Paths.get("Consulta.txt");
        ArchivoGrabacion consul = new ArchivoGrabacion("Consulta.txt", false);
        consul.grabarLinea("Puesto: "+p.getNombre());
        for (Postulante pos: lista){
            String linea = pos.getNombre()+", "+pos.getCI()+", "+pos.getMail()+".";
            consul.grabarLinea(linea);
        }
        consul.cerrar();
    }
    
    // Metodo que recibe un nombre e indica si ese nombre ya fue utilizado para un puesto
    public boolean verificarPuestoUnicoPorNombre(String elNombre){
        ArrayList<Puesto> puestos = this.getListaPuestos();
        boolean esta = false; 
        for(Puesto p:puestos){
            if(p.getNombre().toLowerCase().equals(elNombre.toLowerCase())){
                esta = true;
            }
        }
        return esta;
    }
    
    // Metodo que valida si la cedula y el numero dado son ambos números
    public boolean validarCiyTelNumerico(String ci, String tel){
        boolean es = false;
        try{
            Integer.parseInt(ci);
            Integer.parseInt(tel);
            es = true;
        }catch (NumberFormatException e) {
            es = false;
        }
        return es;
    }
   
    // Metodo que devuelve una lista con los postulates ordenada crecientemente por cedula
    public ArrayList<Postulante> postulantesOrdenadosPorCI(){
        ArrayList<Postulante> lista = this.listaPostulantes;
        Collections.sort(lista, new Comparator<Postulante>(){
            public int compare(Postulante p1, Postulante p2){
                return Integer.parseInt(p1.getCI()) - Integer.parseInt(p2.getCI());
            }
        });
        return lista;
    }
    
    // Metodo que devuelve las entrevistas de un postulante que contengan una texto especifico
    public ArrayList<Entrevista> entrevistasDePostulanteConPal(Postulante p, String pal){
        ArrayList<Entrevista> ret = new ArrayList<>();
        for (Entrevista e: this.entrevistasDePostulante(p)){
            if (e.getComentario().toLowerCase().contains(pal.toLowerCase())){
                ret.add(e);
            }
        }
        return ret;
    }
}

