
package pruebagrafo;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author verol
 */
public class Grafo {
    
    private int numVertices;
    private int max;
    private Vertice[] listaVertices;

    public Grafo(int t) {
        this.numVertices = 0; 
        this.max = t; 
        this.listaVertices = new Vertice[t];
    }
    
    public void agregarVertice(char letra){             
        Vertice v = new Vertice(letra); 
        v.setNumVertice(numVertices);               //se hizo un id numerico para c/vertice (del 0 al 15)
        listaVertices[numVertices] = v;
        numVertices++;                      //las posiciones entonces de listaVertices va de 0 al 15 para manejar crearGrafo tipo matriz con i y j
    }
    
    public void agregarArista(int origen, int destino){
         if (origen < 0 || origen >= numVertices || destino < 0 || destino >= numVertices) {
            throw new IllegalArgumentException("Uno o ambos vértices no existen.");
        }
         
        Arista ab = new Arista(origen);
        Arista ba = new Arista(destino);
        listaVertices[origen].getListaAdy().preinsertarPrimero(ab);
        listaVertices[destino].getListaAdy().preinsertarPrimero(ba);        //se preinserta en la lista ya que sgeun el libro: La inserción se hace como primer nodo para que el tiempo sea constante, O(1).
        
    }
    
    public void crearGrafo(char[][] tableroLetras) {
        int dimension = tableroLetras.length; //va a ser 4

        // agg vertices (letras) del array al grafo una a una
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                agregarVertice(tableroLetras[i][j]);
            }
        }

        // se itera en i (filas) y j (columnas). Actual va a ser para i<4 (4 filas de 0 a 3) y j<4 (4 columnas de 0 a 3) porque es una matriz 4x4, y actual va a ser el numVertice (de 0 a 15 que da 16 vertices en total, 4x4)
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                int actual = i * dimension + j;

                // direcciones de posibles adyacentes (el centro es donde iria el vertice actual) y se evaluan las diferentes posibles posiciones de los vertices adyacentes
                // recordar que el par es: (i,j). Entonces, siendo que el actual es (i,j), por ej la posicion de justo arriba seria un (i-1, misma columna j) por lo que es (-1,0)
                int[][] direcciones = {
                    {-1, -1}, {-1, 0}, {-1, 1},
                    {0, -1},         {0, 1},
                    {1, -1}, {1, 0}, {1, 1}
                };

                for (int[] d : direcciones) { //para cada subarray en el array doble "direcciones"...
                    int nuevai = i + d[0]; //0 es la posicion de i, 1 es la posicion de j
                    int nuevaj = j + d[1];
                    int nuevoIndice = nuevai * dimension + nuevaj;

                    // aqui se evalua que las posiciones adyacentes antes evaluadas sean posibles de una en una (que sean mayores o iguales a 0 y menores a 4 (i y j van de 0 a 3)
                    if (nuevai >= 0 && nuevai < dimension && nuevaj >= 0 && nuevaj < dimension) {
                        //System.out.println("el actual es: "+ actual+"   y conecta con: "+nuevoIndice);  //para probar que sirva este metodo con lo q esta en el main
                        agregarArista(actual, nuevoIndice);
                    }
                }
            }
        }
    }
    

 public boolean buscarPalabraDFS(String palabra) {
        boolean[][] visitado = new boolean[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (dfs(i, j, palabra, 0, visitado)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, String palabra, int indice, boolean[][] visitado) {
        if (indice == palabra.length()) {
            return true;
        }
        if (i < 0 || i >= 4 || j < 0 || j >= 4 || visitado[i][j] || listaVertices[i * 4 + j].getLetra() != palabra.charAt(indice)) {
            return false;
        }
        visitado[i][j] = true;
        int[][] direcciones = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        for (int[] d : direcciones) {
            if (dfs(i + d[0], j + d[1], palabra, indice + 1, visitado)) {
                return true;
            }
        }
        visitado[i][j] = false;
        return false;
    }
        
   
    

    /**
     * @return the max
     */
    public int getMax() {
        return max;
    }

    /**
     * @param max the max to set
     */
    public void setMax(int max) {
        this.max = max;
    }

    /**
     * @return the listaVertices
     */
    public Vertice[] getListaVertices() {
        return listaVertices;
    }

    /**
     * @param listaVertices the listaVertices to set
     */
    public void setListaVertices(Vertice[] listaVertices) {
        this.listaVertices = listaVertices;
    }
    
    
    
    
    
}
