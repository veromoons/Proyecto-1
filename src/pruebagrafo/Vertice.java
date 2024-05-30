
package pruebagrafo;

/**
 *
 * @author verol
 */
public class Vertice {
    
    private int numVertice; 
    private char letra;
    private Lista listaAdy;

    public Vertice(char l) {
        this.numVertice = -1;
        this.letra = l;
        this.listaAdy = new Lista();
    }

    /**
     * @return the numVertice
     */
    public int getNumVertice() {
        return numVertice;
    }

    /**
     * @param numVertice the numVertice to set
     */
    public void setNumVertice(int numVertice) {
        this.numVertice = numVertice;
    }

    /**
     * @return the letra
     */
    public char getLetra() {
        return letra;
    }

    /**
     * @param letra the letra to set
     */
    public void setLetra(char letra) {
        this.letra = letra;
    }

    /**
     * @return the listaAdy
     */
    public Lista getListaAdy() {
        return listaAdy;
    }

    /**
     * @param listaAdy the listaAdy to set
     */
    public void setListaAdy(Lista listaAdy) {
        this.listaAdy = listaAdy;
    }

    
    

}
    
