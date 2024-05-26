
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
     * @return the id
     */
    public int setNumVertice() {
        return numVertice;
    }

    /**
     * @param id the id to set
     */
    public void setNumVertice(int num) {
        this.numVertice = num;
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
    
    
    
    
}
