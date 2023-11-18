//Salvador Depons(303738) y Valentina Velazquez(305278)
package Prueba;
import Dominio.*;
import Interfaz.*;

// Clase para probar el programa
public class Prueba {
    public static void main(String args[]){
        // Creo el sistema y creo la ventana inicio
        Sistema s  = new Sistema();
        Inicio i = new Inicio(s);
        i.setVisible(true);
        
    }  
}
