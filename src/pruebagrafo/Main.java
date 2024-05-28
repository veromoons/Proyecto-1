
package pruebagrafo;

import Interfaces.Ventana1;
import leertxt.LeerTxt;

/**
 *
 * @author verol
 */
public class Main {

    public static Grafo nuevoGrafo = new Grafo(16);

    public static void main(String[] args) {

        
        //prueba para el metodo crearGrafo, comentando agregarVertice al final
        //char[][] sopaPrueba = { 
            //{'A', 'B', 'C', 'D'}, 
            //{'E', 'F', 'G', 'H'}, 
            //{'I', 'J', 'K', 'L'}, 
            //{'M', 'N', 'O', 'P'} 
        //};

        //nuevoGrafo.crearGrafo(sopaPrueba);
        //prueba lectura txt
        
        Ventana1 v1 = new Ventana1();
        v1.setVisible(true);

    }

}
