
package pruebagrafo;

/**
 * Clase para implementar metodos para la creacion de un vertice
 * @author veronicaluna
 */

public class Vertice {
    
    
    private int numVertice; 
    private char letra;
    private Lista listaAdy;
    
    /**
     * Constructor 
     * @param caracter l que es la letra que va a tener ese vertice para la sopa de letras en el grafo que la simula
     */

    public Vertice(char l) {
        this.numVertice = -1;
        this.letra = l;
        this.listaAdy = new Lista();
    }

    /**
     * @return la posicion de ese vertice 
     */
    public int getNumVertice() {
        return numVertice;
    }

    /**
     * @param numVertice la posicion a settear
     */
    public void setNumVertice(int numVertice) {
        this.numVertice = numVertice;
    }

    /**
     * @return la letra que tiene asignada este vertice
     */
    public char getLetra() {
        return letra;
    }

    /**
     * @param la letra a settear
     */
    public void setLetra(char letra) {
        this.letra = letra;
    }

    /**
     * @return retorna la lista de adyacentes del vertice
     */
    public Lista getListaAdy() {
        return listaAdy;
    }

    /**
     * @param listaAdy la lista de adyacentes a settear
     */
    public void setListaAdy(Lista listaAdy) {
        this.listaAdy = listaAdy;
    }

    
    

}
    
