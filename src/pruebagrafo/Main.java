
package pruebagrafo;



/**
 *
 * @author verol
 */
public class Main {

    public static Grafo nuevoGrafo = new Grafo(16);

    public static void main(String[] args) {
       
        
        String[] palabrasPrueba={"LOL", "AZUL", "PETALO", "ROSA", "MORA", "AMARILLO"};

        
        //prueba para el metodo crearGrafo, comentando agregarVertice al final

        char[][] sopaPrueba = { 
            {'L', 'R', 'O', 'S'}, 
            {'E', 'O', 'L', 'A'}, 
            {'I', 'M', 'R', 'A'}, 
            {'M', 'O', 'O', 'P'} 
        };

        nuevoGrafo.crearGrafo(sopaPrueba);
        
        //prueba de si se anade bien todo al grafo
        for (int i = 0; i < 16; i++) {
            Vertice vertice = nuevoGrafo.getListaVertices()[i];
            System.out.print("Vertice " + vertice.getNumVertice() + " (" + vertice.getLetra() + "): ");
            Nodo aux = vertice.getListaAdy().primero();
            while (aux != null) {                       //iteramos en la lista de adyacentes (en los nodos que contienen aristas que son a su vez el numero del vertice adyacente o destino y la letra del mismo),
                System.out.print(aux.getInfo().getLetraDestino() + " "); 
                aux = aux.getNext();
            }
            System.out.println();
        }


      

    }
   }

