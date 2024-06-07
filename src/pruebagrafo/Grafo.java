
package pruebagrafo;

/**
 *
 * @author veronicaluna
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

    public Grafo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void agregarVertice(char letra){             
        Vertice v = new Vertice(letra); 
        v.setNumVertice(getNumVertices());               //se hizo un id numerico para c/vertice (del 0 al 15)
        listaVertices[getNumVertices()] = v;
        numVertices++;                      //las posiciones entonces de listaVertices va de 0 al 15 para manejar crearGrafo tipo matriz con i y j
    }
    
    public boolean existeArista(int a, int b){
        Nodo aux = this.listaVertices[a].getListaAdy().primero();
        boolean encontrado=false;
        while(aux!=null && encontrado==false){
            if (b==aux.getInfo().getDestino()){
                encontrado=true;
            }else{
                encontrado=false;
            }
            aux=aux.getNext();
        }
        return encontrado;
    }
    
    public void agregarArista(int origen, int destino){
         if (origen < 0 || origen >= getNumVertices() || destino < 0 || destino >= getNumVertices()) { 
            throw new IllegalArgumentException("Uno o ambos vértices no existen.");
        }
        
        if (existeArista(origen,destino)==false){
            
            Arista ab = new Arista(destino, this.listaVertices[destino].getLetra());
            Arista ba = new Arista(origen, this.listaVertices[origen].getLetra());
            listaVertices[origen].getListaAdy().preinsertarPrimero(ab);
            listaVertices[destino].getListaAdy().preinsertarPrimero(ba);        //se preinserta en la lista ya que sgeun el libro: La inserción se hace como primer nodo para que el tiempo sea constante, O(1)
        }
    }
    
    public void crearGrafo(char[][] tableroLetras) {
        int tamanoiyj = tableroLetras.length; //va a ser 4, ya que es 4x4 coinciden i y j o se puede poner 4 y ya, solo para generalizarlo y que sea mas friendly

        // agg vertices (letras) del array al grafo una a una
        for (int i = 0; i < tamanoiyj; i++) {
            for (int j = 0; j < tamanoiyj; j++) {
                agregarVertice(tableroLetras[i][j]);
            }
        }

        // se itera en i (filas) y j (columnas). Actual va a ser para i<4 (4 filas de 0 a 3) y j<4 (4 columnas de 0 a 3) porque es una matriz 4x4, y actual va a ser el numVertice (de 0 a 15 que da 16 vertices en total, 4x4)
        for (int i = 0; i < tamanoiyj; i++) {
            for (int j = 0; j < tamanoiyj; j++) {
                int actual = i * tamanoiyj + j;

                // direcciones de posibles adyacentes (el centro es donde iria el vertice actual) y se evaluan las diferentes posibles posiciones de los vertices adyacentes
                // recordar que el par es: (i,j). Entonces, siendo que el actual es (i,j), por ej la posicion de justo arriba seria un (i-1, misma columna j) por lo que es (-1,0)
                int[][] posiblesPosiciones = {
                    {-1, -1}, {-1, 0}, {-1, 1},
                    {0, -1},            {0, 1},
                    {1, -1}, {1, 0}, {1, 1}
                };
                
                for (int parIJ = 0; parIJ < posiblesPosiciones.length; parIJ++) {
                    int[] subindices = posiblesPosiciones[parIJ];  //subindices i o j de una matriz, i es el elemento de fila y j el de columna
                    int nuevai = i + subindices[0]; //0 es la posicion de i, 1 es la posicion de j
                    int nuevaj = j + subindices[1]; 
                    int nuevoDestino = nuevai * tamanoiyj + nuevaj; //se llama asi porque es la posicion o numVertice de la arista destino nueva si pasa el if posterior
                
                    // aqui se evalua que las posiciones adyacentes antes evaluadas sean posibles de una en una (que sean mayores o iguales a 0 y menores a 4 (i y j van de 0 a 3)
                    if (nuevai >= 0 && nuevai < tamanoiyj && nuevaj >= 0 && nuevaj < tamanoiyj) {
                        //System.out.println("el actual es: "+ actual+"   y conecta con: "+nuevoIndice);  //para probar que sirva este metodo con lo q esta en el main
                        agregarArista(actual, nuevoDestino);
                    }
                }
            }
        }
    }

    
    public String mostrarGrafoTablero(){  
        String tablero = "";
        for (int i = 0; i < 4; i++) {
            tablero += "  " + this.listaVertices[i].getLetra() + "  ";
        }
        tablero += "\n\n" ;
        for (int i = 4; i < 8; i++) {
            tablero += "  " + this.listaVertices[i].getLetra() + "  ";
        }
        tablero += "\n\n";
        for (int i = 8; i < 12; i++) {
            tablero += "  " + this.listaVertices[i].getLetra() + "  ";
        }
        tablero += "\n\n";
        for (int i = 12; i < 16; i++) {
            tablero += "  " + this.listaVertices[i].getLetra() + "  ";
        }
        return tablero;    
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

    /**
     * @return the numVertices
     */
    public int getNumVertices() {
        return numVertices;
    }
    
    
    
    
    
}
