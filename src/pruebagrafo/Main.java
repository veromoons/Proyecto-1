
package pruebagrafo;

import Interfaces.Ventana1;

/**
 * Clase main
 * @author veronicaluna
 */
public class Main {

    public static Grafo grafo = new Grafo(16);
    /**
     * Metodo para incializar el programa, abriendo la primera ventana de la interfaz
     * @param args 
     */
    public static void main(String[] args) {

        Ventana1 v1 = new Ventana1();
        v1.setVisible(true);
    }
}


