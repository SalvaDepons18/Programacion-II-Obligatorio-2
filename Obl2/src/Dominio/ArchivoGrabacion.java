//Salvador Depons(303738) y Valentina Velazquez(305278)

package Dominio;
import java.io.*;
import java.util.Formatter;

// Clase para la grabacion de archivos
public class ArchivoGrabacion {
    private Formatter out;
    
    // Constructor del archivo
    public ArchivoGrabacion(String unNombre) {
        try {
            out = new Formatter(unNombre);
        }
        catch (FileNotFoundException e) {
            System.out.println("no se puede crear");
            System.exit(1);
        }
        catch (SecurityException e) {
            System.out.println("sin permisos");
            System.exit(1);
        }
    }
    
    // metodo que dependiendo del boolean extiende o sobreescribe el archivo 
    public ArchivoGrabacion(String unNombre, boolean ext) {
        try {
            FileWriter f = new FileWriter(unNombre, ext);
            out= new Formatter(f);
        }
        catch (IOException e) {
            System.out.println("no se puede crear/extender");
            System.exit(1);
        }
    }
    
    // metodo que recibe una texto y lo inserta en el archivo
    public void grabarLinea(String linea) {
        out.format("%s%n", linea);
    }
    
    // metodo que cierra el archivo
    public void cerrar() {
        out.close();
    }
}
