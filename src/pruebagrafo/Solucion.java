
package pruebagrafo;

/**
 *
 * 
 */
public class Solucion { 
    private String[] palabraValidada;
    private int cantidadPalabras;

    public Solucion(Grafo grafo) {
        palabraValidada = new String[0];
        cantidadPalabras = 0;
    }

    public boolean bfs(String palabra, int verticeInicial, Grafo grafo) { 
        boolean encontrada = false;
        for (int v = 0; v < grafo.getNumVertices(); v++) {
            boolean[] visitados = new boolean[grafo.getNumVertices()]; 
            ListaNumVertice cola = new ListaNumVertice(); 
            ListaNumVertice colaAux = new ListaNumVertice(); 
            int posicionLetra = 0; 

            cola.preinsertarPrimero(v); 

            while (colaAux.getiN() != palabra.length() && cola.getiN() != 0) {
                NodoNumVertice aux = cola.getFirst();

                if (grafo.getListaVertices()[aux.getInfo()].getLetra() == palabra.charAt(posicionLetra)) {
                    visitados[aux.getInfo()] = true; 
                    posicionLetra++; 
                    colaAux.preinsertarPrimero(aux.getInfo()); 
                    cola.destructor(); 

                    Nodo pAux = grafo.getListaVertices()[aux.getInfo()].getListaAdy().getFirst(); 

                    for (int ady = 0; ady < grafo.getListaVertices()[aux.getInfo()].getListaAdy().getiN(); ady++) {
                        if (!visitados[pAux.getInfo().getDestino()]) {
                            cola.preinsertarPrimero(pAux.getInfo().getDestino()); 
                        }
                        pAux = pAux.getNext(); 
                    }
                } else {
                    cola.eliminarPrimero(); 
                }
            }

            if (colaAux.getiN() == palabra.length()) {
                encontrada = true;
                break;
            } else {
                encontrada = false;
            }
        }
        return encontrada;
    }

    public boolean buscarPalabraDFS(String palabra) {
        boolean[][] visitado = new boolean[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (dfs(i, j, palabra, 0, visitado)) {
                    agregarPalabraValidada(palabra);
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
        if (i < 0 || i >= 4 || j < 0 || j >= 4 || visitado[i][j] || Main.grafo.getListaVertices()[i * 4 + j].getLetra() != palabra.charAt(indice)) {
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

    private void agregarPalabraValidada(String palabra) {
        String[] nuevoDiccionario = new String[cantidadPalabras + 1];
        for (int i = 0; i < cantidadPalabras; i++) {
            nuevoDiccionario[i] = palabraValidada[i];
        }
        nuevoDiccionario[cantidadPalabras] = palabra;
        palabraValidada = nuevoDiccionario;
        cantidadPalabras++;
    }

    public String[] getPalabraValidada() {
        return palabraValidada;
    }

    public void buscarPalabrasValidadasDFS(Diccionario diccionario) {
        NodoListaSimple palabraActual = diccionario.obtenerLista().getFirst();
        while (palabraActual != null) {
            buscarPalabraDFS(palabraActual.getInfo().toString());
            palabraActual = palabraActual.getNext();
        }
    }
}

   
