
package pruebagrafo;

/**
 *
 * @author verol
 */
public class Arista {
    
    private int destino;
    private char letraDestino;

    public Arista(int d, char ld) {
        this.destino = d;
        this.letraDestino = ld;
    }

    /**
     * @return the destino
     */
    public int getDestino() {  
        return destino;
    }

    /**
     * @return the letraDestino
     */
    public char getLetraDestino() {
        return letraDestino;
    }
    
    
    
}
