
package pruebagrafo;

/**
 *
 * @author verol
 */
public class Solucion {
     
    public boolean bfs(String palabra, int verticeInicial,Grafo grafo){   
        boolean encontrada= false;
        for (int v = 0; v < grafo.getNumVertices(); v++) {
            boolean[] visitados = new boolean[grafo.getNumVertices()]; // Lista de visitados reiniciada para cada vértice inicial
            ListaNumVertice cola = new ListaNumVertice(); // Cola para los adyacentes a evaluar
            ListaNumVertice colaAux = new ListaNumVertice(); // Cola para la secuencia de la palabra encontrada
            int posicionLetra = 0; // Posición de la letra actual en la palabra buscada

            cola.preinsertarPrimero(v); // Añadir el vértice inicial a la cola

            while (colaAux.getiN() != palabra.length() && cola.getiN() != 0) {
                NodoNumVertice aux = cola.getFirst();

              //  System.out.println("aux es: " + aux.getInfo());
              //  System.out.println(grafo.getListaVertices()[aux.getInfo()]);

                if (grafo.getListaVertices()[aux.getInfo()].getLetra() == palabra.charAt(posicionLetra)) {
                    visitados[aux.getInfo()] = true; 
                    posicionLetra++; 
                    colaAux.preinsertarPrimero(aux.getInfo()); // Añadir el vértice actual a la secuencia
                    cola.destructor(); // Vaciar la cola para los adyacentes del vértice actual

                    Nodo pAux = grafo.getListaVertices()[aux.getInfo()].getListaAdy().getFirst(); // Primer adyacente del vértice actual
                   // System.out.print("adyacentes en if: ");
                    //grafo.getListaVertices()[aux.getInfo()].getListaAdy().recorrer();

                    for (int ady = 0; ady < grafo.getListaVertices()[aux.getInfo()].getListaAdy().getiN(); ady++) {
                        if (!visitados[pAux.getInfo().getDestino()]) {
                            cola.preinsertarPrimero(pAux.getInfo().getDestino()); // Añadir los adyacentes a la cola
                        }
                        pAux = pAux.getNext(); // Siguiente adyacente
                    }
                   // System.out.println("entro a if");
                } else {
                   // System.out.println("entro a else");
                    //cola.recorrer();
                    cola.eliminarPrimero(); // Eliminar el primer elemento de la cola si no coincide con la letra actual
                }
                //System.out.println(colaAux.getiN() == palabra.length());
            }

            if (colaAux.getiN() == palabra.length()) {
                encontrada=true;
               // System.out.println("Palabra encontrada");
                //colaAux.recorrer();
                break;
            } else {
                encontrada=false;
               // System.out.println("Palabra no encontrada");
            }

        }
        return encontrada;
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
        if (i < 0 || i >= 4 || j < 0 || j >= 4 || visitado[i][j] ||  Main.grafo.getListaVertices()[i * 4 + j].getLetra() != palabra.charAt(indice)) {  //en recursividad, se trabaja con variables locales, cada llamada tiene acceso a las variables locales definidas en el ámbito de esa llamada
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
    
}
        
        
        
   
