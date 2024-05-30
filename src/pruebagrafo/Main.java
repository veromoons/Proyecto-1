
package pruebagrafo;
import leertxt.LeerTxt;
import Interfaces.Ventana1;


/**
 *
 * @author verol
 */
public class Main {

    public static Grafo nuevoGrafo = new Grafo(16);

    public static void main(String[] args) {
       
        //util para pruebas para dsf y bsf
        String[] palabrasPrueba={"LOL", "AZUL", "PETALO", "ROSA", "MORA", "AMARILLO"};

        char[][] sopaPrueba = { 
            {'L', 'R', 'O', 'S'}, 
            {'E', 'O', 'L', 'A'}, 
            {'I', 'M', 'R', 'A'}, 
            {'M', 'O', 'O', 'P'} 
        };
        
         Ventana1 v1 = new Ventana1();
         v1.setVisible(true);
         
     }
}

