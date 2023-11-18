//Salvador Depons(303738) y Valentina Velazquez(305278)

package Dominio;
import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

// Clase para la lectura de archivos
public class ArchivoLectura {
    private Scanner in;
    private String linea;
    
    // Metodo para la lectura de un archivo 
    public ArchivoLectura(String unNombre) {
        try {
            in = new Scanner(Paths.get(unNombre));
        }
        catch (IOException e) {
            System.err.println("Error ");
            System.exit(1);
        }
    }
    
    // Metodo que indica si existen mas lineas en un archivo
    public boolean hayMasLineas() {
        boolean hay = false;
        linea = null;
        if (in.hasNext()){
            linea = in.nextLine();
            hay = true;
        }
        return hay;
    }
    
    // Metodo que devuelve la ultima linea leida
    public String linea() {
        return linea;
    }
   
    // Metodo que cierra el archivo que se esta leyendo 
    public void cerrar() {
        in.close();
    }
}